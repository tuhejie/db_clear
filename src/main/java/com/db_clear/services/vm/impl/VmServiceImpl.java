package com.db_clear.services.vm.impl;

import com.alibaba.fastjson.JSON;
import com.db_clear.entities.auto.*;
import com.db_clear.mappers.auto.*;
import com.db_clear.mappers.custom.*;
import com.db_clear.services.base.BaseServiceImpl;
import com.db_clear.services.vm.VmService;
import com.db_clear.utils.collection.CollectionUtils;
import com.db_clear.utils.math.NumberUtils;
import com.db_clear.utils.string.StringUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @Author ：Created by tuhj
 * @Date ：Created in 2018-12-08 10:57
 * @Description ：
 */
@Service
public class VmServiceImpl extends BaseServiceImpl<Vm> implements VmService {

    @Autowired
    private VmCustomMapper vmMapper;
    @Autowired
    private VmBoxCustomMapper vmBoxMapper;
    @Autowired
    private VmCodeCustomMapper vmCodeMapper;
    @Autowired
    private VmMachineConfigCustomMapper vmMachineConfigMapper;
    @Autowired
    private VmCurrentStatusCustomMapper vmCurrentStatusMapper;


    @Transactional
    @Override
    public String moveData(String numMark) {

        try {
            // 根据需要迁移的numMark在mq_vm_copy表中查询vm记录
            Vm vm = vmMapper.selectVmCopyListByNumMark(numMark);

            // 获得copy表的vmId
            Long oldVmId = vm.getId();


            // 在mq_vm_code 表中查询numMark的最大值
            String maxNumMark = vmCodeMapper.selectMaxNumMarkFromVmCode();
            String str = maxNumMark.substring(1);
            int num = Integer.valueOf(str) + 1;
            maxNumMark = "B" + num;

            // 1.迁移 mq_vm 表
            // 将查到的numMark + 1 ，更新mq_vm_copy表中查到的vm记录，主键id设为null，再insert，返回新的vmId
            vm.setId(null);
            vm.setNummark(maxNumMark);
            vm.setPlotid(null);
            vm.setIsOpenAutoTempControl(false);
            vm.setCurrentoperatorid(NumberUtils.LONG_ZERO);
            vm.setQualityStatus(4);
            vm.setVmStatus(0);
            vm.setCreateTime(new Date());
            vm.setLastTaskTime(null);
            vm.setLastSupplyTime(null);
            vmMapper.insert(vm);

            // 获取新的vmId
            Long newVmId = vm.getId();


            // 2.迁移 mq_vm_box 表
            // 查询猫小贩系统中的 vm_box 数据
            List<VmBox> vmBoxList = vmBoxMapper.selectVmBoxListByVmId(oldVmId);
            if (CollectionUtils.isNotEmpty(vmBoxList)) {
                for (VmBox vmBox : vmBoxList) {
                    vmBox.setId(null);
                    vmBox.setVmId(newVmId);
                    vmBox.setOpeProductId(NumberUtils.LONG_MINUS_ONE);
                    vmBox.setBoxStatus(Byte.valueOf((byte) 3));
                    vmBox.setCurrentStock(0);
                    // vmBoxMapper.insert(vmBox);
                    vmBoxMapper.insertVmBox(vmBox);
                }
            }


            // 在猫小贩系统中查机器码列表
            List<VmCode> vmCodeList = vmCodeMapper.selectVmCodeByVmId(oldVmId);
            if (CollectionUtils.isNotEmpty(vmCodeList)) {
                for (VmCode vmCode : vmCodeList) {
                    vmCode.setId(null);
                    vmCode.setVmId(newVmId);
                    vmCode.setNummark(maxNumMark);
                    vmCode.setCreatetime(new Date());
                    vmCodeMapper.insert(vmCode);
                }
            }

            boolean flag = false;

            // 在猫小贩系统中查询格子码列表(如果是格子机，会有数据返回)
            List<VmCode> vmBoxCodeList = vmCodeMapper.selectVmBoxCodeByVmId(oldVmId);
            if (CollectionUtils.isNotEmpty(vmBoxCodeList)) {
                flag = true;
                for (VmCode vmCode : vmBoxCodeList) {
                    vmCode.setId(null);
                    vmCode.setVmId(newVmId);
                    vmCode.setCreatetime(new Date());
                    vmCodeMapper.insert(vmCode);
                }
            }

            // 格子码有数据,表示当前这台机器是格子机，更新mq_vm_code 中的 vmbox_id 为新的vmbox_id
            if (flag) {
                vmCodeMapper.updateVmBoxIdInVmCode(newVmId);
            } else {
                // 当前这台机器是弹簧机，更新mv_vm_code 表中的print_modal_id= 62
                vmCodeMapper.updatePrintModelIdInVmCode(newVmId);
            }

            // mq_vm_machine_config 迁移
            String macAddress = vm.getMacAddress();
            if (StringUtils.isNotBlank(macAddress)) {
                List<VmMachineConfig> configList = vmMachineConfigMapper.selectVmMachineConfigByMacAddress(macAddress);
                if (CollectionUtils.isNotEmpty(configList)) {
                    for (VmMachineConfig config : configList) {
                        config.setId(null);
                        config.setVmId(Integer.valueOf(newVmId.toString()));
                        config.setUpdateTime(new Date());
                        vmMachineConfigMapper.insert(config);
                    }
                }
            }

            // mq_vm_current_status 迁移
            VmCurrentStatus vmCurrentStatus = vmCurrentStatusMapper.selectVmCurrentStatusByVmId(oldVmId);
            if (vmCurrentStatus != null){
                vmCurrentStatus.setId(null);
                vmCurrentStatus.setVmId(newVmId);
                vmCurrentStatus.setOperatorId(NumberUtils.LONG_ZERO);
                vmCurrentStatusMapper.insert(vmCurrentStatus);
            }

            // 统一修改 mq_vm、mq_vm_box、mq_vm_code 中的 qrcode
            vmMapper.updateAllQrCode(newVmId);

            return maxNumMark;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

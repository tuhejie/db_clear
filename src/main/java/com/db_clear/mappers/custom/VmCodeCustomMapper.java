package com.db_clear.mappers.custom;

import com.db_clear.entities.auto.VmCode;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VmCodeCustomMapper extends Mapper<VmCode> {

    /**
     * 查斑码头系统中 numMark 的最大值
     * @return
     */
    String selectMaxNumMarkFromVmCode();

    /**
     * 在猫小贩系统中查机器码列表
     */
    List<VmCode> selectVmCodeByVmId(Long vmId);

    /**
     * 在猫小贩系统冲查询格子码列表（如果是格子机）
     * @param vmId
     * @return
     */
    List<VmCode> selectVmBoxCodeByVmId(Long vmId);

    /**
     * 如果是格子机，更新 mq_vm_code 中的 vmbox_id 为新的 vmbox_id
     * @param vmId
     * @return
     */
    int updateVmBoxIdInVmCode(Long vmId);

    /**
     * 当前这台机器是弹簧机，更新mv_vm_code 表中的print_modal_id= 62 (只针对弹簧机)
     * @param vmId
     * @return
     */
    int updatePrintModelIdInVmCode(Long vmId);

    /**
     * 部分格子机 mq_vm_code 表中的numMark 为null，需手动更新mq_vm_box 表中的box_number到mq_vm_code中的numMark
     * @param vmId
     * @return
     */
    int updateVmCodeNumMark(Long vmId);
}
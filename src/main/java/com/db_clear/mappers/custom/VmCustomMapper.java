package com.db_clear.mappers.custom;

import com.db_clear.entities.auto.Vm;
import tk.mybatis.mapper.common.Mapper;

public interface VmCustomMapper extends Mapper<Vm> {
    /**
     * 根据numMark查vm_mxf表的记录
     * @param numMark
     * @return
     */
    Vm selectVmCopyListByNumMark(String numMark);

    /**
     * 根据MacAddress查询机器信息
     * @param macAddress
     * @return
     */
    Vm selectVmByMacAddress(String macAddress);

    /**
     * 统一修改qrcode
     * @param vmId
     * @return
     */
    int updateAllQrCode(Long vmId);
}
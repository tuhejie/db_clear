package com.db_clear.mappers.custom;

import com.db_clear.entities.auto.VmMachineConfig;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VmMachineConfigCustomMapper extends Mapper<VmMachineConfig> {

    /**
     * 根据mac地址查询机器配置信息
     * @param macAddress
     * @return
     */
    List<VmMachineConfig> selectVmMachineConfigByMacAddress(String macAddress);
}
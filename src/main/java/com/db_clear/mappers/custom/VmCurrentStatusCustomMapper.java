package com.db_clear.mappers.custom;

import com.db_clear.entities.auto.VmCurrentStatus;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VmCurrentStatusCustomMapper extends Mapper<VmCurrentStatus> {

    VmCurrentStatus selectVmCurrentStatusByVmId(Long vmId);
}
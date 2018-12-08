package com.db_clear.mappers.custom;

import com.db_clear.entities.auto.VmBox;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VmBoxCustomMapper extends Mapper<VmBox> {

    List<VmBox> selectVmBoxListByVmId(Long vmId);

    int insertVmBox(VmBox vmBox);
}
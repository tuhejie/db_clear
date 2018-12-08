package com.db_clear.services.vm;

import com.db_clear.entities.auto.Vm;
import com.db_clear.services.base.impl.BaseService;

/**
 * @Author ：Created by tuhj
 * @Date ：Created in 2018-12-08 10:57
 * @Description ：
 */
public interface VmService extends BaseService<Vm> {


    String moveData(String numMark);

}

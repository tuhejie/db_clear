package com.db_clear.mappers.custom;

import java.util.List;

import com.db_clear.entities.auto.Vm;
import com.db_clear.entities.custom.VmCustom;

public interface VmCustomMapper {

	/**
	 * @title:TODO 查询设备经纬度信息
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月25日 下午3:23:13
	 * @return
	 */
	List<VmCustom> selectVmLongitudeAndLatitude();

	/**
	 * @title:TODO 更新设备的省市区字段
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月25日 下午4:54:45
	 * @param vm
	 * @return
	 */
	int updateVmAddress(Vm vm);

}

package com.db_clear.controllers.vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db_clear.controllers.base.BaseController;
import com.db_clear.services.vm.impl.VmService;

/**
 * @title:TODO 清理设备数据controller
 * @Description:
 * @author: tuhejie
 * @PackageName: com.thj.controller.vm
 * @ClassName: ClearVmDatabaseController
 * @Date: 2018年6月22日 下午4:53:35
 */
@RestController
public class VmDbClearController extends BaseController {

	@Autowired
	private VmService vmService;
	
	/**
	 * @title:TODO 根据经纬度解析省市区
	 * @Description:
	 * @Author: thj
	 * @Date: 2018年6月26日 下午3:53:45
	 */
	@RequestMapping(value = "/clear_vm")
	public void clearVmAddress() {
		vmService.vmLongitudeAndLatitude();
		
	}

}

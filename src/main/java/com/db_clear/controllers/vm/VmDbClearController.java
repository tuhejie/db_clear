package com.db_clear.controllers.vm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db_clear.dto.MoveVmDataDTO;
import com.db_clear.services.vm.VmService;
import com.db_clear.utils.collection.CollectionUtils;
import com.db_clear.utils.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db_clear.controllers.base.BaseController;

import java.util.stream.StreamSupport;

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
	// @RequestMapping(value = "/clear_vm")
	public void clearVmAddress() {
<<<<<<< HEAD
		vmService.vmLongitudeAndLatitude();
=======
		// vmService.vmLongitudeAndLatitude();
>>>>>>> master
	}

	@RequestMapping(value = "/test")
	public String test(){
		System.out.println("hehe");
		return "你好！";
	}

	/**
	 * 将猫小贩系统的数据迁移到斑码头系统
	 */
	@PostMapping(value = "/move_data")
	public String moveData(@RequestBody MoveVmDataDTO dto){
		int j=1;
		String str = dto.getNumMark();
		if (StringUtils.isNotBlank(str)) {
			JSONObject jo = new JSONObject();
			String[] strs = str.split(",");
			for(int i=0; i<strs.length; i++){
				String numMark = StringUtils.trim(strs[i]);
				String newNumMark = vmService.moveData(numMark);
				jo.put(numMark, newNumMark);
				System.out.println("第" +j+ "条记录： " +numMark +"=>"+ newNumMark);
				j++;
			}
			return JSON.toJSONString(jo);
		}else {
			return "没有传入 numMark";
		}
	}


}

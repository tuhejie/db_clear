package com.db_clear.services.vm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.db_clear.entities.auto.Vm;
import com.db_clear.entities.custom.VmCustom;
import com.db_clear.mappers.custom.VmCustomMapper;
import com.db_clear.models.vm.AddressModel;
import com.db_clear.services.vm.impl.VmService;
import com.db_clear.utils.collection.CollectionUtils;
import com.db_clear.utils.map.BaiDuMapUtils;
import com.db_clear.utils.string.StringUtils;

@Service
public class VmServiceImpl implements VmService {

	@Autowired
	private VmCustomMapper vmCustomMapper;

	@Override
	@Transactional
	public void vmLongitudeAndLatitude() {
		List<VmCustom> list = vmCustomMapper.selectVmLongitudeAndLatitude();
		try {
			if (CollectionUtils.isNotEmpty(list)) {
				int count = 0;
				for (VmCustom vm : list) {
					String longitude = String.valueOf(vm.getLongitude());
					String latitude = String.valueOf(vm.getLatitude());
					// 转换成百度地图的经纬度
					JSONObject jo = BaiDuMapUtils.sourceCoordToBaiduCoord(longitude, latitude, "5");
					//
					String lon = StringUtils.EMPTY;
					String lat = StringUtils.EMPTY;
					if (jo != null) {
						lon = String.valueOf(jo.get("longitude"));
						lat = String.valueOf(jo.get("latitude"));
					}
					AddressModel model = BaiDuMapUtils.getAddressModel(lat, lon);

					if (model != null) {
						// 封装更新vm
						Vm record = new Vm();
						record.setId(vm.getId());
						record.setProviceName(model.getProvince());
						record.setCityName(model.getCity());
						record.setAreaName(model.getCounty());
						int i = vmCustomMapper.updateVmAddress(record);
						count += i;
//						count += 1;
						System.out.println("更新记录数： " + count);
					} else {
						System.out.println("空");
					}
				}
			}
		} catch (Exception e) {
		}
	}

}

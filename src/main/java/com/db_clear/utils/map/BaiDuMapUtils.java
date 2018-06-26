package com.db_clear.utils.map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.db_clear.constants.map.MapConstants;
import com.db_clear.models.vm.AddressModel;
import com.db_clear.utils.charset.CharsetUtils;
import com.db_clear.utils.http.HttpClientResponse;
import com.db_clear.utils.http.HttpClientUtils;
import com.db_clear.utils.string.StringUtils;


/**
 * @title:TODO 百度地图工具类
 * @Description:
 * @author: tuhejie
 * @PackageName: com.mianqu.utils
 * @ClassName: BaiDuMapUtil
 * @Date: 2018年4月9日 上午11:20:28
 */
public class BaiDuMapUtils {

	/**
	 * @title:TODO 将其他的经纬度坐标转换成百度的经纬度坐标(单个经纬度坐标)
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月20日 下午3:58:26
	 * @param longitude
	 *            非百度地图的经度
	 * @param latitude
	 *            非百度地图的纬度
	 * @param to
	 *            目标坐标类型： 3：国测局（gcj02）坐标; 4：3中对应的米制坐标; 5：bd09ll(百度经纬度坐标);
	 *            6：bd09mc(百度米制经纬度坐标)
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject sourceCoordToBaiduCoord(String longitude, String latitude, String to)
			throws ClientProtocolException, IOException {
		if (StringUtils.isBlank(latitude)) {
			return null;
		}
		if (StringUtils.isBlank(longitude)) {
			return null;
		}
		String url = "http://api.map.baidu.com/geoconv/v1/";
		Map<String, String> query = new HashMap<>();
		String coords = longitude + "," + latitude;
		query.put("coords", coords);
		// to:目标坐标类型： 3：国测局（gcj02）坐标; 4：3中对应的米制坐标; 5：bd09ll(百度经纬度坐标);
		// 6：bd09mc(百度米制经纬度坐标)
		query.put("to", to);
		query.put("ak", MapConstants.AK);
		query.put("output", "json");
		String charSet = CharsetUtils.UTF_8;
		HttpClientResponse httpClientResponse = HttpClientUtils.doGet(url, null, query, null, charSet);
		JSONArray list = new JSONArray();
		if (httpClientResponse.isSuccess()) {
			String response = httpClientResponse.getResponse();
			JSONObject jo = JSON.parseObject(response);
			list = (JSONArray) jo.get("result");
		}
		JSONObject result = new JSONObject();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				JSONObject jo = list.getJSONObject(i);
				result.put("longitude", String.valueOf(jo.get("x")));
				result.put("latitude", String.valueOf(jo.get("y")));
			}
		}
		return result;
	}

	/**
	 * @title:TODO 根据百度地图的经纬度，获取当前地址的详细信息
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月20日 下午3:59:08
	 * @param latitude
	 *            百度地图的纬度
	 * @param longitude
	 *            百度地图的经度
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject getAddressDetailInfo(String latitude, String longitude)
			throws ClientProtocolException, IOException {
		if (StringUtils.isBlank(latitude)) {
			return null;
		}
		if (StringUtils.isBlank(longitude)) {
			return null;
		}
		String url = "http://api.map.baidu.com/geocoder/v2/";
		Map<String, String> query = new HashMap<>();
		// 将json格式的返回值通过callback函数返回以实现jsonp功能
		// query.put("callback", "renderReverse");
		String location = latitude + "," + longitude;
		query.put("location", location);
		query.put("output", "json");
		// 是否召回传入坐标周边的poi，0为不召回，1为召回
		query.put("pois", "0");
		query.put("ak", MapConstants.AK);
		String charSet = CharsetUtils.UTF_8;
		HttpClientResponse httpClientResponse = HttpClientUtils.doGet(url, null, query, null, charSet);
		String response = httpClientResponse.getResponse();
		JSONObject jo = JSON.parseObject(response);
		JSONObject result = (JSONObject) jo.get("result");
		return result;
	}

	/**
	 * @title:TODO 根据百度地图纬度和经度，获取当前地址的结构化地址信息
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月20日 下午3:57:57
	 * @param latitude
	 *            百度地图的纬度
	 * @param longitude
	 *            百度地图的经度
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getFormattedAddress(String latitude, String longitude)
			throws ClientProtocolException, IOException {
		JSONObject result = getAddressDetailInfo(latitude, longitude);
		if (result == null) {
			return null;
		}
		String formattedAddress = String.valueOf(result.get("formatted_address"));
		return formattedAddress;
	}

	/**
	 * @title:TODO 根据百度地图的纬度和经度，获取当前地址信息，包括：{城市}{区域}{街道}{街道号}
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月20日 下午3:59:32
	 * @param latitude
	 *            百度地图的纬度
	 * @param longitude
	 *            百度地图的经度
	 * @return 获取当前地址信息，包括：{城市}{区域}{街道}{街道号}
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getAddress(String latitude, String longitude) throws ClientProtocolException, IOException {
		JSONObject result = getAddressDetailInfo(latitude, longitude);
		if (result == null) {
			return null;
		}
		JSONObject addressComponent = (JSONObject) result.get("addressComponent");
		String city = String.valueOf(addressComponent.get("city"));
		String district = String.valueOf(addressComponent.get("district"));
		String town = String.valueOf(addressComponent.get("town"));
		String street = String.valueOf(addressComponent.get("street"));
		String streetNumber = String.valueOf(addressComponent.get("street_number"));
		String address = city + district + town + street + streetNumber;
		return address;
	}
	
	/**
	 * @title:TODO 根据百度的经纬度获取包含省市区字段的对象
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月25日 下午3:44:06
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static AddressModel getAddressModel(String latitude, String longitude)
			throws ClientProtocolException, IOException {
		JSONObject result = getAddressDetailInfo(latitude, longitude);
		if (result == null) {
			return null;
		}
		JSONObject addressComponent = (JSONObject) result.get("addressComponent");
		String province = StringUtils.EMPTY;
		String city = StringUtils.EMPTY;
		String county = StringUtils.EMPTY;
		if (addressComponent != null) {
			province = String.valueOf(addressComponent.get("province"));
			city = String.valueOf(addressComponent.get("city"));
			county = String.valueOf(addressComponent.get("district"));
		}
		AddressModel model = new AddressModel();
		model.setProvince(province);
		model.setCity(city);
		model.setCounty(county);
		return model;
	}

	/**
	 * @title:TODO 根据纬度和经度，获取当前城市信息
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月20日 下午4:00:15
	 * @param latitude
	 *            百度地图的纬度
	 * @param longitude
	 *            百度地图的经度
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String getCity(String latitude, String longitude) throws ClientProtocolException, IOException {
		JSONObject result = getAddressDetailInfo(latitude, longitude);
		if (result == null) {
			return null;
		}
		JSONObject addressComponent = (JSONObject) result.get("addressComponent");
		String city = String.valueOf(addressComponent.get("city"));
		return city;
	}

	/**
	 * @title:TODO
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月20日 下午4:00:54
	 * @param mcc
	 *            国家代码：中国代码 460
	 * @param mnc
	 *            网络类型：0移动，1联通(电信对应sid)，十进制
	 * @param lac
	 *            lac(电信对应nid)，十进制
	 * @param ci
	 *            cellid(电信对应bid)，十进制
	 * @param output
	 *            返回格式(csv/json/xml)，默认csv
	 * @return JSONObject 纬度：longitude 经度：longitude
	 *         {@link api地址：http://www.cellocation.com/interfac/}
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject baseStationToCoord(String mcc, String mnc, String lac, String ci, String output)
			throws ClientProtocolException, IOException {
		String url = "http://api.cellocation.com:81/cell/";
		Map<String, String> query = new HashMap<>();
		query.put("mcc", mcc);
		query.put("mnc", mnc);
		query.put("lac", lac);
		query.put("ci", ci);
		query.put("output", output);

		String charSet = CharsetUtils.UTF_8;
		HttpClientResponse clientResponse = HttpClientUtils.doGet(url, null, query, null, charSet);
		String latitude = StringUtils.EMPTY;
		String longitude = StringUtils.EMPTY;
		if (clientResponse.isSuccess()) {
			String response = clientResponse.getResponse();
			JSONObject jo = (JSONObject) JSONObject.parse(response);
			latitude = (String) jo.get("lat");
			longitude = (String) jo.get("lon");
		}
		JSONObject jo = new JSONObject();
		jo.put("latitude", latitude);
		jo.put("longitude", longitude);
		return jo;
	}

}

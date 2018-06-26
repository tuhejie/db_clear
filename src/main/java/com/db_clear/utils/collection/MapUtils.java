package com.db_clear.utils.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db_clear.enums.math.IntegerVal;
import com.db_clear.utils.string.StringUtils;
import com.db_clear.vos.base.RespVO;


/**
 * @title:TODO Map 集合工具类
 * @Description:
 * @author: tuhejie
 * @PackageName: com.thj.utils.collection
 * @ClassName: MapUtils
 * @Date: 2018年6月14日 下午4:28:43
 */
public class MapUtils extends org.apache.commons.collections.MapUtils {

	/**
	 * @TODO: 获取待签名内容, 适合简单POJO对象, 嵌套对象自行重载
	 * @author: weiyanhao
	 * @date: 2018年4月29日 下午12:16:52
	 * @param object
	 * @return
	 */
	public static String getSignText(Object object) {
		StringBuffer content = new StringBuffer();
		JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object));
		if (isEmpty(jsonObject)) {
			return StringUtils.EMPTY;
		}
		List<String> keys = new ArrayList<String>(jsonObject.keySet());
		keys.remove(RespVO.SIGN_KEY);
		keys.remove(RespVO.SIGN_TYPE_KEY);
		Collections.sort(keys);
		int index = IntegerVal.zero.val();
		for (int i = IntegerVal.zero.val(); i < keys.size(); i++) {
			String key = keys.get(i);
			String value = jsonObject.getString(key);
			if (StringUtils.areNotBlank(key, value) && !StringUtils.isNullArrayOrObject(value)) {
				content.append((index == IntegerVal.zero.val() ? StringUtils.EMPTY : StringUtils.AND_SIGN) + key
						+ StringUtils.EQUAL_SIGN + value);
				index++;
			}
		}
		return content.toString();
	}

}

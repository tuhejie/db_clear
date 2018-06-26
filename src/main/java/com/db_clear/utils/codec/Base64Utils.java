package com.db_clear.utils.codec;

import org.apache.commons.codec.binary.Base64;

import com.db_clear.utils.string.StringUtils;


/**
 * @remark: base64编码解码工具类
 * @title: Base64Utils.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午4:57:52
 */
public class Base64Utils extends Base64 {
	
	/**
	 * @title: TODO 字符串base64编码
	 * @description: 
	 * @author: create by weiyanhao
	 * @date: 2018年4月18日 下午1:52:55
	 * @param str
	 * @return
	 */
	public static String encodeBase64String(String str) {
		return encodeBase64String(StringUtils.getBytesUtf8(str));
	}
	
	/**
	 * @title: TODO 字符串base64解码
	 * @description: 
	 * @author: create by weiyanhao
	 * @date: 2018年4月18日 下午1:52:55
	 * @param str
	 * @return
	 */
	public static String decodeBase64String(String str) {
		return StringUtils.newStringUtf8(decodeBase64(str));
	}

}

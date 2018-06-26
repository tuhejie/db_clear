package com.db_clear.vos.base;

import com.alibaba.fastjson.JSON;
import com.db_clear.enums.error.ErrorCodeEnum;


/**
 * 基本响应VO
 * 
 * @title: com.ymfs.web.vos.BaseVO：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2018年3月15日 下午8:35:07
 */
public class BaseVO {

	/**
	 * 业务code
	 */
	private String subCode = ErrorCodeEnum.CODE_20000.getSubCode();

	/**
	 * 业务消息
	 */
	private String subMsg;

	public BaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseVO(String subMsg) {
		super();
		this.subMsg = subMsg;
	}

	public BaseVO(String subCode, String subMsg) {
		super();
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}

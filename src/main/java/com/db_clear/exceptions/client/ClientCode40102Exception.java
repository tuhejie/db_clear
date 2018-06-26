package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 重复的身份认证, 您的账户在另一设备上登录, 请重新登录
 * @title: ClientCode40001Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode40102Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode40102Exception() {
		super(ErrorCodeEnum.CODE_40102.getCode(), ErrorCodeEnum.CODE_40102.getMsg(), ErrorCodeEnum.CODE_40102.getSubCode(), ErrorCodeEnum.CODE_40102.getMsg());
		// TODO Auto-generated constructor stub
	}

	public ClientCode40102Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40102.getCode(), ErrorCodeEnum.CODE_40102.getMsg(), ErrorCodeEnum.CODE_40102.getSubCode(), subMsg);
	}

}

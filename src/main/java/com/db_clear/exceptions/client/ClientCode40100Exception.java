package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 客户端请求需要用户的身份认证, 无token
 * @title: ClientCode40001Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode40100Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode40100Exception() {
		super(ErrorCodeEnum.CODE_40100.getCode(), ErrorCodeEnum.CODE_40100.getMsg(), ErrorCodeEnum.CODE_40100.getSubCode(), ErrorCodeEnum.CODE_40100.getMsg());
		// TODO Auto-generated constructor stub
	}

	public ClientCode40100Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40100.getCode(), ErrorCodeEnum.CODE_40100.getMsg(), ErrorCodeEnum.CODE_40100.getSubCode(), subMsg);
	}
	
}

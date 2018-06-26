package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 客户端身份认证访问令牌已过期, token已过期, 请刷新令牌或重新登录
 * @title: ClientCode40001Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode40101Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode40101Exception() {
		super(ErrorCodeEnum.CODE_40101.getCode(), ErrorCodeEnum.CODE_40101.getMsg(), ErrorCodeEnum.CODE_40101.getSubCode(), ErrorCodeEnum.CODE_40101.getMsg());
		// TODO Auto-generated constructor stub
	}

	public ClientCode40101Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40101.getCode(), ErrorCodeEnum.CODE_40101.getMsg(), ErrorCodeEnum.CODE_40101.getSubCode(), subMsg);
	}

}

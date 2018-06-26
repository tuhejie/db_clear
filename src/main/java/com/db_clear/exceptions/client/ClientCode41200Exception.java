package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 客户端请求的资源权限不足
 * @title: ClientCode41200Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode41200Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode41200Exception() {
		super(ErrorCodeEnum.CODE_41200.getCode(), ErrorCodeEnum.CODE_41200.getMsg(), ErrorCodeEnum.CODE_41200.getSubCode(), ErrorCodeEnum.CODE_41200.getMsg());
		// TODO Auto-generated constructor stub
	}

	public ClientCode41200Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_41200.getCode(), ErrorCodeEnum.CODE_41200.getMsg(), ErrorCodeEnum.CODE_41200.getSubCode(), subMsg);
	}

}

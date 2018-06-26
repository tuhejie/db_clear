package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 客户端身份认证访问令牌无效, token信息错误
 * @title: ClientCode40001Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode40103Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode40103Exception() {
		super(ErrorCodeEnum.CODE_40103.getCode(), ErrorCodeEnum.CODE_40103.getMsg(), ErrorCodeEnum.CODE_40103.getSubCode(), ErrorCodeEnum.CODE_40103.getMsg());
		// TODO Auto-generated constructor stub
	}

	public ClientCode40103Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40103.getCode(), ErrorCodeEnum.CODE_40103.getMsg(), ErrorCodeEnum.CODE_40103.getSubCode(), subMsg);
	}

}

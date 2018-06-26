package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 客户端请求参数错误, 拒绝服务
 * @title: ClientCode40002Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode40002Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode40002Exception() {
		super();
	}

	public ClientCode40002Exception(String subCode, String subMsg) {
		super(ErrorCodeEnum.CODE_40002.getCode(), ErrorCodeEnum.CODE_40002.getMsg(), subCode, subMsg);
	}

	public ClientCode40002Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40002.getCode(), ErrorCodeEnum.CODE_40002.getMsg(), ErrorCodeEnum.CODE_40002.getSubCode(), subMsg);
	}
	
	public ClientCode40002Exception(String subCode, String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_40002.getCode(), ErrorCodeEnum.CODE_40002.getMsg(), subCode, subMsg, cause);
	}
	
	public ClientCode40002Exception(String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_40002.getCode(), ErrorCodeEnum.CODE_40002.getMsg(), ErrorCodeEnum.CODE_40002.getSubCode(), subMsg, cause);
	}

}

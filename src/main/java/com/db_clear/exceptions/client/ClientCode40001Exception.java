package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * @remark: 客户端请求缺少必须的参数, 拒绝服务
 * @title: ClientCode40001Exception.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午12:54:56
 */
public class ClientCode40001Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024412097733933897L;

	public ClientCode40001Exception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientCode40001Exception(String subCode, String subMsg) {
		super(ErrorCodeEnum.CODE_40001.getCode(), ErrorCodeEnum.CODE_40001.getMsg(), subCode, subMsg);
	}

	public ClientCode40001Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40001.getCode(), ErrorCodeEnum.CODE_40001.getMsg(), ErrorCodeEnum.CODE_40001.getSubCode(), subMsg);
	}
	
	public ClientCode40001Exception(String subCode, String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_40001.getCode(), ErrorCodeEnum.CODE_40001.getMsg(), subCode, subMsg, cause);
	}
	
	public ClientCode40001Exception(String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_40001.getCode(), ErrorCodeEnum.CODE_40001.getMsg(), ErrorCodeEnum.CODE_40001.getSubCode(), subMsg, cause);
	}

}

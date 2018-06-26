package com.db_clear.exceptions.client;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

public class ClientCode40300Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7195944563257588129L;

	public ClientCode40300Exception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientCode40300Exception(String subCode, String subMsg) {
		super(ErrorCodeEnum.CODE_40300.getCode(), ErrorCodeEnum.CODE_40300.getMsg(), subCode, subMsg);
	}

	public ClientCode40300Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_40300.getCode(), ErrorCodeEnum.CODE_40300.getMsg(), ErrorCodeEnum.CODE_40300.getSubCode(), subMsg);
	}
	
	public ClientCode40300Exception(String subCode, String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_40300.getCode(), ErrorCodeEnum.CODE_40300.getMsg(), subCode, subMsg, cause);
	}
	
	public ClientCode40300Exception(String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_40300.getCode(), ErrorCodeEnum.CODE_40300.getMsg(), ErrorCodeEnum.CODE_40300.getSubCode(), subMsg, cause);
	}
	
}

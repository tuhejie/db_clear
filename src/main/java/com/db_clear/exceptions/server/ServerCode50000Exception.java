package com.db_clear.exceptions.server;

import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.base.BaseException;

/**
 * 服务端错误
 * @title: com.ymfs.web.exceptions.server.ServerCode50000Exception：
 * @description：TODO 
 * @author: create by weiyanhao
 * @date: 2018年4月20日 下午4:50:07
 */
public class ServerCode50000Exception extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7195944563257588129L;

	public ServerCode50000Exception() {
		super();
	}

	public ServerCode50000Exception(String subCode, String subMsg) {
		super(ErrorCodeEnum.CODE_50000.getCode(), ErrorCodeEnum.CODE_50000.getMsg(), subCode, subMsg);
	}

	public ServerCode50000Exception(String subMsg) {
		super(ErrorCodeEnum.CODE_50000.getCode(), ErrorCodeEnum.CODE_50000.getMsg(), ErrorCodeEnum.CODE_50000.getSubCode(), subMsg);
	}
	
	public ServerCode50000Exception(String subCode, String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_50000.getCode(), ErrorCodeEnum.CODE_50000.getMsg(), subCode, subMsg, cause);
	}
	
	public ServerCode50000Exception(String subMsg, Throwable cause) {
		super(ErrorCodeEnum.CODE_50000.getCode(), ErrorCodeEnum.CODE_50000.getMsg(), ErrorCodeEnum.CODE_50000.getSubCode(), subMsg, cause);
	}
	
}

package com.db_clear.enums.error;

/**
 * 错误码枚举类
 * 
 * @title: com.ymfs.web.enums.ErrorCodeEnum：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2018年3月16日 下午2:45:28
 */
public enum ErrorCodeEnum {
	/** =============================================================== */
	/** 暂时保留 */
	CODE_10000("10000", "Continue", "服务器收到请求，需要客户端继续执行操作"),
	/** =============================================================== */
	CODE_20000("20000", "OK", "请求成功"),
	CODE_20001("20001", "Business Handle Failure", "请求成功, 但业务处理失败"),
	/** =============================================================== */
	/** 暂时保留 */
	CODE_30000("30000", "Redirect", "重定向，需要进一步的操作以完成请求"),
	/** =============================================================== */
	CODE_40000("40000", "Bad Request", "客户端请求的语法错误，服务器无法理解"),
	CODE_40001("40001", "Missing Necessary Request Param", "客户端请求缺少必须的参数, 拒绝服务"),
	CODE_40002("40002", "Request Param Error", "客户端请求的参数错误，服务器无法理解"),
	CODE_40100("40100", "Unauthorized", "客户端请求需要用户的身份认证"),
	CODE_40101("40101", "Auth Token Time-out", "客户端身份认证访问令牌已过期"),
	CODE_40102("40102", "Repeated Auth Token", "重复的身份认证"),
	CODE_40103("40103", "Invalid Auth Token", "客户端身份认证访问令牌无效"),
	CODE_40300("40300", "Forbidden", "服务器理解请求客户端的请求，但是拒绝服务"),
	CODE_40400("40400", "Not Found", "客户端请求的资源不存在"),
	CODE_40500("40500", "Method Not Allowed", "客户端请求的HTTP Method被禁止"),
	CODE_41200("41200", "Precondition Failed", "客户端请求的资源权限不足"),
	/* =============================================================== */
	CODE_50000("50000", "Internal Server Error", "服务器内部错误，无法完成请求"),
	CODE_50200("50200", "Bad Gateway", "客户端的请求需要第三方服务支持，第三方服务无法完成请求"),
	CODE_50400("50400", "Gateway Time-out", "服务器处理超时，无法完成请求")
	;

	private String code;
	
	private String subCode;

	private String msg;

	private ErrorCodeEnum(String code, String subCode, String msg) {
		this.code = code;
		this.subCode = subCode;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

package com.db_clear.exceptions.base;

/**
 * @title:TODO 异常基类, 所有自定义异常必须继承此
 * @Description:
 * @author: tuhejie
 * @PackageName: com.thj.exceptions.base
 * @ClassName: BaseException
 * @Date: 2018年6月14日 下午4:32:06
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 6478381976712418366L;

	public BaseException() {
		super();
	}

	public BaseException(String subMsg) {
		super(subMsg);
		this.subMsg = subMsg;
	}

	public BaseException(String subCode, String subMsg) {
		super(subMsg);
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	public BaseException(String code, String msg, String subCode, String subMsg) {
		super(subMsg);
		this.code = code;
		this.msg = msg;
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	public BaseException(String subMsg, Throwable cause) {
		super(subMsg, cause);
		this.subMsg = subMsg;
	}

	public BaseException(String subCode, String subMsg, Throwable cause) {
		super(subMsg, cause);
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	public BaseException(String code, String msg, String subCode, String subMsg, Throwable cause) {
		super(subMsg, cause);
		this.code = code;
		this.msg = msg;
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	/**
	 * 请求状态码
	 */
	private String code;
	/**
	 * 请求消息
	 */
	private String msg;
	/**
	 * 业务code
	 */
	private String subCode;
	/**
	 * 业务消息
	 */
	private String subMsg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

}

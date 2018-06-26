package com.db_clear.exceptions.base;

import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db_clear.enums.base.ValidateType;
import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.exceptions.client.ClientCode40000Exception;
import com.db_clear.exceptions.client.ClientCode40001Exception;
import com.db_clear.exceptions.client.ClientCode40002Exception;
import com.db_clear.exceptions.client.ClientCode40100Exception;
import com.db_clear.exceptions.client.ClientCode40101Exception;
import com.db_clear.exceptions.client.ClientCode40102Exception;
import com.db_clear.exceptions.client.ClientCode40103Exception;
import com.db_clear.exceptions.client.ClientCode40300Exception;
import com.db_clear.exceptions.client.ClientCode41200Exception;
import com.db_clear.exceptions.server.ServerCode50000Exception;
import com.db_clear.utils.date.DateFormatUtils;
import com.db_clear.vos.base.RespVO;



/**
 * 异常统一处理
 * 
 * @title: com.tec.net.mianqu.site.controllers.GlobalExceptionHandler：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2017年1月19日 下午3:29:55
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	private static final String SERVER_EXCEPTION = "请求时间:{}, 服务器异常:{}";
	private static final String SERVER_EXCEPTION2 = "时间:{0}, 服务器出错了!";

	@ExceptionHandler(value=ClientCode40000Exception.class)
	@ResponseBody
	public RespVO handleClientCode40000Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40000Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40001Exception.class)
	@ResponseBody
	public RespVO handleClientCode40001Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40001Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40002Exception.class)
	@ResponseBody
	public RespVO handleClientCode40002Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40002Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40100Exception.class)
	@ResponseBody
	public RespVO handleClientCode40100Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40100Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40101Exception.class)
	@ResponseBody
	public RespVO handleClientCode40101Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40101Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40102Exception.class)
	@ResponseBody
	public RespVO handleClientCode40102Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40102Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40103Exception.class)
	@ResponseBody
	public RespVO handleClientCode40103Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40103Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), e.getSubMsg());
	}
	
	@ExceptionHandler(value=ClientCode40300Exception.class)
	@ResponseBody
	public RespVO handleClientCode40300Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40300Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), "拒绝服务");
	}
	
	@ExceptionHandler(value=ClientCode41200Exception.class)
	@ResponseBody
	public RespVO handleClientCode41200Exception(HttpServletRequest request, HttpServletResponse response, ClientCode40300Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), "客户端请求的资源权限不足");
	}
	
	@ExceptionHandler(value=ServerCode50000Exception.class)
	@ResponseBody
	public RespVO handleServerCode50000Exception(HttpServletRequest request, HttpServletResponse response, ServerCode50000Exception e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(e.getCode(), e.getMsg(), e.getSubCode(), "拒绝服务");
	}
	
	@ExceptionHandler(value=BindException.class)
	@ResponseBody
	public RespVO handleBindException(HttpServletRequest request, HttpServletResponse response, BindException e) {
		long time = System.currentTimeMillis();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		List<ObjectError> errors = e.getAllErrors();
		ObjectError error = errors.get(0);
		String code = error.getCode();
		ValidateType validateType = ValidateType.valueOf(code);
		switch (validateType) {
			case NotNull:
			case NotEmpty:
			case NotBlank:
				return RespVO.respVO(ErrorCodeEnum.CODE_40001, error.getDefaultMessage());
	
			default:
				return RespVO.respVO(ErrorCodeEnum.CODE_40002, error.getDefaultMessage());
		}
	}
	
	@ExceptionHandler(value=HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public RespVO handleHttpRequestMethodNotSupportedException(HttpServletRequest request, HttpServletResponse response, HttpRequestMethodNotSupportedException e) {
		String time = DateFormatUtils.getDate();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(ErrorCodeEnum.CODE_40500, MessageFormat.format("客户端的{0}", e.getMessage()));
	}
	
	@ExceptionHandler(value=BadSqlGrammarException.class)
	@ResponseBody
	public RespVO handleBadSqlGrammarException(HttpServletRequest request, HttpServletResponse response, BadSqlGrammarException e) {
		String time = DateFormatUtils.getDate();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(ErrorCodeEnum.CODE_50000, MessageFormat.format(SERVER_EXCEPTION2, String.valueOf(time)));
	}
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public RespVO handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		String time = DateFormatUtils.getDate();
		LOGGER.error(SERVER_EXCEPTION, time, ExceptionUtils.getStackTrace(e));
		return RespVO.respVO(ErrorCodeEnum.CODE_50000, MessageFormat.format(SERVER_EXCEPTION2, String.valueOf(time)));
	}

}

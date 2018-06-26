package com.db_clear.vos.base;

import com.alibaba.fastjson.JSONObject;
import com.db_clear.enums.error.ErrorCodeEnum;
import com.db_clear.utils.collection.MapUtils;
import com.db_clear.utils.crypto.CryptoUtils;


/**
 * @remark: 请求响应实体类, 验签异步调用使用
 * @title: RespVO.java
 * @author: weiyanhao
 * @date: 2018年4月14日 下午6:32:20
 */
public class RespVO extends JSONObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1433904078565914313L;
	
	/**
	 * 响应状态代码: 20000正常且业务处理成功, 20001正常但业务处理失败, 400xx客户端错误, 500xx服务器错误
	 */
	public final static String CODE_KEY = "code";
	
	/**
	 * 响应状态描述
	 */
	public final static String MSG_KEY = "msg";
	
	/**
	 * 签名
	 */
	public final static String SIGN_KEY = "sign";
	
	/**
	 * 签名类型
	 */
	public final static String SIGN_TYPE_KEY = "signType";
	public final static String SIGN_TYPE_VAL = "MD5";
	
	/**
	 * 业务POJO
	 */
	public final static String BIZ_KEY = "result";
	
	
	
	/**
	 * @TODO: 业务处理成功响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param subMsg
	 * @return
	 */
	public static RespVO success(String subMsg) {
		BaseVO vo = new BaseVO(ErrorCodeEnum.CODE_20000.getSubCode(), subMsg);
		return respVO(ErrorCodeEnum.CODE_20000.getCode(), ErrorCodeEnum.CODE_20000.getMsg(), vo);
	}
	
	/**
	 * @TODO: 业务处理成功响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param msg
	 * @return
	 */
	public static RespVO success(BaseVO vo) {
		return respVO(ErrorCodeEnum.CODE_20000.getCode(), ErrorCodeEnum.CODE_20000.getMsg(), vo);
	}
	
	/**
	 * @TODO: 业务处理失败响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param subMsg
	 * @return
	 */
	public static RespVO failure(String subMsg) {
		BaseVO vo = new BaseVO(ErrorCodeEnum.CODE_20001.getSubCode(), subMsg);
		return respVO(ErrorCodeEnum.CODE_20001.getCode(), ErrorCodeEnum.CODE_20001.getMsg(), vo);
	}
	
	/**
	 * @TODO: 业务处理失败响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param msg
	 * @return
	 */
	public static RespVO failure(BaseVO vo) {
		return respVO(ErrorCodeEnum.CODE_20001.getCode(), ErrorCodeEnum.CODE_20001.getMsg(), vo);
	}
	
	/**
	 * @TODO: 响应实体封装
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:07:47
	 * @param code
	 * @param subCode
	 * @param subMsg
	 * @return
	 */
	public static RespVO respVO(ErrorCodeEnum code, String subMsg) {
		return respVO(code, code.getSubCode(), subMsg);
	}
	
	/**
	 * @TODO: 响应实体封装
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:07:47
	 * @param code
	 * @param subCode
	 * @param subMsg
	 * @return
	 */
	public static RespVO respVO(ErrorCodeEnum code, String subCode, String subMsg) {
		BaseVO vo = new BaseVO(subCode, subMsg);
		return respVO(code.getCode(), code.getMsg(), vo);
	}
	
	/**
	 * @TODO: 响应实体封装
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:07:47
	 * @param code
	 * @param msg
	 * @param subCode
	 * @param subMsg
	 * @return
	 */
	public static RespVO respVO(String code, String msg, String subCode, String subMsg) {
		BaseVO vo = new BaseVO(subCode, subMsg);
		return respVO(code, msg, vo);
	}
	
	/**
	 * @TODO: 响应实体封装
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:07:47
	 * @param code
	 * @param msg
	 * @param vo
	 * @return
	 */
	public static RespVO respVO(ErrorCodeEnum code, BaseVO vo) {
		return respVO(code.getCode(), code.getMsg(), vo);
	}
	
	/**
	 * @TODO: 响应实体封装
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:07:47
	 * @param code
	 * @param msg
	 * @param vo
	 * @return
	 */
	public static RespVO respVO(String code, String msg, BaseVO vo) {
		RespVO respVo = new RespVO();
		respVo.put(CODE_KEY, code);
		respVo.put(MSG_KEY, msg);
		respVo.put(BIZ_KEY, vo);
		return respVo;
	}
	
	/**
	 * @TODO: 业务处理成功响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param subMsg
	 * @param sign
	 * @param signType
	 * @return
	 */
	public static RespVO success4Sign(String subMsg, String key) {
		BaseVO vo = new BaseVO(ErrorCodeEnum.CODE_20000.getSubCode(), subMsg);
		return respVO4Sign(ErrorCodeEnum.CODE_20000.getCode(), ErrorCodeEnum.CODE_20000.getMsg(), key, vo);
	}
	
	/**
	 * @TODO: 业务处理成功响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param msg
	 * @param sign
	 * @param signType
	 * @return
	 */
	public static RespVO success4Sign(String key, BaseVO vo) {
		return respVO4Sign(ErrorCodeEnum.CODE_20000.getCode(), ErrorCodeEnum.CODE_20000.getMsg(), key, vo);
	}
	
	/**
	 * @TODO: 业务处理失败响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param subMsg
	 * @param sign
	 * @param signType
	 * @return
	 */
	public static RespVO failure4Sign(String subMsg, String key) {
		BaseVO vo = new BaseVO(ErrorCodeEnum.CODE_20001.getSubCode(), subMsg);
		return respVO4Sign(ErrorCodeEnum.CODE_20001.getCode(), ErrorCodeEnum.CODE_20001.getMsg(), key, vo);
	}
	
	/**
	 * @TODO: 业务处理失败响应
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:10:03
	 * @param msg
	 * @return
	 */
	public static RespVO failure4Sign(String key, BaseVO vo) {
		return respVO4Sign(ErrorCodeEnum.CODE_20001.getCode(), ErrorCodeEnum.CODE_20001.getMsg(), key, vo);
	}
	
	/**
	 * @TODO: 响应实体封装加签, 使用MD5盐值加密实现签名
	 * @author: weiyanhao
	 * @date: 2018年4月14日 下午6:07:47
	 * @param code
	 * @param msg
	 * @param sign
	 * @param signType
	 * @param vo
	 * @return
	 */
	public static RespVO respVO4Sign(String code, String msg, String key, BaseVO vo) {
		RespVO respVo = new RespVO();
		respVo.put(CODE_KEY, code);
		respVo.put(MSG_KEY, msg);
		String text = MapUtils.getSignText(vo);
		String sign = CryptoUtils.passwordEncrypt(text, key);
		respVo.put(BIZ_KEY, vo);
		respVo.put(SIGN_KEY, sign);
		respVo.put(SIGN_TYPE_KEY, SIGN_TYPE_VAL);
		return respVo;
	}
	
}

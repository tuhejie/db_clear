package com.db_clear.utils.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.Charsets;

import com.db_clear.exceptions.server.ServerCode50000Exception;
import com.db_clear.utils.charset.CharsetUtils;

/**
 * @title:TODO 字符串工具类
 * @Description:
 * @author: tuhejie
 * @PackageName: com.thj.utils.string
 * @ClassName: StringUtils
 * @Date: 2018年6月14日 下午4:12:18
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	public final static String STIKE = "-";
	public final static String DOT = ".";
	public final static String COMMA_EN = ",";
	public final static String COMMA_CN = "，";
	public final static String YES_EN = "Y";
	public final static String NO_EN = "N";
	public final static String YES_CN = "是";
	public final static String NO_CN = "否";
	public static final String EQUAL_SIGN = "=";
	public static final String AND_SIGN = "&";
	public static final String HASH_SIGN = "#";
	public static final String QUESTION_MARK = "?";
	public static final String LEFT_BRACE = "{";
	public static final String RIGHT_BRACE = "}";
	public static final String BRACE = "{}";
	public static final String LEFT_BRACKET = "[";
	public static final String RIGHT_BRACKET = "]";
	public static final String BRACKET = "[]";
	public static final String TAB_SPACE = "    ";
	public static final String COLON = ":";
	public static final String SINGLE_QUOTATION = "'";
	public static final String DOUBLE_QUOTATION = "\"";
	public static final String VERTICAL_LINE = "|";
	public static final String LEFT_SLASH = "/";
	public static final String RIGHT_SLASH = "\\";
	public static final String PERCENT = "%";
	
	/** pc端token前缀 */
	public static final String PC_TOKEN_SUFFIX = "pc-";
	/** h5端token前缀 */
	public static final String H5_TOKEN_SUFFIX = "h5-";

	/**
	 * @title:TODO 字符串后补空格(按字节位)
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:12:52
	 * @param str
	 * @param len
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fillSpaceAfterString(String str, int len) throws UnsupportedEncodingException {
		int length = str.getBytes(CharsetUtils.GBK).length;
		if (len > length) {
			return join(str, repeat(SPACE, len - length));
		} else {
			return str;
		}
	}

	/**
	 * @title:TODO 字符串后补fileStr(按字节位)
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年6月14日 下午4:13:07
	 * @param str
	 * @param len
	 * @param fileStr
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fillStringAfterString(String str, int len, String fileStr)
			throws UnsupportedEncodingException {
		int length = str.getBytes(CharsetUtils.GBK).length;
		if (len > length) {
			return join(str, repeat(fileStr, len - length));
		} else {
			return str;
		}
	}

	/**
	 * Constructs a new <code>String</code> by decoding the specified array of bytes
	 * using the UTF-8 charset.
	 *
	 * @param bytes
	 *            The bytes to be decoded into characters
	 * @return A new <code>String</code> decoded from the specified array of bytes
	 *         using the UTF-8 charset, or <code>null</code> if the input byte array
	 *         was <code>null</code>.
	 * @throws NullPointerException
	 *             Thrown if {@link Charsets#UTF_8} is not initialized, which should
	 *             never happen since it is required by the Java platform
	 *             specification.
	 * @since As of 1.7, throws {@link NullPointerException} instead of
	 *        UnsupportedEncodingException
	 */
	public static String newStringUtf8(final byte[] bytes) {
		return newString(bytes, CharsetUtils.UTF_8);
	}

	/**
	 * Constructs a new <code>String</code> by decoding the specified array of bytes
	 * using the given charset.
	 * <p>
	 * This method catches {@link UnsupportedEncodingException} and re-throws it as
	 * {@link IllegalStateException}, which should never happen for a required
	 * charset name. Use this method when the encoding is required to be in the JRE.
	 * </p>
	 *
	 * @param bytes
	 *            The bytes to be decoded into characters, may be <code>null</code>
	 * @param charsetName
	 *            The name of a required {@link java.nio.charset.Charset}
	 * @return A new <code>String</code> decoded from the specified array of bytes
	 *         using the given charset, or <code>null</code> if the input byte array
	 *         was <code>null</code>.
	 * @throws IllegalStateException
	 *             Thrown when a {@link UnsupportedEncodingException} is caught,
	 *             which should never happen for a required charset name.
	 * @see CharEncoding
	 * @see String#String(byte[], String)
	 */
	public static String newString(final byte[] bytes, final String charsetName) throws ServerCode50000Exception {
		if (bytes == null) {
			return null;
		}
		try {
			return new String(bytes, charsetName);
		} catch (final UnsupportedEncodingException e) {
			throw new ServerCode50000Exception("不支持的字符编码", e);
		}
	}

	/**
	 * Constructs a new <code>String</code> by decoding the specified array of bytes
	 * using the given charset.
	 *
	 * @param bytes
	 *            The bytes to be decoded into characters
	 * @param charset
	 *            The {@link Charset} to encode the <code>String</code>
	 * @return A new <code>String</code> decoded from the specified array of bytes
	 *         using the given charset, or <code>null</code> if the input byte array
	 *         was <code>null</code>.
	 * @throws NullPointerException
	 *             Thrown if {@link Charsets#UTF_8} is not initialized, which should
	 *             never happen since it is required by the Java platform
	 *             specification.
	 */
	public static String newString(final byte[] bytes, final Charset charset) {
		return bytes == null ? null : new String(bytes, charset);
	}

	/**
	 * Encodes the given string into a sequence of bytes using the UTF-8 charset,
	 * storing the result into a new byte array.
	 *
	 * @param string
	 *            the String to encode, may be <code>null</code>
	 * @return encoded bytes, or <code>null</code> if the input string was
	 *         <code>null</code>
	 * @throws NullPointerException
	 *             Thrown if {@link Charsets#UTF_8} is not initialized, which should
	 *             never happen since it is required by the Java platform
	 *             specification.
	 * @since As of 1.7, throws {@link NullPointerException} instead of
	 *        UnsupportedEncodingException
	 * @see <a href=
	 *      "http://download.oracle.com/javase/6/docs/api/java/nio/charset/Charset.html">Standard
	 *      charsets</a>
	 * @see #getBytesUnchecked(String, String)
	 */
	public static byte[] getBytesUtf8(final String string) {
		return getBytes(string, CharsetUtils.UTF_8);
	}

	/**
	 * Calls {@link String#getBytes(Charset)}
	 *
	 * @param string
	 *            The string to encode (if null, return null).
	 * @param charset
	 *            The {@link Charset} to encode the <code>String</code>
	 * @return the encoded bytes
	 */
	public static byte[] getBytes(final String string, final String charset) {
		if (string == null) {
			return null;
		}
		try {
			return string.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new ServerCode50000Exception("不支持的字符编码", e);
		}
	}

	/**
	 * Calls {@link String#getBytes(Charset)}
	 *
	 * @param string
	 *            The string to encode (if null, return null).
	 * @param charset
	 *            The {@link Charset} to encode the <code>String</code>
	 * @return the encoded bytes
	 */
	public static byte[] getBytes(final String string, final Charset charset) {
		if (string == null) {
			return null;
		}
		return string.getBytes(charset);
	}

	/**
	 * @TODO: 判断2个字符串非空
	 * @author: weiyanhao
	 * @date: 2018年4月29日 下午1:15:58
	 * @param val
	 * @param val2
	 * @return
	 */
	public static boolean areBlank(String val, String val2) {
		return isBlank(val) && isBlank(val2);
	}

	/**
	 * @TODO: 判断2个字符串为空
	 * @author: weiyanhao
	 * @date: 2018年4月29日 下午1:16:16
	 * @param val
	 * @param val2
	 * @return
	 */
	public static boolean areNotBlank(String val, String val2) {
		return isNotBlank(val) && isNotBlank(val2);
	}

	public static boolean isNullArrayOrObject(String value) {
		return BRACE.equals(value) || BRACKET.equals(value);
	}

	/**
	 * @TODO: 判断字符串是pc token
	 * @author: weiyanhao
	 * @date: 2018年4月29日 下午1:17:34
	 * @param token
	 * @return
	 */
	public static boolean isPcToken(String token) {
		return token.startsWith(PC_TOKEN_SUFFIX);
	}

	/**
	 * @TODO: 判断字符串是h5 token
	 * @author: weiyanhao
	 * @date: 2018年4月29日 下午1:17:34
	 * @param token
	 * @return
	 */
	public static boolean isH5Token(String token) {
		return token.startsWith(H5_TOKEN_SUFFIX);
	}

}

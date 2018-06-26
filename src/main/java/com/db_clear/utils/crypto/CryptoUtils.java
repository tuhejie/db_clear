package com.db_clear.utils.crypto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.db_clear.enums.math.IntegerVal;
import com.db_clear.utils.codec.Base64Utils;
import com.db_clear.utils.math.NumberUtils;
import com.db_clear.utils.string.StringUtils;

/**
 * 加密/解密/签名工具类
 * 
 * @title: com.ymfs.web.utils.digest.DigestUtils：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2018年4月10日 下午5:15:15
 */
public class CryptoUtils extends org.apache.commons.codec.digest.DigestUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoUtils.class);

	/** rsa 密钥位数(64的倍数, 768以上安全, 建议1024/2048) */
	private static final int STREAM_BUFFER_LENGTH = 1024;

	/** 公钥 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/** 私钥 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/** 签名方式 */
	private static final String SIGN_ALGORITHM = "MD5withRSA";

	/** 非对称加密/解密类型 */
	private static final String KEY_ALGORITHM = "RSA";

	/** RSA256最大解密密文大小, 1024-128, 2048-256 */
	private static final int MAX_DECRYPT_BLOCK = STREAM_BUFFER_LENGTH >> 3;

	/** RSA256最大加密明文大小, 为最大解密密文大小-11 */
	private static final int MAX_ENCRYPT_BLOCK = MAX_DECRYPT_BLOCK - 11;

	/**
	 * @title: TODO 获取rsa密钥对
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:08:30
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> genRSAKeyPair() {
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("获取RSA密钥生成对象异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("获取RSA密钥生成对象异常");
		}
		keyPairGen.initialize(STREAM_BUFFER_LENGTH);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>();
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	/**
	 * @title: TODO 从生成的密钥对map中获取RSA私钥Base64字符串
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:34:05
	 * @param keyMap
	 * @return
	 */
	public static String getRSAPrivateKeyStringByGeneratorMap(Map<String, Object> keyMap) {
		RSAPrivateKey key = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
		return Base64Utils.encodeBase64String(key.getEncoded());
	}

	/**
	 * @title: TODO 从生成的密钥对map中获取RSA公钥Base64字符串
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:34:05
	 * @param keyMap
	 * @return
	 */
	public static String getRSAPublicKeyStringByGeneratorMap(Map<String, Object> keyMap) {
		RSAPublicKey key = (RSAPublicKey) keyMap.get(PUBLIC_KEY);
		return Base64Utils.encodeBase64String(key.getEncoded());
	}

	/**
	 * @title: TODO 从生成的密钥对map中获取RSA私钥
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:34:05
	 * @param keyMap
	 * @return
	 */
	public static RSAPrivateKey getRSAPrivateKeyByGeneratorMap(Map<String, Object> keyMap) {
		RSAPrivateKey key = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
		return key;
	}

	/**
	 * @title: TODO 从生成的密钥对map中获取RSA公钥
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:34:05
	 * @param keyMap
	 * @return
	 */
	public static RSAPublicKey getRSAPublicKeyByGeneratorMap(Map<String, Object> keyMap) {
		RSAPublicKey key = (RSAPublicKey) keyMap.get(PUBLIC_KEY);
		return key;
	}

	/**
	 * @title: TODO RSA私钥base64字符串转RSAPrivateKey
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:34:05
	 * @param keyMap
	 * @return
	 */
	public static RSAPrivateKey getRSAPrivateKeyByBase64String(String privateStr) {
		RSAPrivateKey key = null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			KeySpec keySpec = new PKCS8EncodedKeySpec(Base64Utils.decodeBase64(privateStr));
			key = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			LOGGER.error("转换RSA私钥异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("转换RSA私钥异常");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("获取KeyFactory异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("获取KeyFactory异常");
		}
		return key;
	}

	/**
	 * @title: TODO 从生成的密钥对map中获取RSA公钥
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月27日 下午7:34:05
	 * @param keyMap
	 * @return
	 */
	public static RSAPublicKey getRSAPublicKeyByBase64String(String publicStr) {
		RSAPublicKey key = null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			KeySpec keySpec = new X509EncodedKeySpec(Base64Utils.decodeBase64(publicStr));
			key = (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (InvalidKeySpecException e) {
			LOGGER.error("转换RSA公钥异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("转换RSA公钥异常");
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("获取KeyFactory异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("获取KeyFactory异常");
		}
		return key;
	}

	/**
	 * @title: TODO RSAPrivateKey MD5withRSA签名
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:24:56
	 * @param plaintext
	 * @param rsaPrivateKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPrivateKeySign(String plaintext, String rsaPrivateKey) {
		try {
			RSAPrivateKey privateKey = getRSAPrivateKeyByBase64String(rsaPrivateKey);
			Signature sig = Signature.getInstance(SIGN_ALGORITHM);
			sig.initSign(privateKey);
			sig.update(StringUtils.getBytesUtf8(plaintext));
			return StringUtils.newStringUtf8(Base64Utils.encodeBase64(sig.sign()));
		} catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
			LOGGER.error("RSAPrivateKey MD5withRSA签名异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("RSAPrivateKey MD5withRSA签名异常");
		}
	}

	/**
	 * @title: TODO RSAPublicKey MD5withRSA验签
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:43:13
	 * @param ciphertext
	 * @param sign
	 * @param rsaPublicKey
	 * @return
	 * @throws Exception
	 */
	public static boolean rsaPublicKeyVerify(String ciphertext, String sign, String rsaPublicKey) {
		try {
			RSAPublicKey publicKey = getRSAPublicKeyByBase64String(rsaPublicKey);
			Signature sig = Signature.getInstance(SIGN_ALGORITHM);
			sig.initVerify(publicKey);
			sig.update(StringUtils.getBytesUtf8(ciphertext));
			return sig.verify(Base64Utils.decodeBase64(sign));
		} catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
			LOGGER.error("RSAPublicKey MD5withRSA验签异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("RSAPublicKey MD5withRSA验签异常");
		}
	}

	/**
	 * @title: TODO RSAPrivateKey加密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:48:05
	 * @param plaintext
	 * @param rsaPrivateKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPrivateKeyEncrypt(String plaintext, String rsaPrivateKey) {
		RSAPrivateKey privateKey = getRSAPrivateKeyByBase64String(rsaPrivateKey);
		return rsaPrivateKeyEncrypt(plaintext, privateKey);
	}

	/**
	 * @title: TODO RSAPrivateKey加密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:48:05
	 * @param plaintext
	 * @param rsaPrivateKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPrivateKeyEncrypt(String plaintext, RSAPrivateKey rsaPrivateKey) {
		try {
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, rsaPrivateKey);
			return rsaBlockEncryptORDecrypt(plaintext, cipher, Cipher.ENCRYPT_MODE);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			LOGGER.error("RSAPrivateKey加密异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("RSAPrivateKey加密异常");
		}
	}

	/**
	 * @title: TODO RSAPublicKey解密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:32:35
	 * @param plaintext
	 * @param rsaPublicKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPublicKeyDecrypt(String plaintext, String rsaPublicKey) {
		RSAPublicKey publicKey = getRSAPublicKeyByBase64String(rsaPublicKey);
		return rsaPublicKeyDecrypt(plaintext, publicKey);
	}

	/**
	 * @title: TODO RSAPublicKey解密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:32:35
	 * @param plaintext
	 * @param rsaPublicKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPublicKeyDecrypt(String plaintext, RSAPublicKey rsaPublicKey) {
		try {
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, rsaPublicKey);
			return rsaBlockEncryptORDecrypt(plaintext, cipher, Cipher.DECRYPT_MODE);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			LOGGER.error("RSAPublicKey解密异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("RSAPublicKey解密异常");
		}
	}

	/**
	 * @title: TODO RSAPublicKey加密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:32:35
	 * @param plaintext
	 * @param rsaPublicKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPublicKeyEncrypt(String plaintext, String rsaPublicKey) {
		RSAPublicKey publicKey = getRSAPublicKeyByBase64String(rsaPublicKey);
		return rsaPublicKeyEncrypt(plaintext, publicKey);
	}

	/**
	 * @title: TODO RSAPublicKey加密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:32:35
	 * @param plaintext
	 * @param rsaPublicKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPublicKeyEncrypt(String plaintext, RSAPublicKey rsaPublicKey) {
		try {
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
			return rsaBlockEncryptORDecrypt(plaintext, cipher, Cipher.ENCRYPT_MODE);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			LOGGER.error("RSAPublicKey加密异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("RSAPublicKey加密异常");
		}
	}

	/**
	 * @title: TODO RSAPrivateKey解密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:48:05
	 * @param plaintext
	 * @param rsaPrivateKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPrivateKeyDecrypt(String plaintext, String rsaPrivateKey) {
		RSAPrivateKey privateKey = getRSAPrivateKeyByBase64String(rsaPrivateKey);
		return rsaPrivateKeyDecrypt(plaintext, privateKey);
	}

	/**
	 * @title: TODO RSAPrivateKey解密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年3月30日 上午10:48:05
	 * @param plaintext
	 * @param rsaPrivateKey
	 * @return
	 * @throws Exception
	 */
	public static String rsaPrivateKeyDecrypt(String plaintext, RSAPrivateKey rsaPrivateKey) {
		try {
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
			return rsaBlockEncryptORDecrypt(plaintext, cipher, Cipher.DECRYPT_MODE);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			LOGGER.error("RSAPrivateKey解密异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("RSAPrivateKey解密异常");
		}
	}

	/**
	 * @title: TODO RSA分段加密/解密
	 * @description:
	 * @author: create by weiyanhao
	 * @date: 2018年4月10日 下午4:22:32
	 * @param content
	 * @param cipher
	 * @param cipher_mode
	 * @return
	 */
	private static String rsaBlockEncryptORDecrypt(String content, Cipher cipher, int cipher_mode) {
		try {
			int block = 0;
			byte[] data = null;
			if (Cipher.ENCRYPT_MODE == cipher_mode) {// 加密
				data = StringUtils.getBytesUtf8(content);
				block = MAX_ENCRYPT_BLOCK;
			} else {// 解密
				data = Base64Utils.decodeBase64(content);
				block = MAX_DECRYPT_BLOCK;
			}
			int inputLen = data.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段解密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > block) {
					cache = cipher.doFinal(data, offSet, block);
				} else {
					cache = cipher.doFinal(data, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * block;
			}
			byte[] dealData = null;
			if (Cipher.ENCRYPT_MODE == cipher_mode) {// 加密
				dealData = Base64Utils.encodeBase64(out.toByteArray());
			} else {// 解密
				dealData = out.toByteArray();
			}
			out.close();
			return StringUtils.newStringUtf8(dealData);
		} catch (IllegalBlockSizeException | BadPaddingException | IOException e) {
			LOGGER.error("加密/解密异常:{}", ExceptionUtils.getStackTrace(e));
			throw new RuntimeException("加密/解密异常");
		}
	}

	// ===================================密码加密/比对处理=========================================
	/**
	 * @title: TODO 密码比对工具类
	 * @description: 用户输入密码盐值加密（盐值不为空）并加密 n 次后与数据库密码比对，相同返回true
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:25:18
	 * @param input_pwd
	 *            用户输入密码
	 * @param database_pwd
	 *            数据库密码
	 * @return 比对结果
	 */
	public static boolean passwordCompare(String input_pwd, String database_pwd) {
		return passwordCompare(input_pwd, database_pwd, StringUtils.EMPTY);
	}

	/**
	 * @title: TODO 密码比对工具类
	 * @description: 用户输入密码盐值加密（盐值不为空）并加密 n 次后与数据库密码比对，相同返回true
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:25:18
	 * @param input_pwd
	 *            用户输入密码
	 * @param database_pwd
	 *            数据库密码
	 * @param salt
	 *            盐值
	 * @return 比对结果
	 */
	public static boolean passwordCompare(String input_pwd, String database_pwd, String salt) {
		return passwordCompare(input_pwd, database_pwd, NumberUtils.INTEGER_ONE, salt);
	}

	/**
	 * @title: TODO 密码比对工具类
	 * @description: 用户输入密码盐值加密（盐值不为空）并加密 n 次后与数据库密码比对，相同返回true
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:25:18
	 * @param input_pwd
	 *            用户输入密码
	 * @param database_pwd
	 *            数据库密码
	 * @param encryptNum
	 *            加密次数
	 * @return 比对结果
	 */
	public static boolean passwordCompare(String input_pwd, String database_pwd, int encryptNum) {
		return passwordCompare(input_pwd, database_pwd, encryptNum, StringUtils.EMPTY);
	}

	/**
	 * @title: TODO 密码比对工具类
	 * @description: 用户输入密码盐值加密（盐值不为空）并加密 n 次后与数据库密码比对，相同返回true
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:25:18
	 * @param input_pwd
	 *            用户输入密码
	 * @param database_pwd
	 *            数据库密码
	 * @param encryptNum
	 *            加密次数
	 * @param salt
	 *            盐值
	 * @return 比对结果
	 */
	public static boolean passwordCompare(String input_pwd, String database_pwd, int encryptNum, String salt) {
		boolean flag = false;
		String md5Str = passwordEncrypt(input_pwd, encryptNum, salt);
		flag = md5Str.equals(database_pwd);
		return flag;
	}

	/**
	 * @title: TODO 盐值并多次加密返回加密字符串
	 * @description: 输入密码盐值加密（盐值不为空）并加密 n 次的 base64 编码结果
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:28:04
	 * @param input_pwd
	 *            密码
	 * @return 加密后的base64 编码字符串
	 */
	public static String passwordEncrypt(String input_pwd) {
		return passwordEncrypt(input_pwd, NumberUtils.INTEGER_ONE);
	}

	/**
	 * @title: TODO 盐值并多次加密返回加密字符串
	 * @description: 输入密码盐值加密（盐值不为空）并加密 n 次的 base64 编码结果
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:28:04
	 * @param input_pwd
	 *            密码
	 * @param encryptNum
	 *            加密次数
	 * @return 加密后的base64 编码字符串
	 */
	public static String passwordEncrypt(String input_pwd, int encryptNum) {
		return passwordEncrypt(input_pwd, encryptNum, StringUtils.EMPTY);
	}

	/**
	 * @title: TODO 盐值并多次加密返回加密字符串
	 * @description: 输入密码盐值加密（盐值不为空）并加密 n 次的 base64 编码结果
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:28:04
	 * @param input_pwd
	 *            密码
	 * @param salt
	 *            盐值
	 * @return 加密后的base64 编码字符串
	 */
	public static String passwordEncrypt(String input_pwd, String salt) {
		return passwordEncrypt(input_pwd, NumberUtils.INTEGER_ONE, salt);
	}

	/**
	 * @title: TODO 盐值并多次加密返回加密字符串
	 * @description: 输入密码盐值加密（盐值不为空）并加密 n 次的 base64 编码结果
	 * @author: create by weiyanhao
	 * @date: 2017年7月13日 下午4:28:04
	 * @param input_pwd
	 *            密码
	 * @param encryptNum
	 *            加密次数
	 * @param salt
	 *            盐值
	 * @return 加密后的base64 编码字符串
	 */
	public static String passwordEncrypt(String input_pwd, int encryptNum, String salt) {
		String md5Str = input_pwd;
		if (StringUtils.isNotBlank(salt)) {
			md5Str = md5Hex(salt) + input_pwd;
		}
		for (int i = 0; i < encryptNum; i++) {
			md5Str = md5Hex(md5Str);
		}
		return Base64Utils.encodeBase64String(md5Str);
	}

	/**
	 * @TODO: md5 with salt
	 * @author: weiyanhao
	 * @date: 2018年4月29日 下午3:34:36
	 * @param text
	 * @param salt
	 * @return
	 */
	public static String md5HexWithSalt(String text, String salt) {
		return md5Hex(md5Hex(salt) + salt);
	}

	// 签名
	/**
	 * @TODO: MD5 key sign
	 * @author: weiyanhao
	 * @date: 2018年4月29日 上午11:56:48
	 * @param text
	 * @param key
	 * @return
	 */
	public static String signature(String text, String key) {
		return passwordEncrypt(text, key);
	}

	/**
	 * @TODO: MD5 key verify
	 * @author: weiyanhao
	 * @date: 2018年4月29日 上午11:58:58
	 * @param sign
	 * @param key
	 * @return
	 */
	public static boolean verify(String text, String sign, String key) {
		return passwordCompare(text, sign, key);
	}

	public static String md5(String input_pwd, String salt) {
		return md5(input_pwd, NumberUtils.INTEGER_ONE, salt);
	}

	public static String md5(String input_pwd, int encrptyNum) {
		return md5(input_pwd, encrptyNum, StringUtils.EMPTY);
	}

	public static String md5(String input_pwd, int encrptyNum, String salt) {
		String md5Str = input_pwd;
		if (StringUtils.isNotBlank(salt)) {
			md5Str = md5Hex(salt) + input_pwd;
		}
		for (int i = IntegerVal.zero.val(); i < encrptyNum; i++) {
			md5Str = md5Hex(md5Str);
		}
		return md5Str;
	}

	public static void main(String[] args) throws Exception {
		/*
		 * Map<String, Object> genRSAKeyPair = genRSAKeyPair(); String rsaPrivateKey =
		 * getRSAPrivateKeyStringByGeneratorMap(genRSAKeyPair); String rsaPublicKey =
		 * getRSAPublicKeyStringByGeneratorMap(genRSAKeyPair);
		 * System.out.println("私钥1:"+rsaPrivateKey);
		 * System.out.println("公钥1:"+rsaPublicKey);
		 * 
		 * Map<String, Object> genRSAKeyPair2 = genRSAKeyPair(); String rsaPrivateKey2 =
		 * getRSAPrivateKeyStringByGeneratorMap(genRSAKeyPair2); String rsaPublicKey2 =
		 * getRSAPublicKeyStringByGeneratorMap(genRSAKeyPair2);
		 * System.out.println("私钥2:"+rsaPrivateKey2);
		 * System.out.println("公钥2:"+rsaPublicKey2);
		 * 
		 * // 明文加密 String text = rsaPublicKeyEncrypt(
		 * "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAI9NgdRf6ACj8o7nuMS1oT4NRaHn6GG4YQ/XN4ijL0GJGtGoVc74+CsrL4nxrthf3h130A2HytLQLrGsACt3+ULACDh57/SUFW/bNjUCFPx7P3NU1H9fJy67sVOgX9ZlzAqULDWzvF/zdfjJMjaAmlCeB+ohYtW4lTDscpVK69PVAgMBAAECgYBD29YQ9WFtfDVOSpiKPeAe/DXvF1xJegAseiOIBo5IIF6czXPk0Kzj9E1Mqy+6spsBpUzWO2lmLsMNy39BFkzoAtKvpamXk08OnCrgzMb2ce+q+sDY5zTdtkr84wyTGQslmmi54hdAozheCQQgPffY00HQS5KoXdIhX1HKuIQtQQJBANHjBPWQmlIEtalj4HffjTg6Vx/Eb2+hdzGoPRTBBEsBwmSFAq6sJKvFP3DuT2QP5TcMW61WJSgMl1ewwSjk230CQQCuyYBUPMukQaUItnUCx0ArQwlH0os90uuQfziDuOckjhNH1iZ5ewziOBi1YPp6uizACKShuYpEyXoTCjz5stk5AkA0KqnT4zIICrWgOXvUL5MpE48ODUPpSgeXJwqvet33SqOnWkv1YEHpE6iWCBVheHXvPboXlh68Go0PNZZ89Iz9AkAHSqSt3vNn4M0vtdzfxswogd1rP59Lbvcgyg3jgN0zqzGmt4pXWwjIjyqItoj8gbPINxQXIxRflkAfdzff+tQRAkA7d/DP8pSI5MIMsuJUala2j3bAc35TfH4eSdR81pzZEa+2pe0kih3DtnXG/ihKVgSsbGtS0GhMAZh0it8Z1lEd",
		 * rsaPublicKey2);
		 * 
		 * String sign = rsaPrivateKeySign(text, rsaPrivateKey);
		 * System.out.println("签名:"+sign);
		 * 
		 * boolean flag = rsaPublicKeyVerify(text, sign, rsaPublicKey);
		 * System.out.println("验签:"+flag);
		 * 
		 * String t = rsaPrivateKeyDecrypt(text, rsaPrivateKey2);
		 * System.out.println("解密:"+t);
		 * 
		 * // 明文加密 String text2 = rsaPrivateKeyEncrypt(
		 * "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAI9NgdRf6ACj8o7nuMS1oT4NRaHn6GG4YQ/XN4ijL0GJGtGoVc74+CsrL4nxrthf3h130A2HytLQLrGsACt3+ULACDh57/SUFW/bNjUCFPx7P3NU1H9fJy67sVOgX9ZlzAqULDWzvF/zdfjJMjaAmlCeB+ohYtW4lTDscpVK69PVAgMBAAECgYBD29YQ9WFtfDVOSpiKPeAe/DXvF1xJegAseiOIBo5IIF6czXPk0Kzj9E1Mqy+6spsBpUzWO2lmLsMNy39BFkzoAtKvpamXk08OnCrgzMb2ce+q+sDY5zTdtkr84wyTGQslmmi54hdAozheCQQgPffY00HQS5KoXdIhX1HKuIQtQQJBANHjBPWQmlIEtalj4HffjTg6Vx/Eb2+hdzGoPRTBBEsBwmSFAq6sJKvFP3DuT2QP5TcMW61WJSgMl1ewwSjk230CQQCuyYBUPMukQaUItnUCx0ArQwlH0os90uuQfziDuOckjhNH1iZ5ewziOBi1YPp6uizACKShuYpEyXoTCjz5stk5AkA0KqnT4zIICrWgOXvUL5MpE48ODUPpSgeXJwqvet33SqOnWkv1YEHpE6iWCBVheHXvPboXlh68Go0PNZZ89Iz9AkAHSqSt3vNn4M0vtdzfxswogd1rP59Lbvcgyg3jgN0zqzGmt4pXWwjIjyqItoj8gbPINxQXIxRflkAfdzff+tQRAkA7d/DP8pSI5MIMsuJUala2j3bAc35TfH4eSdR81pzZEa+2pe0kih3DtnXG/ihKVgSsbGtS0GhMAZh0it8Z1lEd",
		 * rsaPrivateKey2);
		 * 
		 * String sign2 = rsaPrivateKeySign(text2, rsaPrivateKey);
		 * System.out.println("签名:"+sign2);
		 * 
		 * boolean flag2 = rsaPublicKeyVerify(text2, sign2, rsaPublicKey);
		 * System.out.println("验签:"+flag2);
		 * 
		 * String t2 = rsaPublicKeyDecrypt(text2, rsaPublicKey2);
		 * System.out.println("解密:"+t2);
		 */

		/*
		 * Map<String, Object> genRSAKeyPair = genRSAKeyPair(); String rsaPrivateKey =
		 * getRSAPrivateKeyStringByGeneratorMap(genRSAKeyPair); String rsaPublicKey =
		 * getRSAPublicKeyStringByGeneratorMap(genRSAKeyPair);
		 * System.out.println("私钥1:"+rsaPrivateKey);
		 * System.out.println("公钥1:"+rsaPublicKey);
		 * 
		 * String tString = rsaPublicKeyEncrypt("test", rsaPublicKey);
		 * System.out.println(tString); String t = rsaPrivateKeyDecrypt(tString,
		 * rsaPrivateKey); System.out.println("解密:"+t);
		 */
	}

}

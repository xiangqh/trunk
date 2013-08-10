package com.zzuli.oj.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @author xiangqh
 *
 */
public class MD5Util {

	public static String md5(String str) {
		String $s = str;
		if ($s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
				ex.getStackTrace();
			}
			BASE64Encoder baseEncoder = new BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest($s.getBytes("utf-8")));
			} catch (Exception ex) {
				ex.getStackTrace();
			}
			return value;
		}
	}

	// 对用户密码进行加密的方法
	public static String encryPassword(long mallId, String email,
			String password) {
		return encryWord(mallId, email, password);
	}

	public static String encryWord(long mallId, String email,
			String password){
		String s1 = md5Hex(mallId + password);
		String s2 = md5Hex(password + email);
		return md5Hex(s1 + s2);
	}

/*	private static boolean needEncrypt(long mallId) {
		String excludeIds = Config.getProperty("excludeids", "mall");
		if (StringUtils.isNotBlank(excludeIds)) {//配置文件中的mallIds包括不需要进行密码加密的个性化商城和开通UCenter的商城
			for (String id : excludeIds.split("\\,")) {
				if (mallId == Long.valueOf(id))
					return false;
			}
		}
		return true;
	}*/

	public static String md5Hex(String data) {
		return toHexString(md5_local(data));
	}

	public static String toHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; ++i) {
			sb.append("0123456789abcdef".charAt(b[i] >>> 4 & 0xF));
			sb.append("0123456789abcdef".charAt(b[i] & 0xF));
		}
		return sb.toString();
	}

	static MessageDigest getDigest() {
		try {
			return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] md5_local(String data) {
		return md5(data.getBytes());
	}

	public static byte[] md5(byte[] data) {
		return getDigest().digest(data);
	}
}

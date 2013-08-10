package com.zzuli.oj.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiangqh
 *
 */
public class CookieUtil {

    public static final String DOMAIN = ".localhost";
    public static final String USER_ID_KEY = "user_id";

    public static String getUserId(HttpServletRequest request) {
		return readCookie(request, USER_ID_KEY);
	}

    public static String readCookie(HttpServletRequest request, String key) {
		String res = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (key.equals(cookies[i].getName())) {
					res = cookies[i].getValue();
					break;
				}
			}
		}
		return decodeStr(res);
	}

    public static String decodeStr(String source) {
		String resultStr = "";
		if (source != null && source.length() > 0) {
			if (source.contains("%")) {
				try {
					resultStr = URLDecoder.decode(source, "UTF-8");
				}
				catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else {
				resultStr = source;
			}
		}
		return resultStr;
	}

	public static void writeCookie(HttpServletResponse response, String key, String value) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 写Cookie
	 * @param response	HPPT响应
	 * @param domain	域名
	 * @param key
	 * @param value
	 * @param maxAge	Cookie有效期
	 */
	public static void writeCookie(HttpServletResponse response, String key, String value, int maxAge) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
			cookie.setMaxAge(maxAge);
			cookie.setPath("/");
			cookie.setDomain(DOMAIN);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void delCookie(HttpServletResponse response, String key) {
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, URLEncoder.encode("", "UTF-8"));
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}

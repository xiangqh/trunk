package com.zzuli.oj.common.util;

import java.util.List;

public class ValueCheck {

	public ValueCheck() {
	}

	public static boolean checkId(String s, List<String> errors) {
		if (s == null || s.equals("")) {
			errors.add("User ID can not be NULL");
			return false;
		}
		if (s.getBytes().length > 20) {
			errors.add("User ID is too long");
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.toLowerCase().charAt(i);
			if (c == '>') {
				errors.add("User ID can not contain \">\"");
				return false;
			}
			if (c == '<') {
				errors.add("User ID can not contain \"<\"");
				return false;
			}
			if (c == '#') {
				errors.add("User ID can not contain \">#\"");
				return false;
			}
			if (c == '&') {
				errors.add("User ID can not contain \"&\"");
				return false;
			}
			if ((c < 'a' || c > 'z') && (c > '9' || c < '0') && c != '_' && c != ' ') {
				errors.add("User ID can only contain number,letter and '_'");
				return false;
			}
		}

		return true;
	}

	public static boolean checkPassword(String s, List<String> errors) {
		if (s == null || s.equals("")) {
			errors.add("Password can not be NULL");
			return false;
		}
		if (s.getBytes().length > 20) {
			errors.add("Password is too long");
			return false;
		}
		if (s.getBytes().length < 1) {
			errors.add("Password is too short");
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				errors.add("Password can not contain blank");
				return false;
			}
		}

		return true;
	}

	public static boolean checkNick(String s, List<String> errors) {
		if (s == null || s.equals("")) {
			errors.add("nick can not be NULL");
			return false;
		}
		if (s.getBytes().length > 100) {
			errors.add("nick is too long");
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '"') {
				errors.add("nick can not contain \"");
				return false;
			}
		}

		return true;
	}

}

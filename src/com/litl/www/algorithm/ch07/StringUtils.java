package com.litl.www.algorithm.ch07;

public class StringUtils {
	public static boolean isPalindrome(String str) {
		if (str == null || str.length() == 0) {
			throw new RuntimeException("字符串为空");
		}
		int middle = (str.length() - 1) / 2;
		for (int i = 0; i <= middle; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static int longestPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		int max = 0, current = 0, length = str.length();
		for (int i = 0; i < length; ++i) {
			for (int j = 0; i - j >= 0 && i + j < length; j++) {
				if (str.charAt(i - j) != str.charAt(i + j)) {
					break;
				}
				current = j * 2 + 1;
			}
			if (current > max) {
				max = current;
			}
			current = 0;
			for (int j = 0; (i - j >= 0) && (i + j + 1 < length); j++) {
				if (str.charAt(i - j) != str.charAt(i + j + 1)) {
					break;
				}
				current = j * 2 + 2;
			}
			if (current > max) {
				max = current;
			}
		}
		return max;
	}

	public static int toInt(String str) {
		if (str == null || str.length() == 0) {
			throw new RuntimeException("字符串为空");
		}
		int result = 0;
		int current = 0;
		char sign = '+';
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			sign = str.charAt(0);
			str = str.substring(1);
		}
		boolean judgeOverflow = true;
		if (str.length() > 10) {
			throw new RuntimeException("整型溢出了");
		} else if (str.length() < 10) {
			judgeOverflow = false;
		}
		for (int i = 0; i < str.length(); i++) {
			current = str.charAt(i) - '0';
			if (current > 9 || current < 0) {
				throw new RuntimeException("包含非整型数字字符");
			}
			if (judgeOverflow) {
				if (sign == '+' && (result == 0 || result == Integer.MAX_VALUE / (int) Math.pow(10, 9 - i + 1))
						&& current > Integer.MAX_VALUE / (int) Math.pow(10, 9 - i) % 10) {
					System.err.println(current);
					throw new RuntimeException("整型溢出了");
				}
			}
			result = result * 10 + current;
		}
		if (sign == '-') {
			result = -result;
		}
		return result;
	}

}

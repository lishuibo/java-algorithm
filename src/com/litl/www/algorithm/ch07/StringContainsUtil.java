package com.litl.www.algorithm.ch07;

import com.litl.www.algorithm.ch01.HashTable;

public class StringContainsUtil {
	public static boolean contains(String str1, String str2) {
		for (int i = 0; i < str2.length(); i++) {
			char b = str2.charAt(i);
			int count = 0;
			for (int j = 0; j < str1.length(); j++) {
				char a = str1.charAt(j);
				if (a != b) {
					count++;
				}
			}
			if (count == str1.length()) {
				return false;
			}
		}
		return true;
	}

	public static boolean contains2(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		quickSort(c1, 0, c1.length - 1);
		quickSort(c2, 0, c2.length - 1);
		for (int p1 = 0, p2 = 0; p2 < c2.length; p2++) {
			while ((p1 < c1.length) && (c1[p1] < c2[p2])) {
				p1++;
			}
			if ((p1 >= c1.length) || (c1[p1] > c2[p2])) {
				return false;
			}
		}
		return true;
	}

	private static void quickSort(char[] src, int begin, int end) {
		// TODO Auto-generated method stub
		if (begin < end) {
			char key = src[begin];
			int i = begin;
			int j = end;
			while (i < j) {
				while (i < j && src[j] > key) {
					j--;
				}
				if (i < j) {
					src[i] = src[j];
					i++;
				}
				while (i < j && src[i] < key) {
					i++;
				}
				if (i < j) {
					src[j] = src[i];
					j--;
				}
			}
			src[i] = key;
			quickSort(src, begin, i - 1);
			quickSort(src, i + 1, end);
		}
	}

	public static boolean contains3(String str1, String str2) {
		int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
				101 };
		int all = 1;
		for (int i = 0; i < str1.length(); i++) {
			int x = prime[str1.charAt(i) - 'A'];
			if (all % x != 0) {
				all *= x;
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			int x = prime[str2.charAt(i) - 'A'];
			if (all % x != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean contains4(String str1, String str2) {
		HashTable hashTable = new HashTable();
		for (int i = 0; i < str1.length(); i++) {
			hashTable.put(str1.charAt(i), 1);
		}
		for (int i = 0; i < str2.length(); i++) {
			int value = hashTable.get(str2.charAt(i));
			if (value != 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean contains5(String str1, String str2) {
		int result = 0;
		for (int i = 0; i < str1.length(); i++) {
			result |= (1 << (str1.charAt(i) - 'A'));
		}
		for (int i = 0; i < str2.length(); i++) {
			if ((result & (1 << (str2.charAt(i) - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}
}

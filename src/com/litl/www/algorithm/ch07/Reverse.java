package com.litl.www.algorithm.ch07;

public class Reverse {
	public static String reverse(String str, int start, int end) {
		char[] array = str.toCharArray();
		int finish = end + 1;
		while (finish > start) {
			char temp = array[start];
			for (int j = start + 1; j < finish; j++) {
				array[j - 1] = array[j];
			}
			array[finish - 1] = temp;
			finish--;
		}
		return String.valueOf(array);
	}

	public static String reverse2(String str, int start, int end) {
		char[] array = str.toCharArray();
		int mid = start + (end - start) / 2;
		for (int i = 0; i <= mid - start; i++) {
			swap(array, start + i, end - i);
		}
		return String.valueOf(array);
	}

	private static void swap(char[] array, int left, int right) {
		// TODO Auto-generated method stub
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static String rotate(String str, int index) {
		str = reverse2(str, 0, index);
		str = reverse2(str, index + 1, str.length() - 1);
		str = reverse2(str, 0, str.length() - 1);
		return str;
	}
}

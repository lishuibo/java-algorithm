package com.litl.www.algorithm.ch07;

import com.litl.www.algorithm.ch03.ShellSort;

public class FullPermutation {
	public static void recursivePermutation(String str) {
		char[] array = str.toCharArray();
		recursivePermutation(array, 0, array.length - 1);
	}

	private static void recursivePermutation(char[] array, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end) {
			for (int i = 0; i <= end; i++) {
				System.out.print(array[i]);
			}
			System.out.println();
		} else {
			for (int j = start; j <= end; j++) {
				swap(array, j, start);
				recursivePermutation(array, start + 1, end);
				swap(array, j, start);
			}
		}
	}

	private static void swap(char[] array, int left, int right) {
		// TODO Auto-generated method stub
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void asciiPermutation(String str) {
		char[] array = str.toCharArray();
		shellSort(array);
		int length = array.length;
		int i = 0;
		while (true) {
			System.out.println(array);
			for (i = length - 2; (i >= 0) && (array[i] >= array[i + 1]); --i) {
				;
			}
			if (i < 0) {
				return;
			}
			int j;
			for (j = length - 1; (j > i) && (array[j] <= array[i]); --j) {
				;
			}
			swap(array, i, j);
			reverse(array, i + 1, length - 1);
		}
	}

	private static void reverse(char[] array, int start, int end) {
		// TODO Auto-generated method stub
		int mid = start + (end - start) / 2;
		for (int i = 0; i <= mid - start; i++) {
			swap(array, start + i, end - i);
		}
	}

	private static void shellSort(char[] array) {
		// TODO Auto-generated method stub
		char temp;
		for (int k = array.length / 2; k > 0; k /= 2) {
			for (int i = k; i < array.length; i++) {
				for (int j = i; j >= k; j -= k) {
					if (array[j - k] > array[j]) {
						temp = array[j - k];
						array[j - k] = array[j];
						array[j] = temp;
					}
				}

			}
		}
	}
}

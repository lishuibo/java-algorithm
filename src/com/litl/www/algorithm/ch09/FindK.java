package com.litl.www.algorithm.ch09;

public class FindK {
	public static void find(int[] array, int begin, int end, int k) {
		int i = partition(array, begin, end);
		if (i + 1 > k) {
			find(array, begin, i - 1, k);
		} else if (i + 1 < k) {
			find(array, i + 1, end, k);
		} else {
			System.out.println("找到了:" + array[i]);
			return;
		}
	}

	private static int partition(int[] array, int begin, int end) {
		// TODO Auto-generated method stub
		if (begin < end) {
			int key = array[begin];
			while (begin < end) {
				while (begin < end && array[end] > key) {
					end--;
				}
				if (begin < end) {
					array[begin] = array[end];
					begin++;
				}
				while (begin < end && array[begin] < key) {
					begin++;
				}
				if (begin < end) {
					array[end] = array[begin];
					end--;
				}
			}
			array[begin] = key;
		}
		return begin;
	}
}
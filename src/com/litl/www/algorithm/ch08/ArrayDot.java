package com.litl.www.algorithm.ch08;

public class ArrayDot {
	public static void findDot1(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				System.out.println("拐点元素为" + array[i] + "下标为" + i);
				return;
			}
		}
	}

	public static void findDot2(int[] array) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (high - low == 1) {
				if (array[low] < array[0]) {
					System.out.println("拐点元素为" + array[low] + "下标为" + low);
					return;
				} else {
					System.out.println("拐点元素为" + array[high] + "下标为" + high);
					return;
				}
			}
			int middle = (low + high) / 2;
			if (array[middle] >= array[low]) {
				low = middle;
			} else {
				high = middle;
			}
		}
	}
}

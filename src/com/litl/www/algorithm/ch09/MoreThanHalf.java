package com.litl.www.algorithm.ch09;

import com.litl.www.algorithm.ch01.HashTable;
import com.litl.www.algorithm.ch03.QuickSort;

public class MoreThanHalf {
	public static void find1(int[] array) {
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		int count = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[i - 1]) {
				if (count > array.length / 2) {
					System.out.println("找到这个元素为" + array[i - 1]);
					return;
				} else {
					count = 1;
				}
			} else {
				count++;
			}
		}
		if (count > array.length / 2) {
			System.out.println("找到这个元素为" + array[array.length - 1]);
		} else {
			System.out.println("没有找到");
		}
	}

	public static void find2(int[] array) {
		if (array.length == 1) {
			System.out.println("找到这个元素为" + array[0]);
			return;
		}
		HashTable hashTable = new HashTable();
		for (int i = 0; i < array.length; i++) {
			int count = hashTable.get(array[i]);
			if (count > 0) {
				count++;
				if (count > array.length / 2) {
					System.out.println("找到这个元素为" + array[i]);
					return;
				}
				hashTable.put(array[i], count);
			} else {
				hashTable.put(array[i], 1);
			}
		}
		System.out.println("没有找到");
	}

	public static void find3(int[] array) {
		int t = array[0];
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == t) {
				n++;
			} else {
				n--;
			}
			if (n == 0) {
				t = array[i];
				n = 1;
			}
		}
		System.out.println("找到这个元素为" + t);
	}
}

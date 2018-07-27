package com.litl.www.algorithm.ch09;

import com.litl.www.algorithm.ch01.HashTable;
import com.litl.www.algorithm.ch03.QuickSort;

public class LostNumber {
	public static void find1(int[] array) {
		QuickSort sort = new QuickSort(array);
		sort.sort();
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] != 1) {
				System.out.println("缺失的数字为" + (array[i] - 1));
				return;
			}
		}
	}

	public static void find2(int[] array) {
		QuickSort sort = new QuickSort(array);
		sort.sort();
		for (int i = 1; i < array.length; i++) {
			if (array[i] != i + 1) {
				System.out.println("缺失的数字为" + (array[i] - 1));
				return;
			}
		}
	}

	public static void find3(int[] array) {
		HashTable hashTable = new HashTable();
		for (int i = 0; i < array.length; i++) {
			hashTable.put(array[i], 1);
		}
		for (int i = 1; i <= 100; i++) {
			if (hashTable.get(i) == -1) {
				System.out.println("缺失的数字为" + i);
				return;
			}
		}
	}

	public static void find4(int[] array) {
		int all = (1 + 100) * 100 / 2;
		for (int i = 0; i < array.length; i++) {
			all -= array[i];
		}
		System.out.println("缺失的数字为" + all);
	}
}

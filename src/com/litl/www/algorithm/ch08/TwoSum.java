package com.litl.www.algorithm.ch08;

import com.litl.www.algorithm.ch01.HashTable;
import com.litl.www.algorithm.ch03.QuickSort;

public class TwoSum {
	public static void find1(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == sum - array[j]) {
					System.out.println(String.format("i:%d,j:%d", i, j));
					return;
				}
			}
		}
	}

	public static void find2(int[] array, int sum) {
		HashTable hashTable = new HashTable();
		for (int i = 0; i < array.length; i++) {
			hashTable.put(array[i], i);
		}
		for (int i = 0; i < array.length; i++) {
			int index = hashTable.get(sum - array[i]);
			if (index != -1 && index != i) {
				System.out.println(String.format("i:%d,j:%d", index, i));
				return;
			}
		}
	}

	public static void find3(int[] array, int sum) {
		QuickSort sort = new QuickSort(array);
		sort.sort();
		int[] array2 = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			array2[i] = sum - array[i];
		}
		int i = 0;
		int j = array2.length - 1;
		while (i < j) {
			if (array[i] == array2[j]) {
				System.out.println(String.format("i:%d,j:%d", i, j));
				return;
			} else if (array[i] < array2[j]) {
				while (i < j && array[i] < array2[j]) {
					i++;
				}
			} else {
				while (i < j && array[i] > array2[j]) {
					j--;
				}
			}
		}
	}

	public static void find4(int[] array, int sum) {
		QuickSort sort = new QuickSort(array);
		sort.sort();
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			int sumTemp = array[i] + array[j];
			if (sumTemp == sum) {
				System.out.println(String.format("i:%d,j:%d", i, j));
				return;
			} else if (sumTemp > sum) {
				j--;
			} else if (sumTemp < sum) {
				i++;
			}
		}
	}
}

package com.litl.www.algorithm.ch05;

public class HeapSortTest {
	public static void main(String[] args) {
		Heap heap = new Heap(100);
		int[] array = { 9, 18, 64, 15, 29, 66, 12, 48 };
		for (int i = 0; i < array.length; i++) {
			heap.insert(array[i]);
		}
		heap.sort();
	}
}

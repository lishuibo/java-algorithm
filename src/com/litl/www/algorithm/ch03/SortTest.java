package com.litl.www.algorithm.ch03;

public class SortTest {
	public static void main(String[] args) {
		// testBucketSort();
		// testBubbleSort();
		// testQuickSort();
		// testInsertSort();
		// testShellSort();
		testSelectSort();
	}

	private static void testSelectSort() {
		// TODO Auto-generated method stub
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		SelectSort selectSort = new SelectSort(array);
		selectSort.sort();
		selectSort.print();
	}

	private static void testShellSort() {
		// TODO Auto-generated method stub
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		ShellSort shellSort = new ShellSort(array);
		shellSort.sort();
		shellSort.print();
	}

	private static void testInsertSort() {
		// TODO Auto-generated method stub
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		InsertSort insertSort = new InsertSort(array);
		insertSort.sort();
		insertSort.print();
	}

	private static void testQuickSort() {
		// TODO Auto-generated method stub
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		QuickSort quickSort = new QuickSort(array);
		quickSort.sort();
		quickSort.print();
	}

	private static void testBucketSort() {
		// TODO Auto-generated method stub
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		BucketSort bucketSort = new BucketSort(11, array);
		bucketSort.sort();
		bucketSort.print();
	}

	private static void testBubbleSort() {
		// TODO Auto-generated method stub
		int[] array = { 5, 9, 1, 9, 5, 3, 7, 6, 1 };
		BubbleSort bubbleSort = new BubbleSort(array);
		bubbleSort.sort();
		// bubbleSort.sort2();
		bubbleSort.print();
	}
}

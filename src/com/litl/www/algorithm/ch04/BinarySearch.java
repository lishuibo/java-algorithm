package com.litl.www.algorithm.ch04;

public class BinarySearch {
	private int[] array;

	public BinarySearch(int[] array) {
		this.array = array;
	}

	public int searchRecursion(int target) {
		if (array != null) {
			return searchRecursion(target, 0, array.length - 1);
		}
		return -1;
	}

	private int searchRecursion(int target, int start, int end) {
		// TODO Auto-generated method stub
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (array[mid] == target) {
			return mid;
		} else if (target < array[mid]) {
			return searchRecursion(target, start, mid - 1);
		} else {
			return searchRecursion(target, mid + 1, end);
		}
	}

	public int search(int target) {
		if (array == null) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (target < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public void sort() {
		if (array == null) {
			throw new RuntimeException("array is null");
		}
		if (array.length > 0) {
			for (int i = 1; i < array.length; i++) {
				int temp = array[i];
				int insertIndex = binarySearch(i - 1, temp);
				if (i != insertIndex) {
					for (int j = i - 1; j >= insertIndex; j--) {
						array[j] = array[j - 1];
					}
					array[insertIndex] = temp;
				}
			}
		}
	}

	private int binarySearch(int maxIndex, int data) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = maxIndex;
		int mid = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (array[mid] > data) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

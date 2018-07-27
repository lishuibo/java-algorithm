package com.litl.www.algorithm.ch04;

public class SequentialSearch {
	private int[] array;

	public SequentialSearch(int[] array) {
		this.array = array;
	}

	public int search(int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public int search2(int key) {
		if (key == array[0]) {
			return 0;
		}
		int temp = array[0];
		array[0] = key;
		int i = array.length - 1;
		while (array[i] != key) {
			i--;
		}
		array[0] = temp;
		if (i == 0) {
			return -1;
		}
		return i;
	}
}

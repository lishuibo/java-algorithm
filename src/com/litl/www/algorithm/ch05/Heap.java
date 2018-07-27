package com.litl.www.algorithm.ch05;

public class Heap {
	private int[] element;

	public Heap(int maxSize) {
		element = new int[maxSize + 1];
		element[0] = 0;
	}

	public boolean isEmpty() {
		return element[0] == 0;
	}

	public boolean isFull() {
		return element[0] == element.length - 1;
	}

	public void insert(int value) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("堆已经满了");
		}
		if (isEmpty()) {
			element[1] = value;
		} else {
			int i = element[0] + 1;
			while (i != 1 && value > element[i / 2]) {
				element[i] = element[i / 2];
				i /= 2;
			}
			element[i] = value;
		}
		element[0]++;
	}

	public int delete() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("堆已经满了");
		}
		int deleteElement = element[1];
		element[1] = element[element[0]];
		element[0]--;
		int temp = element[1];
		int parent = 1;
		int child = 2;
		while (child <= element[0]) {
			if (child < element[0] && element[child] < element[child + 1]) {
				child++;
			}
			if (temp > element[child]) {
				break;
			} else {
				element[parent] = element[child];
				parent = child;
				child *= 2;
			}
		}
		element[parent] = temp;
		return deleteElement;
	}

	public void printAll() {
		for (int i = 0; i < element[0] + 1; i++) {
			System.out.print(element[i]);
			if (i != element[0]) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public void sort() {
		if (isEmpty()) {
			throw new RuntimeException("初始化数据排序");
		}
		int size = element[0];
		for (int i = 0; i < size; i++) {
			int deleteElement = delete();
			element[element[0] + 1] = deleteElement;
		}
		for (int i = 1; i < size + 1; i++) {
			System.out.print(element[i]);
			if (i != size) {
				System.out.print(",");
			}
		}
	}
}

package com.litl.www.algorithm.ch04;

import com.litl.www.algorithm.ch01.ArrayList;

public class BlockSearch {
	private int[] index;
	private ArrayList[] list;

	public BlockSearch(int[] index) {
		if (index != null && index.length != 0) {
			this.index = index;
			this.list = new ArrayList[index.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList();
			}
		} else {
			throw new Error("index cannot be null or empty.");
		}
	}

	public void insert(int value) {
		int i = binarySearch(value);
		list[i].add(value);
	}

	public boolean search(int data) {
		int i = binarySearch(data);
		for (int j = 0; j < list[i].size(); j++) {
			if (data == list[i].get(j)) {
				return true;
			}
		}
		return false;
	}

	public void printAll() {
		for (int i = 0; i < list.length; i++) {
			ArrayList l = list[i];
			System.out.println("ArrayList " + i + ":");
			for (int j = 0; j < l.size(); j++) {
				System.out.println(l.get(j));
			}
		}
	}

	private int binarySearch(int data) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = index.length;
		int mid = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (index[mid] > data) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}

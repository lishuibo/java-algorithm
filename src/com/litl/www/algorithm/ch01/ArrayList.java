package com.litl.www.algorithm.ch01;

import java.util.Arrays;

public class ArrayList {
	private static final int INITIAL_SIZE = 10;
	private int size = 0;
	private int[] array;

	public ArrayList() {
		array = new int[INITIAL_SIZE];
	}

	public ArrayList(int initial) {
		if (initial <= 0) {
			initial = INITIAL_SIZE;
		}
		array = new int[initial];
	}

	// 添加元素
	public void add(int num) {
		if (size == array.length) {
			array = Arrays.copyOf(array, size * 2);
		}
		array[size++] = num;
	}

	// 获取指定位置的元素
	public int get(int i) {
		if (i >= size) {
			throw new IndexOutOfBoundsException("获取的元素位置超过了最大长度");
		}
		return array[i];
	}

	// 设定指定位置的元素值
	public int set(int i, int num) {
		int oldNum = get(i);
		array[i] = num;
		return oldNum;
	}

	// 获取变长数组的长度
	public int size() {
		return size;
	}
}

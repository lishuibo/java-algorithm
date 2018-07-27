package com.litl.www.algorithm.ch02;

import java.util.Arrays;

public class Stack {
	private int size = 0;
	private int[] array;

	public Stack() {
		this(10);
	}

	public Stack(int i) {
		// TODO Auto-generated constructor stub
		if (i <= 10) {
			i = 10;
		}
		array = new int[i];
	}

	// 入栈
	public void push(int item) {
		if (size == array.length) {
			array = Arrays.copyOf(array, size * 2);
		}
		array[size++] = item;
	}

	// 获取栈顶的数据 但是没有出栈
	public int peek() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("栈里面为空");
		}
		return array[size - 1];
	}

	// 出栈 同时获取栈顶元素
	public int pop() {
		int item = peek();
		size--;
		return item;
	}

	// 栈是否满了
	public boolean isFull() {
		return size == array.length;
	}

	// 栈是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}

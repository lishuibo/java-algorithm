package com.litl.www.algorithm.ch11;

import java.util.Arrays;

public class Stack<E> {
	private int size = 0;
	private Object[] array;

	public Stack() {
		this(10);
	}

	public Stack(int initialCapacity) {
		// TODO Auto-generated constructor stub
		if (initialCapacity <= 0) {
			throw new RuntimeException("初始化栈空间错误");
		}
		array = new Object[initialCapacity];
	}

	public E push(E item) {
		ensureCapacityHelper(size + 1);
		array[size++] = item;
		return item;
	}

	public E peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("栈已经为空");
		}
		return (E) array[size - 1];
	}

	public E pop() {
		E item = peek();
		size--;
		return item;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void ensureCapacityHelper(int minCapacity) {
		// TODO Auto-generated method stub
		if (minCapacity > array.length) {
			grow();
		}
	}

	private void grow() {
		// TODO Auto-generated method stub
		int oldCapacity = array.length;
		int newCapacity = oldCapacity * 2;
		if (newCapacity < oldCapacity) {
			throw new OutOfMemoryError();
		} else {
			array = Arrays.copyOf(array, newCapacity);
		}
	}
}

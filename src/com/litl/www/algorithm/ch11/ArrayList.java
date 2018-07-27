package com.litl.www.algorithm.ch11;

import java.util.Arrays;

public class ArrayList<T> {
	private static final int INITIAL_CAPACITY = 10;
	private int size = 10;
	private Object[] array;

	public ArrayList() {
		this(INITIAL_CAPACITY);
	}

	public ArrayList(int initial) {
		// TODO Auto-generated constructor stub
		if (initial <= 0) {
			throw new RuntimeException("初始化变长数组空间错误");
		}
		array = new Object[initial];
	}

	public void add(Object o) {
		ensureCapacityHelper(size + 1);
		array[size++] = o;
	}

	public T get(int i) {
		rangeCheck(i);
		return elementData(i);
	}

	public T set(int i, Object o) {
		rangeCheck(i);
		T old = elementData(i);
		array[i] = o;
		return old;
	}

	public T remove(int i) {
		rangeCheck(i);
		T old = elementData(i);
		int numMoved = size - i - 1;
		if (numMoved > 0) {
			System.arraycopy(array, i + 1, array, i, numMoved);
		}
		array[--size] = null;
		return old;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public T getFirst() {
		return get(0);
	}

	public T getLast() {
		return get(size - 1);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private T elementData(int index) {
		// TODO Auto-generated method stub
		return (T) array[index];
	}

	private void rangeCheck(int index) {
		// TODO Auto-generated method stub
		if (index >= size) {
			throw new IndexOutOfBoundsException("当前下标不存在");
		}
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

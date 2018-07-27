package com.litl.www.algorithm.ch02;

public class ArrayQueue {
	private final Object[] items;
	private int head = 0;
	private int tail = 0;

	// 初始化队列
	public ArrayQueue(int capacity) {
		this.items = new Object[capacity];
	}

	// 入队
	public boolean put(Object item) {
		// 队列已满
		if (head == (tail + 1) % items.length) {
			return false;
		}
		items[tail] = item;
		// tail标记向后移动一位
		tail = (tail + 1) % items.length;
		return true;
	}

	// 获取队列头元素 不出队
	public Object peek() {
		if (head == tail) {
			return null;
		}
		return items[head];
	}

	// 出队
	public Object poll() {
		if (head == tail) {
			return null;
		}
		Object item = items[head];
		// 把没有的元素赋空值
		items[head] = null;
		// head标记向后移动一位
		head = (head + 1) % items.length;
		return item;
	}

	public boolean isFull() {
		return head == (tail + 1) % items.length;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	// 队列元素
	public int size() {
		if (tail >= head) {
			return tail - head;
		} else {
			return tail + items.length - head;
		}
	}
}

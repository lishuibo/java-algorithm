package com.litl.www.algorithm.ch02.extend;

import com.litl.www.algorithm.ch02.ArrayQueue;

public class QueueToStack {
	private ArrayQueue queue1;
	private ArrayQueue queue2;
	private int maxLength;

	public QueueToStack(int capacity) {
		maxLength = capacity;
		queue1 = new ArrayQueue(capacity);
		queue2 = new ArrayQueue(capacity);
	}

	public boolean push(int item) {
		if (size() == maxLength) {
			return false;
		}
		if (queue2.isEmpty()) {
			queue1.put(item);
		} else {
			queue2.put(item);
		}

		return true;
	}

	public Object pop() {
		if (size() == 0) {
			throw new IndexOutOfBoundsException("栈空了");
		} else {
			if (queue2.isEmpty()) {
				while (queue1.size() > 1) {
					queue2.put(queue1.poll());
				}
				return queue1.poll();
			} else {
				while (queue2.size() > 1) {
					queue1.put(queue2.poll());
				}
				return queue2.poll();
			}
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return queue1.size() + queue2.size();
	}
}

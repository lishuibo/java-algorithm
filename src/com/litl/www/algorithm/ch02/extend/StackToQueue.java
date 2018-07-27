package com.litl.www.algorithm.ch02.extend;

import com.litl.www.algorithm.ch02.Stack;
import com.sun.glass.ui.Size;

public class StackToQueue {
	private Stack stack1;
	private Stack stack2;
	private int maxLength;

	public StackToQueue(int capacity) {
		maxLength = capacity;
		stack1 = new Stack(capacity);
		stack2 = new Stack(capacity);
	}

	public boolean put(int item) {
		if (stack1.isFull() || maxLength == size()) {
			return false;
		}
		stack1.push(item);
		return true;
	}

	public int poll() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return stack1.size() + stack2.size();
	}
}

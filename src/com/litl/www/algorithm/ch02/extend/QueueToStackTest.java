package com.litl.www.algorithm.ch02.extend;

public class QueueToStackTest {
	public static void main(String[] args) {
		QueueToStack stack = new QueueToStack(5);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

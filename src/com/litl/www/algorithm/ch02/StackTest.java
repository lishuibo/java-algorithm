package com.litl.www.algorithm.ch02;

public class StackTest {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.size());
		
		stack.push(3);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}
}

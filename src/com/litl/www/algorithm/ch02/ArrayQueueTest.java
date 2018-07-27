package com.litl.www.algorithm.ch02;

public class ArrayQueueTest {
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(4);
		System.out.println(arrayQueue.put("a"));
		System.out.println(arrayQueue.put("b"));
		System.out.println(arrayQueue.put("c"));
		System.out.println(arrayQueue.put("d"));
		
		System.out.println(arrayQueue.isFull());
		
		System.out.println(arrayQueue.size());
		System.out.println(arrayQueue.peek());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
		
		System.out.println(arrayQueue.isEmpty());
	}
}

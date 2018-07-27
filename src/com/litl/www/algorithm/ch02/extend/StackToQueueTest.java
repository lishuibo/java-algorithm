package com.litl.www.algorithm.ch02.extend;

public class StackToQueueTest {
	public static void main(String[] args) {
		StackToQueue queue = new StackToQueue(5);
		queue.put(1);
		queue.put(2);
		System.out.println(queue.poll());
		
		queue.put(3);
		queue.put(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}

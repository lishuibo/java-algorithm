package com.litl.www.algorithm.ch02.extend;

public class StaticLinkedListTest {
	public static void main(String[] args) {
		StaticLinkedList link = new StaticLinkedList(10);
		link.insertFirst(2);
		link.insertFirst(1);
		link.insertLast(4);
		link.insertLast(5);
		link.insert(3, 1);
		link.printAll();
		link.deleteFirst();
		link.deleteLast();
		link.delete(1);
		link.printAll();
		System.out.println(link.get(1).getData());
		link.deleteFirst();
		link.deleteFirst();
		System.out.println(link.size());
	}
}

package com.litl.www.algorithm.ch02;

public class LinkTest {
	public static void main(String[] args) {
		Link link = new Link();
		link.addFirst(2);
		link.addFirst(1);
		link.addLast(4);
		link.addLast(5);
		link.add(3, 1);
		printAllElements(link);
		link.printAll();
		link.removeFirst();
		link.removeLast();
		link.removeMiddle(1);
		printAllElements(link);
		link.removeFirst();
		link.removeLast();
		System.out.println(link.size());
	}

	private static void printAllElements(Link link) {
		// TODO Auto-generated method stub
		for (int i = 0; i < link.size(); i++) {
			System.out.println(link.get(i).getData());
		}
	}

}

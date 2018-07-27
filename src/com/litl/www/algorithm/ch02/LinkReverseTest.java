package com.litl.www.algorithm.ch02;

public class LinkReverseTest {
	public static void main(String[] args) {
		Link link = new Link();
		link.addLast(1);
		link.addLast(2);
		link.addLast(3);
		link.addLast(4);
		printAllElements(link);
		link.reverse();
		printAllElements(link);
	}

	private static void printAllElements(Link link) {
		// TODO Auto-generated method stub
		for (int i = 0; i < link.size(); i++) {
			System.out.println(link.get(i).getData());
		}
	}

}

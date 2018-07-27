package com.litl.www.algorithm.ch01;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		System.out.println(arrayList.get(3));
		arrayList.set(3, 9);
		System.out.println(arrayList.get(3));
		System.out.println(arrayList.size());
	}
}

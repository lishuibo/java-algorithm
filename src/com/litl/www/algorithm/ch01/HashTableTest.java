package com.litl.www.algorithm.ch01;

public class HashTableTest {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.put(1, 10);
		hashTable.put(2, 20);
		hashTable.put(5, 50);
		System.out.println(hashTable.getLength());

		hashTable.put(3, 30);
		System.out.println(hashTable.getLength());

		hashTable.put(6, 60);
		hashTable.put(7, 70);
		System.out.println(hashTable.getLength());
		
		System.out.println(hashTable.get(1));
		System.out.println(hashTable.get(3));
		System.out.println(hashTable.get(5));
		System.out.println(hashTable.get(6));
	}
}

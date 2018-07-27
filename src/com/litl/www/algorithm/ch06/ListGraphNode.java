package com.litl.www.algorithm.ch06;

public class ListGraphNode {
	int index;
	int value;
	int weight;
	ListGraphNode next;

	public ListGraphNode(int value, ListGraphNode next) {
		super();
		this.value = value;
		this.next = next;
	}

	public ListGraphNode(int index, int value, ListGraphNode next) {
		super();
		this.index = index;
		this.value = value;
		this.next = next;
	}

	public ListGraphNode(int index, int value, int weight, ListGraphNode next) {
		super();
		this.index = index;
		this.value = value;
		this.weight = weight;
		this.next = next;
	}

}

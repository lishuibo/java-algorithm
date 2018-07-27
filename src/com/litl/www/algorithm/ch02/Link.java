package com.litl.www.algorithm.ch02;

public class Link {
	private int size = 0;
	private Node first;
	private Node last;

	public Link() {

	}

	public void addLast(int data) {
		if (size == 0) {
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			last.setNext(node);
			last = node;
		}
		size++;
	}

	public void addFirst(int data) {
		if (size == 0) {
			fillStart(data);
		} else {
			Node node = new Node();
			node.setData(data);
			node.setNext(first);
			first = node;
		}
		size++;
	}

	public void add(int data, int index) {
		if (size > index) {
			if (size == 0) {
				fillStart(data);
				size++;
			} else if (index == 0) {
				addFirst(data);
				size++;
			} else if (size == index + 1) {
				addLast(data);
			} else {
				Node temp = get(index);
				Node node = new Node();
				node.setData(data);
				node.setNext(temp.getNext());
				temp.setNext(node);
				size++;
			}

		} else {
			throw new IndexOutOfBoundsException("列表没有那么长");
		}
	}

	public void removeFirst() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if (size == 1) {
			clear();
		} else {
			Node temp = first;
			first = temp.getNext();
			temp = null;
			size--;
		}
	}

	public void removeLast() {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if (size == 1) {
			clear();
		} else {
			Node temp = get(size - 2);
			temp.setNext(null);
			size--;
		}
	}

	public void removeMiddle(int index) {
		if (size == 0) {
			throw new IndexOutOfBoundsException("链表没有元素");
		} else if (size == 1) {
			clear();
		} else {
			if (index == 0) {
				removeFirst();
			} else if (size == index - 1) {
				removeLast();
			} else {
				Node temp = get(index - 1);
				Node next = temp.getNext();
				temp.setNext(next.getNext());
				next = null;
				size--;
			}
		}
	}

	public void clear() {
		// TODO Auto-generated method stub
		first = null;
		last = null;
		size = 0;
	}

	public Node get(int index) {
		// TODO Auto-generated method stub
		Node temp = first;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp;
	}

	public void fillStart(int data) {
		// TODO Auto-generated method stub
		first = new Node();
		first.setData(data);
		last = first;
	}

	public int size() {
		return size;
	}

	public void printAll() {
		Node temp = first;
		System.out.println(temp.getData());
		for (int i = 0; i < size - 1; i++) {
			temp = temp.getNext();
			System.out.println(temp.getData());
		}
	}

	public void reverse() {
		Node temp = first;
		last = temp;
		Node next = first.getNext();
		for (int i = 0; i < size - 1; i++) {
			Node nextNext = next.getNext();
			next.setNext(temp);
			temp = next;
			next = nextNext;
		}
		last.setNext(null);
		first = temp;
	}
}

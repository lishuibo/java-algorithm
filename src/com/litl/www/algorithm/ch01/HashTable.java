package com.litl.www.algorithm.ch01;

public class HashTable {
	// 散列表的初始化长度
	private static final int DEFAULT_INITIAL_CAPACITY = 4;
	// 扩容因子
	private static final float LOAD_FACTOR = 0.75f;

	// 散列表数组
	private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
	// 散列表元素的个数
	private int size = 0;
	// 散列表使用地址的个数
	private int use = 0;

	// 添加/修改
	public void put(int key, int value) {
		int index = hash(key);
		if (table[index] == null) {
			table[index] = new Entry(-1, -1, null);
		}
		Entry e = table[index];
		if (e.next == null) {
			// 不存在值 向列表添加
			table[index].next = new Entry(key, value, null);
			size++;
			use++;
			if (use >= table.length * LOAD_FACTOR) {
				resize();
			}
		} else {
			// 本身存在值 修改已有的值
			for (e = e.next; e != null; e = e.next) {
				int k = e.key;
				if (k == key) {
					e.value = value;
					return;
				}
			}
			// 不存在相同的值 直接向列表添加元素
			Entry temp = table[index].next;
			Entry newEntry = new Entry(key, value, temp);
			table[index].next = newEntry;
			size++;
		}
	}

	// 删除
	public void remove(int key) {
		int index = hash(key);
		Entry e = table[index];
		Entry pre = table[index];
		if (e != null && e.next != null) {
			for (e = e.next; e != null; pre = e, e = e.next) {
				int k = e.key;
				if (k == key) {
					pre.next = e.next;
					size--;
					return;
				}
			}
		}
	}

	// 获取
	public int get(int key) {
		int index = hash(key);
		Entry e = table[index];
		if (e != null && e.next != null) {
			for (e = e.next; e != null; e = e.next) {
				int k = e.key;
				if (k == key) {
					return e.value;
				}
			}
		}
		return -1;
	}

	public int getLength() {
		return table.length;
	}

	// 获取散列表中元素的个数
	public int size() {
		return size;
	}

	private void resize() {
		// TODO Auto-generated method stub
		int newLength = table.length * 2;
		Entry[] oldTable = table;
		table = new Entry[newLength];
		use = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if (oldTable[i] != null && oldTable[i].next != null) {
				Entry e = oldTable[i];
				while (null != e.next) {
					Entry next = e.next;
					// 重新计算哈希值 放入新的地址
					int index = hash(next.key);
					if (table[index] == null) {
						use++;
						table[index] = new Entry(-1, -1, null);
					}
					Entry temp = table[index].next;
					Entry newEntry = new Entry(next.key, next.value, temp);
					table[index].next = newEntry;
					e = next;
				}
			}
		}
	}

	private int hash(int key) {
		// TODO Auto-generated method stub
		return key % table.length;
	}
}

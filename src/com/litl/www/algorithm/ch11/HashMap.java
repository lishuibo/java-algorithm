package com.litl.www.algorithm.ch11;

import java.util.Arrays;

public class HashMap<K, V> {
	private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private Entry<K, V>[] table;

	final float loadFactor;
	private int size = 0;
	private int use = 0;

	public HashMap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public HashMap(int initCapacity) {
		// TODO Auto-generated constructor stub
		this(initCapacity, DEFAULT_LOAD_FACTOR);
	}

	public HashMap(int initCapacity, float loadFactor) {
		// TODO Auto-generated constructor stub
		this.table = new Entry[initCapacity];
		this.loadFactor = loadFactor;
	}

	public void put(K key, V value) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		if (e == null) {
			table[index] = new Entry<K, V>(key, value, null);
			size++;
			use++;
			if (use >= table.length * loadFactor) {
				resize();
			}
		} else {
			for (; e != null; e = e.next) {
				Object k = e.key;
				if (k == key || k.equals(key)) {
					e.value = value;
					return;
				}
			}
			Entry<K, V> temp = table[index];
			Entry<K, V> newEntry = new Entry<K, V>(key, value, temp);
			table[index] = newEntry;
			size++;
		}
	}

	public void remove(K key) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		Entry<K, V> pre = null;
		for (; e != null; pre = e, e = e.next) {
			if (pre == null) {
				table[index] = null;
			} else {
				pre.next = e.next;
				size--;
			}
			return;
		}
	}

	public V get(K key) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		for (; e != null; e = e.next) {
			Object k = e.key;
			if (k == key || k.equals(key)) {
				return e.value;
			}
		}
		return null;
	}

	public boolean containsKey(K key) {
		int index = hash(key);
		Entry<K, V> e = table[index];
		for (; e != null; e = e.next) {
			Object k = e.key;
			if (k == key || k.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		Arrays.fill(table, null);
		size = 0;
		use = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void resize() {
		// TODO Auto-generated method stub
		int newLength = table.length * 2;
		Entry<K, V>[] oldTable = table;
		table = new Entry[newLength];
		use = 0;
		for (int i = 0; i < oldTable.length; i++) {
			Entry<K, V> e = oldTable[i];
			while (null != e) {
				int index = hash(e.key);
				if (table[index] == null) {
					use++;
					table[index] = new Entry<K, V>(e.key, e.value, null);
				} else {
					Entry<K, V> temp = table[index];
					Entry<K, V> newEntry = new Entry<K, V>(e.key, e.value, temp);
					table[index] = newEntry;
				}
				e = e.next;
			}
		}
	}

	private int hash(K key) {
		// TODO Auto-generated method stub
		int hashCode = Math.abs(key.hashCode());
		hashCode %= table.length;
		return hashCode;
	}

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		Entry(K key, V value, Entry<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

}

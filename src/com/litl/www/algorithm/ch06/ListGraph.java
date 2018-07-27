package com.litl.www.algorithm.ch06;

import com.litl.www.algorithm.ch01.HashTable;
import com.litl.www.algorithm.ch02.ArrayQueue;
import com.litl.www.algorithm.ch02.Stack;

public class ListGraph {
	private ListGraphNode[] nodes;
	private HashTable valueToindex = new HashTable();

	public ListGraph(int[] vertexes) {
		nodes = new ListGraphNode[vertexes.length];
		for (int i = 0; i < vertexes.length; i++) {
			// nodes[i] = new ListGraphNode(vertexes[i], null);
			nodes[i] = new ListGraphNode(i, vertexes[i], null);
			valueToindex.put(vertexes[i], i);
		}
	}

	public void addEdges(int start, int[] end) {
		// for (int i = 0; i < nodes.length; i++) {
		// if (nodes[i].value == start) {
		// ListGraphNode node = nodes[i];
		// for (int j = 0; j < end.length; j++) {
		// node.next = new ListGraphNode(end[j], null);
		// node = node.next;
		// }
		// }
		// }
		int index = valueToindex.get(start);
		if (index < 0) {
			throw new RuntimeException("未找到指定的起始顶点");
		}
		ListGraphNode node = nodes[index];
		for (int j = 0; j < end.length; j++) {
			int i = valueToindex.get(end[j]);
			if (i < 0) {
				throw new RuntimeException("未找到指定的到达顶点");
			}
			node.next = new ListGraphNode(i, end[j], null);
			node = node.next;
		}
	}

	public void addEdges(int start, int[] end, int[] weights) {
		int index = valueToindex.get(start);
		if (index < 0) {
			throw new RuntimeException("未找到指定的起始顶点");
		}
		ListGraphNode node = nodes[index];
		for (int j = 0; j < end.length; j++) {
			int i = valueToindex.get(end[j]);
			if (i < 0) {
				throw new RuntimeException("未找到指定的到达顶点");
			}
			node.next = new ListGraphNode(i, end[j], weights[j], null);
			node = node.next;
		}
	}

	public void depthFirstTravel() {
		System.out.println("邻接表的深度优先遍历:");
		Stack stack = new Stack(nodes.length);
		int[] visited = new int[nodes.length];
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			visited[unvisited] = 1;
			stack.push(unvisited);
			System.out.print(nodes[unvisited].value + ",");
			while (!stack.isEmpty()) {
				int index = stack.peek();
				boolean found = false;
				ListGraphNode node = nodes[index];
				while (node != null) {
					if (node.next != null && visited[node.next.index] == 0) {
						visited[node.next.index] = 1;
						stack.push(node.next.index);
						System.out.print(node.next.value + ",");
						found = true;
						break;
					}
					node = node.next;
				}
				if (!found) {
					stack.pop();
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}

	private int getUnVisited(int[] visited) {
		// TODO Auto-generated method stub
		int index = -1;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void printListGraph() {
		for (int i = 0; i < nodes.length; i++) {
			ListGraphNode node = nodes[i];
			do {
				System.out.print(node.value);
				node = node.next;
			} while (node != null);
			System.out.println();
		}
	}

	public void breadthFirstTravel() {
		System.out.println("邻接矩阵的广度优先遍历:");
		ArrayQueue queue = new ArrayQueue(nodes.length);
		int[] visited = new int[nodes.length];
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			queue.put(unvisited);
			while (!queue.isEmpty()) {
				int index = (Integer) queue.poll();
				System.out.print(nodes[index].value + ",");
				visited[index] = 1;
				ListGraphNode node = nodes[index].next;
				while (node != null) {
					if (visited[node.index] == 0) {
						queue.put(node.index);
					}
					node = node.next;
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}

	public void dijkstra(int start) {
		int length = nodes.length;
		int x = valueToindex.get(start);
		if (x == -1) {
			throw new RuntimeException("未找到起始顶点");
		}

		int[] S = new int[length];
		int[][] distance = new int[length][length];
		int[] path = new int[length];
		for (int i = 0; i < length; i++) {
			path[i] = -1;
		}

		for (int i = 0; i < length; i++) {
			ListGraphNode node = nodes[i];
			node = node.next;
			while (node != null) {
				distance[i][node.index] = node.weight;
				if (x == i) {
					path[node.index] = x;
				}
				node = node.next;
			}
		}
		S[x] = 1;
		for (int i = 0; i < length; i++) {
			int min = Integer.MAX_VALUE;
			int v = 0;
			for (int j = 0; j < length; j++) {
				if (S[j] != 1 && x != j && distance[x][j] != 0 && distance[x][j] < min) {
					min = distance[x][j];
					v = j;
				}
			}
			S[v] = 1;
			for (int j = 0; j < length; j++) {
				if (S[j] != 1 && distance[v][j] != 0
						&& (min + distance[v][j] < distance[x][j] || distance[x][j] == 0)) {
					distance[x][j] = min + distance[v][j];
					path[j] = v;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (distance[x][i] != 0) {
				System.out.println(nodes[x].value + "-->" + nodes[i].value + ":" + distance[x][i]);
				System.out.print("逆序最短路径输出:");
				int index = i;
				while (index != -1) {
					System.out.print(nodes[index].value);
					index = path[index];
				}
				System.out.println();
			}
		}
	}
}

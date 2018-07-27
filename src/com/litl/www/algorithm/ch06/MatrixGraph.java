package com.litl.www.algorithm.ch06;

import com.litl.www.algorithm.ch02.ArrayQueue;
import com.litl.www.algorithm.ch02.Stack;

public class MatrixGraph {
	private int[] mapping;
	private int[][] matrix;

	public MatrixGraph(int[] vertexes) {
		int length = vertexes.length;
		mapping = new int[length];
		matrix = new int[length][length];
		for (int i = 0; i < length; i++) {
			mapping[i] = vertexes[i];
		}
	}

	public void addEdge(int start, int end) {
		int x = -1;
		int y = -1;
		for (int i = 0; i < mapping.length; i++) {
			if (x != -1 && y != -1) {
				break;
			}
			if (start == mapping[i]) {
				x = i;
			}
			if (end == mapping[i]) {
				y = i;
			}
		}
		if (x == -1 || y == -1 || x > mapping.length - 1 || y > mapping.length - 1) {
			throw new IndexOutOfBoundsException("边的顶点不存在");
		}
		matrix[x][y] = 1;
	}

	public void addEdge(int start, int end, int value) {
		int x = -1;
		int y = -1;
		for (int i = 0; i < mapping.length; i++) {
			if (x != -1 && y != -1) {
				break;
			}
			if (start == mapping[i]) {
				x = i;
			}
			if (end == mapping[i]) {
				y = i;
			}
		}
		if (x == -1 || y == -1 || x > mapping.length - 1 || y > mapping.length - 1) {
			throw new IndexOutOfBoundsException("边的顶点不存在");
		}
		matrix[x][y] = value;
	}

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	public void depthFirstTravel() {
		System.out.println("邻接矩阵的深度优先遍历:");
		Stack stack = new Stack(mapping.length);
		int[] visited = new int[mapping.length];
		int unvisited = getUnVisited(visited);
		while (unvisited >= 0) {
			visited[unvisited] = 1;
			stack.push(unvisited);
			System.out.print(mapping[unvisited] + ",");
			while (!stack.isEmpty()) {
				int index = stack.peek();
				boolean found = false;
				for (int i = 0; i < mapping.length; i++) {
					if (index != i && visited[i] == 0 && matrix[index][i] > 0) {
						visited[i] = 1;
						stack.push(i);
						System.out.print(mapping[i] + ",");
						found = true;
						break;
					}
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

	public void breadthFirstTravel() {
		System.out.println("邻接矩阵的广度优先遍历:");
		ArrayQueue queue = new ArrayQueue(mapping.length);
		int[] visited = new int[mapping.length];
		int unvisited = getUnVisited(visited);
		while (unvisited > 0) {
			queue.put(unvisited);
			while (!queue.isEmpty()) {
				int index = (Integer) queue.poll();
				if (visited[index] == 1) {
					continue;
				}
				System.out.print(mapping[index] + ",");
				visited[index] = 1;
				for (int i = 0; i < mapping.length; i++) {
					if (index != i && visited[i] == 0 && matrix[index][i] > 0) {
						queue.put(i);
					}
				}
			}
			unvisited = getUnVisited(visited);
		}
		System.out.println();
	}

	public void dijkstra(int start) {
		int length = mapping.length;
		int x = -1;
		for (int i = 0; i < length; i++) {
			if (mapping[i] == start) {
				x = i;
				break;
			}
		}
		if (x == -1) {
			throw new RuntimeException("未找到起始顶点");
		}

		int[] S = new int[length];
		int[][] distance = matrix;
		int[] path = new int[length];
		for (int i = 0; i < length; i++) {
			if (matrix[x][i] > 0) {
				path[i] = x;
			} else {
				path[i] = -1;
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
				System.out.println(mapping[x] + "-->" + mapping[i] + ":" + distance[x][i]);
				System.out.println("逆序最短路径输出:");
				int index = i;
				while (index != -1) {
					System.out.print(mapping[index]);
					index = path[index];
				}
				System.out.println();
			}
		}
	}
}

package com.litl.www.algorithm.ch06;

public class ListGraphTest {
	public static void main(String[] args) {
		// int[] vertexes = { 0, 1, 2, 3 };
		// ListGraph graph = new ListGraph(vertexes);
		// graph.addEdges(0, new int[] { 1, 2, 3 });
		// graph.addEdges(1, new int[] { 2 });
		// graph.addEdges(3, new int[] { 2 });
		// graph.printListGraph();
		int[] vertexes = { 0, 1, 2, 3, 4, 5, 6 };
		ListGraph graph = new ListGraph(vertexes);
		graph.addEdges(0, new int[] { 1, 2 });
		graph.addEdges(1, new int[] { 3, 4 });
		graph.addEdges(2, new int[] { 5, 6 });
		graph.depthFirstTravel();
	}
}

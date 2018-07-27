package com.litl.www.algorithm.ch06;

public class MatrixGraphTest {
	public static void main(String[] args) {
		// int[] vertexes = { 0, 1, 2, 3 };
		// MatrixGraph graph = new MatrixGraph(vertexes);
		// graph.addEdge(0, 1);
		// graph.addEdge(0, 2);
		// graph.addEdge(0, 3);
		// graph.addEdge(1, 2);
		// graph.addEdge(3, 2);
		// graph.printMatrix();

		int[] vertexes = { 0, 1, 2, 3, 4, 5, 6 };
		MatrixGraph graph = new MatrixGraph(vertexes);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.printMatrix();
		graph.depthFirstTravel();
	}
}

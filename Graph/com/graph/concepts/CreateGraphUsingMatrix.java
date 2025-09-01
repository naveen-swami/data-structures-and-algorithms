package com.graph.concepts;

public class CreateGraphUsingMatrix {

	public static void main(String[] arg) {
		
		int vertex = 4;
		int[][] graph = new int[vertex][vertex];
		createGraph(graph);
		
		// print all neighbour of 1;
		int curr = 1;
		for(int i = 0; i < vertex; i++) {
			if(graph[curr][i] != 0) {
				System.out.println("vertex "+ i);
			}
		}
		
		
	}
	
	public static void createGraph(int[][] graph) {
		
		graph[0] = new int[] { 0, 1, 0, 0};
		graph[1] = new int[] { 1, 0, 1, 1};
		graph[2] = new int[] { 0, 1, 0, 1};
		graph[3] = new int[] { 0, 1, 1, 0};
		
	}
}

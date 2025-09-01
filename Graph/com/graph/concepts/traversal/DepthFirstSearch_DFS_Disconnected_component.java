package com.graph.concepts.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.graph.concepts.Edge;

public class DepthFirstSearch_DFS_Disconnected_component {
	public static void main(String[] args) {
		int vertex = 8;
		List<Edge> graph[] = new ArrayList[vertex];
		createGraph(graph);

		boolean[] visitedGraph = new boolean[graph.length];

		for (int i = 0; i < vertex; i++) {
			if (!visitedGraph[i]) {
				printGraphUsingDFS(graph, i, visitedGraph);
			}
		}

	}

	public static void createGraph(List<Edge> graph[]) {

//	     1       3 --- 7
//	    /        | \
//	   0         |  5 ---- 6
//	    \        |  /
//	     2       4

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
//		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
//		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		graph[3].add(new Edge(3, 7));

		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 5));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));

		graph[7].add(new Edge(7, 3));

	}

	public static void printGraphUsingDFS(List<Edge> graph[], int graphComponent, boolean visitedGraph[]) {

		if (graph.length == 0) {
			return;
		}

		Stack<Integer> stack = new Stack<>();

		stack.add(graphComponent);

		while (!stack.isEmpty()) {
			// first remove from stack
			// curr = queue.remove();
			// if visitedGraph[curr] == T then continue
			// print(curr node)
			// visistedGraph[curr] = T
			// add all neighbhour into stack;

			int curr = stack.pop();

			if (visitedGraph[curr]) {
				continue;
			}

			System.out.print(curr + " ");

			visitedGraph[curr] = true;

			for (int i = 0; i < graph[curr].size(); i++) {
				Edge edge = graph[curr].get(i);
				stack.add(edge.des);
			}

		}

	}

}

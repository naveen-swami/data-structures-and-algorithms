package com.graph.concepts.traversal;

import java.util.*;
import com.graph.concepts.*;

public class BreathFirstSearch_BFS_disconnected_components {

	public static void main(String[] args) {
		int vertex = 8;
		List<Edge> graph[] = new ArrayList[vertex];
		createGraph(graph);
		boolean[] visitedGraph = new boolean[graph.length];

		for (int i = 0; i < vertex; i++) {
			if (!visitedGraph[i]) {
				printGraphUsingBFS(graph, visitedGraph, i);
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

	public static void printGraphUsingBFS(List<Edge> graph[], boolean[] visitedGraph, int startingNode) {

		if (graph.length == 0) {
			return;
		}

		Queue<Integer> queue = new LinkedList<>();

		queue.add(startingNode);

		while (!queue.isEmpty()) {
			// first remove from queue
			// curr = edgeQueue.remove();
			// if visitedGraph[curr] == T then continue
			// print(curr node)
			// visistedGraph[curr] = T
			// add all neighbhour into queue;

			int curr = queue.remove();

			if (visitedGraph[curr] == true) {
				continue;
			}
			visitedGraph[curr] = true;

			System.out.print(curr + " ");

			// Add all neighbour of curr Node
			for (int i = 0; i < graph[curr].size(); i++) {
				Edge edge = graph[curr].get(i);
				queue.add(edge.des);
			}
		}

	}

}

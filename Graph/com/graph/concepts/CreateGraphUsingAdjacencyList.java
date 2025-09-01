package com.graph.concepts;

import java.util.*;

// graph notes
// https://drive.google.com/drive/folders/169zB73A1EoRte277VaJbw8HV_kskUHFR
public class CreateGraphUsingAdjacencyList {

	public static void main(String[] args) {
		
		// create graph using Adjacency list ( list of list )
		
		int vertex = 4;
		
		List<Edge> graph[] = new ArrayList[vertex];
//		createNewGraph(graph);
		createWeightedNewGraph(graph);
		
		// print neighbors of 2
		
//		for(int i = 0; i < graph[2].size(); i++) {
//			Edge edge = graph[2].get(i);
//			System.out.print(edge.des +  " ");
//		}
		
		// print neighbour of 2 with weight
		for(int i = 0; i < graph[2].size(); i++) {
			Edge edge = graph[2].get(i);
			System.out.println("des: " + edge.des +  " weight: " + edge.weight);
		}

	}
	
	public static void createNewGraph(List<Edge> graph[]) {
		
		// at the begining graph's edge is null so we need to emtpy list
		
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(1, 2));
		graph[0].add(new Edge(1, 3));
		graph[0].add(new Edge(1, 4));
		
		graph[1].add(new Edge(2, 1));
		graph[1].add(new Edge(2, 3));
		
		graph[2].add(new Edge(3,1));
		graph[2].add(new Edge(3, 2));
		graph[2].add(new Edge(3, 4));
		
		graph[3].add(new Edge(4, 1));
		graph[3].add(new Edge(4, 2));

	}
	
	public static void createWeightedNewGraph(List<Edge> graph[]) {
		
		// at the begining graph's edge is null so we need to emtpy list
		
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(1, 2, 4));
		graph[0].add(new Edge(1, 3, 5));
		graph[0].add(new Edge(1, 4, 3));
		
		graph[1].add(new Edge(2, 1, 4));
		graph[1].add(new Edge(2, 3, 9));
		
		graph[2].add(new Edge(3,1, 9));
		graph[2].add(new Edge(3, 2, 1));
		graph[2].add(new Edge(3, 4, 10));
		
		graph[3].add(new Edge(4, 1, 12));
		graph[3].add(new Edge(4, 2, 34));

	}

}

package com.graph.concepts;

import java.util.*;

/**
 * <h1>Graph Notes</h1>
 *
 * <p>Documentation Link: <a href="https://drive.google.com/drive/folders/169zB73A1EoRte277VaJbw8HV_kskUHFR">Graphs - Google Drive</a></p>
 *
 * <p>There are four ways to print or store graph information:</p>
 * <ol>
 *   <li>
 *     <b>AdjacencyList:</b> List of lists
 *     <ul>
 *       <li>In this method, we store information in the form of a list of arrays. Here, the array size is equal to vertices and the list size depends on the edges of the vertex.</li>
 *       <li>At each vertex, we store information about edges: {@link Edge} <code>{ source, destination, weight }</code>.</li>
 *       <li>We store only required information, No extra space uses</li>
 *       <li>That's why in most of the graph problems we use this method</li>
 *       <li><b>Size:</b> array: <b>O(V)</b> list: <b>O(x)</b>, here x is depending on size of edges</li>
 *     </ul>
 *   </li>
 *   <li>
 *       <b>Edges List:</b> List of Edges
 *       <ul>
 *           <li>Store information in form of list of edges.</li>
 *           <Li><code>[{src, desc, weight},{src, desc, weight},{src, desc, weight}]</code></Li>
 *           <li>Easily sort graph in this form, because here store all information at one place only </li>
 *           <li>This method used into sorting graph problems.</li>
 *           <li>Uses into <b>Minimal Spanning Tree (MST)</b></li>
 *           <li><b>Size:</b> equal to edges of graph <b>O(E)</b></li>
 *       </ul>
 *   </li>
 *   <li>
 *       <b>AdjacencyMatrix:</b> V x V
 *       <ul>
 *           <li>Store information in form of matrix</li>
 *           <li>In matrix, we store <code>graph[0] = new int[] { 0, 1, 0, 0};</code> </li>
 *           <li>if i,j connected then put 1, else 0</li>
 *           <li>Store no required information also, like we they are not connected then also we store information</li>
 *           <li>Uses extra space to store graph information</li>
 *           <li><b>Size:</b> O(VxV)</li>
 *       </ul>
 *   </li>
 *   <li>
 *       <b>Implicit Graph:</b> VxV
 *       <ul>
 *           <li>In graph problems we given graph information into matrix form, so we uses that matrix uses to solve that problem</li>
 *           <li>So in these type problem we don't need to do more to store graph information because required information already provided into form of matrix</li>
 *           <li>Uses into <b>Flood fill algo</b></li>
 *       </ul>
 *   </li>
 * </ol>
 */

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
		
		// at the begining graph's edge is null so we need to set emtpy list
		
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

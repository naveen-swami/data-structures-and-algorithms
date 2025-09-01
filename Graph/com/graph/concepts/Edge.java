package com.graph.concepts;

public class Edge {
	public int src;
	public int des;
	public int weight;
	
	public Edge(int src, int des){
		this.src = src;
		this.des = des;
	}
	
	public Edge(int src, int des, int weight){
		this.src = src;
		this.des = des;
		this.weight = weight;
	}
}

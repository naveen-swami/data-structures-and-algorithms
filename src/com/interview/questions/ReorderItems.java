package com.interview.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node(int data, Node node) {
		this.data = data;
		this.next = node;
	}
}

public class ReorderItems {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		s.nextLine();
		String[] listStr = s.nextLine().split(" ");
		Map<Integer, Node> map = new HashMap<>();
		Node lastNode = null;
		Node start = null;
		for (int i = 0; i < listStr.length; i++) {
			int num = Integer.parseInt(listStr[i]);
			Node node = new Node(num, null);
			if (lastNode != null)
				lastNode.next = node;
			if (lastNode == null)
				start = node;
			lastNode = node;
			map.put(num, node);
		}
		int noOfOperations = Integer.parseInt(s.nextLine());
		for (int i = 0; i < noOfOperations; i++) {
			String[] operations = s.nextLine().split(" ");
			Node nodeOne = map.get(Integer.parseInt(operations[0]));
			Node nodeTwo = map.get(Integer.parseInt(operations[1]));
			Node nodeTwoNext = nodeTwo.next;
//			System.out.println(nodeTwoNext);
			nodeTwo.next = nodeOne.next;
			nodeOne.next = nodeOne.next.next;
			nodeTwo.next.next = nodeTwoNext;
		}
		StringBuilder sb = new StringBuilder();
		while (start != null) {
			sb.append(start.data + " ");
			start = start.next;
		}
		System.out.println(sb.toString());
	}
}

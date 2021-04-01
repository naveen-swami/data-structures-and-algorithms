package com.doubly.linked.list.service;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedListInsertionService {

	int size = 0;

	public Node insertAtStarting(Node head, int val) {
		// List<Integer> test = new LinkedList<Integer>();

		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return head;
	}

	public Node insetAtEnd(Node head, int val) {
		Node newNode = new Node(val);

		size++;
		if (head == null) {
			return newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
		return head;
	}

	public Node insetAtPostion1(Node head, int val, int p) {

		Node newNode = new Node(val);
		if (p == 1) {
			if (head != null) {
				newNode.next = head;
			}
			head = newNode;
			return head;
		}
		Node temp = head;
		while (p > 2 && temp.next != null) {
			temp = temp.next;
			p--;
		}
		Node temp1 = temp.next;
		temp.next = newNode;
		newNode.next = temp1;
		temp1.prev = newNode;
		newNode.prev = temp;

		return head;
	}

	public Node insetAtPostion(Node head, int val, int k) {

		if (k > size + 1 || k < 0) {
			throw new NumberFormatException(
					"k is out of bound size. Please choose k between " + 1 + " and " + size + 1);
		} else {
			if (k == 1) {
				return insertAtStarting(head, val);
			} else if (k == size + 1) {
				return insetAtEnd(head, val);
			} else {
				Node temp = head;
				while (k > 2) {
					temp = temp.next;
					k--;
				}
				Node newNode = new Node(val);
				Node temp1 = temp.next;
				temp.next = newNode;
				newNode.next = temp1;
				temp1.prev = newNode;
				newNode.prev = temp;
				size++;
			}
		}

		return head;
	}

	public void display(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

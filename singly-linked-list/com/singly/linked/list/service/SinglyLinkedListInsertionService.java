package com.singly.linked.list.service;

public class SinglyLinkedListInsertionService {

	// Insert node at the starting
	public Node inserNodeAtStarting(Node head, int val) {

		Node newNode = new Node(val);
		// when head is empty
		if (head == null) {
			return newNode;
		}
		// when head is not empty
		newNode.next = head;
		return newNode;
	}

	public Node insertNodeAtEnd(Node head, int val) {
		Node newNode = new Node(val);
		// if head is empty
		if (head == null) {
			return newNode;
		}

		// when head is node empty
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;

		return head;
	}

	/**
	 * 
	 * Starting position from 1.
	 * 
	 * @param head
	 * @param val
	 * @param postion
	 * @return LinkedList
	 */
	public Node insertNodeAtPostion(Node head, int val, int position) {

		if (position < 1) {
			throw new NumberFormatException("Invalid position. Position should be natural number i.e 1, 2, 3 ... N");
		}

		if (position == 1) {
			return this.inserNodeAtStarting(head, val);
		}

		Node temp = head;
		int size = 1;
		while (temp.next != null) {
			if (size == position - 1) { // check we need to insert here!!!
				break;
			}
			size++;
			temp = temp.next;
		}

		if (position > size + 1) {
			throw new NumberFormatException(
					"Invalid position. Position should not be greater than " + (size + 1) + " .");
		}

		Node newNode = new Node(val);
		// at the the position
		newNode.next = temp.next;
		temp.next = newNode;

		return head;
	}

	public void displaySinglyLinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}

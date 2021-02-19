package com.singly.linked.list.service;

public class SinglyLinkedListInsertionService {

	protected int sizeOfList = 0;

	// Insert node at the starting
	public Node inserNodeAtStarting(Node head, int val) {

		sizeOfList++;
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
		sizeOfList++;
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
		this.sizeOfList++;
		Node newNode = new Node(val);
		// at the the position
		newNode.next = temp.next;
		temp.next = newNode;

		return head;
	}

	public Node AddOneToLinkedList(Node head) {

		int carry = 1;
		Node temp = head;
		Node prev = head;
		while (temp != null) {
			int newData =  temp.val + carry;
			temp.val = newData % 10;
			carry = newData / 10;
			prev = temp;
			temp = temp.next;
		}

		if (carry > 0) {
			prev.next = new Node(carry);
		}

		return head;
	}

	public int nThNodeFromEndOfLinkedList(Node head, int nThNode) {
		// list: 4 5 6 7 and k = 2
		Node anjana = head;
		Node naveen = head;
		int size = 1;
		while (anjana.next != null) {
			if (size >= nThNode) {
				naveen = naveen.next;
			}
			anjana = anjana.next;
			size++;
		}
		// if nThNode greater then list size
		if (size < nThNode) {
			return -1;
		}

		return naveen.val;
	}

	public int size() {
		return this.sizeOfList;
	}

	public void displaySinglyLinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

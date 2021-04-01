package com.singly.linked.list.service;

public class SinglyLinkedListDeletionService extends SinglyLinkedListInsertionService {

	public Node deletionAtStartOfLinkedList(Node head) throws Exception {
		if (head == null) {
			throw new Exception("Linked list is empty. No node to delete.");
		}
		super.sizeOfList--;
		return head.next;
	}

	public Node deletionAtEnd(Node head) throws Exception {
		if (head == null) {
			throw new Exception("Linked list is empty. No node to delete.");
		}
		super.sizeOfList--;
		if (head.next == null) {
			return null;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}

	public Node deletionAtPosition(Node head, int position) throws Exception {
		if (position == 1) {
			return deletionAtStartOfLinkedList(head);
		} else if (super.size() < position) {
			throw new Exception("Position should not be greater then " + super.size());
		} else if (super.size() == position) {
			return deletionAtEnd(head);
		}

		super.sizeOfList--;
		Node temp = head;
		int size = 1;
		while (temp.next != null && size + 1 < position) {
			temp = temp.next;
		}

		temp.next = temp.next.next;

		return head;
	}
	
	public Node reverseLinkedList1(Node head) {
		
		Node prev = null;
		Node current = head;
		Node next;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}

	public Node reversingTheLinkedList(Node head) {

		if (head.next == null) {
			return head;
		}
		Node prev = head;
		Node next = head.next;
		head = reversingTheLinkedList(next);
		next.next = prev;
		next.next.next = null;

		return head;
	}

	/** 
	 * 
	 * Solved using train
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node deleteKthElementFromEnd(Node head, int k) {

		Node anjana = head;
		Node naveen = head;
		int count = 1;
		while (anjana.next != null) {
			if (count >= k) {
				naveen = naveen.next;
			}
			anjana = anjana.next;
			count++;
		}
		naveen.next = naveen.next.next;

		return head;
	}

	// int size = 0;
	// public Node deleteMiddleElement(Node head) {
	// if(head.next)
	// Node prev = null;
	// Node current = head;
	// size++;
	// head = deleteMiddleElement(head);
	// return head;
	// }

	public Node deleteMiddleElement2ndWay(Node head) {
		if (head.next == null) {
			head.val = -1;
			return head;
		}
		Node temp = head;
		int size = 0;
		while (temp != null) {
			temp = temp.next;
			size++;
		}

		int middleNode = size / 2;
		temp = head;
		while (--middleNode > 0) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return head;
	}

	public Node deleteMiddleElement3rdWay(Node head) {
		if (head.next == null) {
			head.val = -1;
			return head;
		}

		Node slowPointer = head;
		Node fastPoiner = head;
		Node prev = head;
		while (fastPoiner != null && fastPoiner.next != null) {
			prev = slowPointer;
			slowPointer = slowPointer.next;
			fastPoiner = fastPoiner.next.next;
		}
		prev.next = slowPointer.next;

		return head;
	}

	public Node deleteMiddleElement4thWay(Node head) {
		if (head.next == null) {
			head.val = -1;
			return head;
		}

		Node prev = head;
		Node mid = head;
		int count = 1;
		Node temp = head;
		while (temp != null) {

			if (count % 2 == 0) {
				prev = mid;
				mid = mid.next;
			}
			count++;
			temp = temp.next;

		}
		prev.next = mid.next;

		return head;
	}
}

package com.doubly.linked.list.service;

public class DoublyLinkedListProblemsService extends DoublyLinkedListDeletionService {

	public Node reverseDoublyLinkedList(Node head) {

		while (head != null) {
			Node temp = head.prev;
			head.prev = head.next;
			head.next = temp;
			if(head.prev == null) {
				return head;
			}
			head = head.prev;
		}

		return head;
	}

	/**
	 * 
	 * @see <a href=
	 *      "https://www.geeksforgeeks.org/delete-every-kth-node-from-circular-linked-list/">
	 *      https://www.geeksforgeeks.org/delete-every-kth-node-from-circular-linked-list/
	 *      </a>
	 * 
	 * @param head
	 * @return
	 */
	public Node deleteEveryKthNodeFromCircularLinkedList(Node head, int k) {

		if (head == null) {
			return head;
		}

		Node temp = head;

		while (!temp.next.equals(head) || !temp.equals(head)) {
			// if (temp.next.equals(head) && temp.equals(head)) {
			// break;
			// }
			printLinkList(head);

			Node prev = null;
			for (int i = 0; i < k; i++) {
				prev = temp;
				temp = temp.next;
			}

			// if first node is k
			if (temp.equals(head)) {
				prev.next = temp.next;
				head = temp.next;
			} else if (temp.next.equals(head)) { // if last node is k
				prev.next = head;
			} else {
				prev.next = temp.next;
			}
		}

		return head;
	}

	/**
	 * print circular linked list
	 * 
	 * @param head
	 */
	public void printLinkList(Node head) {

		Node temp = head;
		do {
			System.out.print(temp.val + "->");
			temp = temp.next;
		} while (!temp.equals(head));
		System.out.println(head.val);
	}

	/**
	 * 
	 * Exchange first and last node of the cyclic linked list
	 * 
	 * @param head
	 * @return
	 */
	public Node exchangeNode(Node head) {
		Node temp = head;

		while (temp.next.next != null) { // second last node
			temp = temp.next;
		}

		temp.next.next = head.next; // 3 -> 2
		Node res = temp.next;
		temp.next = head;

		return res;

		// return head;
	}
}

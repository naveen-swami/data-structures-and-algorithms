package com.singly.linked.list.service;

import java.util.Stack;

public class SinglyLinkedListProblemService extends SinglyLinkedListDeletionService {
	
	/**
	 * 
	 * it will reverse every kth elements from linkedList
	 * ex:  1 2 3 4 5 6 7 8 9
	 * ans: 3 2 1 4 5 6 9 8 7
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node ReverseAlternateKElemetns(Node head, int k) {
		return head;
	}

	public Node swapKthNodeFromEndAndFront(Node head, int size, int k) {

		if (k == size - k + 1) {
			return head;
		}
		Node temp = head;
		Node firstNode = null;
		Node secondNode = null;
		int length = 1;
		if (k == 1 || k == size) {
			firstNode = head;
			k = 1;
		}
		while (firstNode == null || secondNode == null) {
			if (length == k - 1) {
				firstNode = temp;
			} else if (length == size - k) {
				secondNode = temp;
			}
			temp = temp.next;
			length++;
		}

		Node temp1 = firstNode.next;
		Node temp2 = secondNode.next;
		Node temp3 = secondNode.next.next;

		if (k == 1) {
			secondNode.next = firstNode;
			temp2.next = firstNode.next;
			firstNode.next = temp3;
			return temp2;
		}
		firstNode.next = secondNode.next;
		secondNode.next = temp1;
		temp2.next = temp1.next;
		temp1.next = temp3;
		return head;
	}

	public boolean isPalindrome1(Node head) {

		Stack<Integer> valueStack = new Stack<>();
		Node copy = head;
		while (copy != null) {
			valueStack.push(copy.val);
			copy = copy.next;
		}

		while (head != null) {
			if (head.val != valueStack.pop()) {
				return false;
			}
			head = head.next;
		}

		return true;
	}

	// 5
	// 1 12 221 21 1
	// it will not work when digit is more then two
	public boolean isPalindrome(Node head) {

		StringBuilder str = new StringBuilder();

		while (head != null) {
			str.append(head.val);
			head = head.next;
		}
		String str1 = str.toString();
		return str1.equals(str.reverse().toString());
		// for(int i = 0; i < str.length()/2; i++) {
		// if(str.charAt(i) != str.charAt(str.length()-i -1)) {
		// return false;
		// }
		// }
		//
		// return true;
	}
}

package com.singly.linked.list.service;

import java.util.Stack;

public class SinglyLinkedListProblemService extends SinglyLinkedListDeletionService {

	/**
	 * 
	 * it will reverse every kth elements from linkedList if n = 9 and k = 3 then
	 * exa: 1 2 3 4 5 6 7 8 9 <br>
	 * ans: 3 2 1 4 5 6 9 8 7 <br>
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reverseAlternateKthElemetns(Node head, int k) {

		if (head == null) {
			return head;
		}

		Node prev = null;
		Node curr = head;
		Node next;

		int count = 0;

		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		head.next = curr;
		Node last = prev;
		while (curr != null && count > 0) {
			last = curr;
			curr = curr.next;
			count--;
		}

		while (last.next != null && curr == null) {
			last = last.next;
		}

		last.next = reverseAlternateKthElemetns(curr, k);

		return prev;
	}

	public Node reverseAlternateKthElemetns1(Node head, int k) {
		if (head == null) {
			return head;
		}

		Node prev = null;
		Node curr = head;
		Node next;

		int count = 0;

		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		head.next = curr;
		while (curr != null && count - 1 > 0) {
			curr = curr.next;
			count--;
		}
		if (curr != null) {
			curr.next = reverseAlternateKthElemetns(curr.next, k);
		}

		return prev;
	}

	/**
	 * 
	 * example: size = 7 and k = 2 <br>
	 * que : 1 2 3 4 5 6 7 <br>
	 * ans : 2 1 4 3 6 5 7
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node reversekthNodes(Node head, int k) {

		if (head == null) {
			return head;
		}

		Node prev = null;
		Node currNode = head;
		Node next;
		int count = 0;

		while (currNode != null && count < k) {
			next = currNode.next;
			currNode.next = prev;
			prev = currNode;
			currNode = next;
			count++;
		}
		head.next = reversekthNodes(currNode, k);

		return prev;
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

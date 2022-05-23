package com.singly.linked.list.service;

import java.util.Stack;

public class SinglyLinkedListProblemService extends SinglyLinkedListDeletionService {

//	find element and remove it
//	 1 ->  5 -> 6 -> 0 -> -5 -> 10

	public Node removeElement(Node head, int x) {

		if (head.val == x) {
			return head.next;
		}

		Node temp = head;
		Node prev = null;

		while (temp != null && temp.val != x) {
			prev = temp;
			temp = temp.next;
		}

		// no element found
		if (temp == null) {
			return head;
		}

		prev.next = temp.next;

		return head;
	}

// 1 -> -2 -> -3 -> 4 -> -5 
//op -5 -4 -3 1 4
	public static Node sortedLinkedListByAcutalValue(Node head) {

		Node temp = head;
		Node prev = null;

		while (temp != null) {

			Node curr = temp;
			temp = temp.next;
			if (curr.val < 0) {
				curr.next = head;
				head = curr;
			} else {
				if (prev != null) {
					prev.next = curr;
				}
				prev = curr;
				prev.next = null;
			}
		}

		return head;

	}

	/**
	 * we have to remove element whose sum is equal to sum Example: list: 1 5 3 1 4
	 * 2 and sum = 5
	 * 
	 * so pair: (1, 4), (2, 3)
	 * 
	 * remaining list: 5, 1
	 * 
	 * return this list
	 * 
	 * WAP to delete the pair of elements in an linked list whose sum is equal to
	 * the number given and return the remaining list. Values can be repeated and
	 * the list is unsorted. e.g. list = 1,2,3,4,5,6 Sum = 5 </br>
	 * 1 + 4 = 5 2 + 3 = 5 </br>
	 * Remove (1,4) & (2,3) </br>
	 * Return 5, 6
	 * 
	 * @param head
	 * @param sum
	 * @return
	 */
	public Node removeSumEqualElement(Node head, int sum) {

		return head;
	}

	public Node mergeSortImpl(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node mid = findMid(head);
		Node secondHalf = mid.next;
		mid.next = null;
		Node first = mergeSortImpl(head);
		Node second = mergeSortImpl(secondHalf);
		Node compleList = mergeTwoSortedLinkedList(first, second);

		return compleList;
	}

	private Node findMid(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public Node mergeTwoSortedLinkedList(Node head1, Node head2) {
		Node dummyNode = new Node(-1);
		Node temp = dummyNode;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}

		temp.next = head1 != null ? head1 : head2;
		return dummyNode.next;
	}

	public Node mergeSortImpl(Node head, Node tail) {

		if (head == tail) {
			if (head != null) {
				return new Node(head.val);
			}
			return head;
		}

		Node mid = findMid1(head, tail);

		Node first = mergeSortImpl(head, mid);
		Node second = mergeSortImpl(mid.next, tail);
		Node compleList = mergeTwoSortedLinkedList(first, second);

		return compleList;
	}

	private Node findMid1(Node head, Node tail) {

		Node slow = head;
		Node fast = head;

		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

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
	
	public Node reverseLinkedList(Node rootNode) {
        if(rootNode == null) {
            return null;
        }
        if(rootNode.next == null ) {
        	return rootNode;
        }
        
        Node nextNode = rootNode.next;
        
        Node returnNode = reverseLinkedList(nextNode);
        
        rootNode.next = null;
        
        nextNode.next = rootNode;
        return returnNode;
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

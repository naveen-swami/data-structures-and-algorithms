package com.testing;

public class LinkedListTest {
	public static void main(System[] str) {
		Solution sol = new Solution();
	}
	

}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode returnNode = reverseLinkedList(l1);
		displayLinkedList(returnNode);
		return null;
	}

	void displayLinkedList(ListNode root) {
		ListNode temp = root;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	// 1 -> 2 -> 3 -> 4 -> 5 -> Null
	ListNode reverseLinkedList(ListNode rootNode) {
        if(rootNode == null) {
            return null;
        }
        if(rootNode.next == null ) {
        	return rootNode;
        }
        
        ListNode nextNode = rootNode.next;
        
        ListNode returnNode = reverseLinkedList(rootNode);
        
        rootNode.next = null;
        
        nextNode.next = rootNode;
        return returnNode;
    }
}

package com.doubly.linked.list.web;

import java.util.Scanner;

import com.doubly.linked.list.service.DoublyLinkedListProblemsService;
import com.doubly.linked.list.service.Node;

public class DoublyLinkedListController {
	static Scanner scanner = new Scanner(System.in);
	static DoublyLinkedListProblemsService doublyLinkedListService = new DoublyLinkedListProblemsService();
	static Node head = null;

	public static void main(String[] args) throws Exception {
		head = insertAtEndOfList();
		head = doublyLinkedListService.insetAtPostion(head, 10, 2);
		doublyLinkedListService.display(head);

	}

	static Node insertAtEndOfList() {
		int sizeOfList = scanner.nextInt();
		while (sizeOfList-- > 0) {
			int val = scanner.nextInt();
			head = doublyLinkedListService.insetAtEnd(head, val);
		}
		return head;
	}
}

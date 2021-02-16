package com.singly.linked.list.web;

import java.util.Scanner;

import com.singly.linked.list.service.Node;
import com.singly.linked.list.service.SinglyLinkedListInsertionService;

public class SinglyLinkedListController {
	static Scanner scanner = new Scanner(System.in);
	static SinglyLinkedListInsertionService singlyLinkedListService = new SinglyLinkedListInsertionService();
	static Node head = null;

	public static void main(String[] args) {
		insertAtEndOfList();
		//askByUser();
		singlyLinkedListService.displaySinglyLinkedList(head);
		System.out.println(singlyLinkedListService.nThNodeFromEndOfLinkedList(head, 2));
	}

	static Node insertAtEndOfList() {
		int sizeOfList = scanner.nextInt();
		while (sizeOfList-- > 0) {
			int val = scanner.nextInt();
			head = singlyLinkedListService.insertNodeAtEnd(head, val);
		}
		return head;
	}

	static Node askByUser() {
		System.out.println("How many node you want to insert: ");
		int sizeOfList = scanner.nextInt();
		int noOfNode = 0;
		while (noOfNode != sizeOfList) {
			System.out.println("Please enter " + ++noOfNode + "st data: ");
			int val = scanner.nextInt();
			System.out.println("where you insert it choose options: ");
			System.out.println("Insert at begging. Press 1");
			System.out.println("Insert at end, Press 2");
			System.out.println("Insert at position, Press 3");
			int posstion = scanner.nextInt();
			switch (posstion) {
			case 1:
				head = singlyLinkedListService.inserNodeAtStarting(head, val);
				break;
			case 2:
				head = singlyLinkedListService.insertNodeAtEnd(head, val);
				break;
			case 3:
				System.out.println("Please enter position: ");
				int location = scanner.nextInt();
				try {
					head = singlyLinkedListService.insertNodeAtPostion(head, val, location);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			default:
				break;
			}
		}
		return head;
	}
}

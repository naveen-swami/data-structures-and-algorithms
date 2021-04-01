package com.singly.linked.list.web;

import java.util.Scanner;

import com.singly.linked.list.service.Node;
import com.singly.linked.list.service.SinglyLinkedListDeletionService;
import com.singly.linked.list.service.SinglyLinkedListProblemService;

public class SinglyLinkedListController {
	static Scanner scanner = new Scanner(System.in);
	static SinglyLinkedListProblemService singlyLinkedListService = new SinglyLinkedListProblemService();
	static Node head = null;

	public static void main(String[] args) throws Exception {
		insertAtEndOfList();
		head = singlyLinkedListService.reverseAlternateKthElemetns(head, 3);
//		head = singlyLinkedListService.reversekthNodes(head, 2);
//		head = singlyLinkedListService.swapKthNodeFromEndAndFront(head, 4, 2);
	    singlyLinkedListService.displaySinglyLinkedList(head);
		
//		head = singlyLinkedListService.reverseLinkedList1(head);
//		System.out.println(singlyLinkedListService.isPalindrome(head));
//		head = singlyLinkedListService.reversingTheLinkedList(head);
		//head = singlyLinkedListService.deleteMiddleElement4thWay(head);
//		head = singlyLinkedListService.AddOneToLinkedList(head);
//		head = singlyLinkedListService.deleteKthElementFromEnd(head, 3);
//		singlyLinkedListService.displaySinglyLinkedList(head);
		// askByUser();
		// operations();

	}

	static Node insertAtEndOfList() {
		int sizeOfList = scanner.nextInt();
		while (sizeOfList-- > 0) {
			int val = scanner.nextInt();
			head = singlyLinkedListService.insertNodeAtEnd(head, val);
		}
		return head;
	}

	static Node askByUserToInsertion() {
		System.out.println("How many node you want to insert: ");
		int sizeOfList = scanner.nextInt();
		int noOfNode = 0;
		while (noOfNode != sizeOfList) {
			System.out.println("Please enter " + ++noOfNode + " data: ");
			int val = scanner.nextInt();
			System.out.println("where you insert it choose options: ");
			System.out.println("Insert at begging. Press 1");
			System.out.println("Insert at end, Press 2");
			System.out.println("Insert at position, Press 3");
			int position = scanner.nextInt();
			switch (position) {
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

	static void operations() throws Exception {
		boolean doYouWantToContiueIt = true;
		do {
			System.out.println("Please choose your option: ");
			System.out.println(" Insertion !!, Press 1 ");
			System.out.println(" Deletion !!, Press 2");
			System.out.println("Display list, Press 3 ");
			System.out.println("Size of List, Press 4");
			int operation = scanner.nextInt();
			switch (operation) {
			case 1:
				askByUserToInsertion();
				break;

			case 2:
				askByUserToDeletion();
				break;
			case 3:
				singlyLinkedListService.displaySinglyLinkedList(head);
				break;
			case 4:
				System.out.println(singlyLinkedListService.size());
				break;
			default:
				break;
			}
			System.out.println(" Do you want to continue, Press 'y' for YES else press any button ");
			doYouWantToContiueIt = scanner.next().equals("y");
		} while (doYouWantToContiueIt);
	}

	private static void askByUserToDeletion() throws Exception {
		System.out.println("where you delete it choose options: ");
		System.out.println("at begging. Press 1");
		System.out.println("end, Press 2");
		System.out.println("position, Press 3");
		int position = scanner.nextInt();
		switch (position) {
		case 1:
			head = singlyLinkedListService.deletionAtStartOfLinkedList(head);
			break;
		case 2:
			head = singlyLinkedListService.deletionAtEnd(head);
			break;
		case 3:
			System.out.println("Please enter position: ");
			int location = scanner.nextInt();

			head = singlyLinkedListService.deletionAtPosition(head, location);
			break;

		default:
			break;
		}

	}
}

package com.binary.search.web;

import java.util.Scanner;

import com.binary.search.service.BinarySearchService;

public class BinarySearchController {
	static Scanner takeInput = new Scanner(System.in);

	public static void main(String[] args) {
		// int size = takeInput.nextInt();
		// int k = takeInput.nextInt();
		// int arr[] = new int[size];
		// for (int i = 0; i < size; i++) {
		// arr[i] = takeInput.nextInt();
		// }
		// System.out.println(BinarySearchService.getKthSum(arr, size, k));
		// takeInput.close();

		getInputWithTestCase();
	}

	private static void getInputWithTestCase() {
		int testCase = takeInput.nextInt();
		while (testCase-- > 0) {
			int size = takeInput.nextInt();
			// int k = takeInput.nextInt();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = takeInput.nextInt();
			}
			System.out.println(BinarySearchService.minimumElementInSortedAndRotaedArray(arr, size));
		}
	}
}

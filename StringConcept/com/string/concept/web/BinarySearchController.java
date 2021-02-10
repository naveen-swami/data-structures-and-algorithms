package com.string.concept.web;

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
		BinarySearchService binarySearchService = new BinarySearchService();
		int row = takeInput.nextInt();
		int col = takeInput.nextInt();
		int testCase = takeInput.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = takeInput.nextInt();
			}
		}
		while (testCase-- > 0) {
			int findNumber = takeInput.nextInt();
			System.out.println(binarySearchService.checkIfNumberHaveIn2DMatrix(arr, row, col, findNumber) ? "Yes" : "No");
		}
	}
}

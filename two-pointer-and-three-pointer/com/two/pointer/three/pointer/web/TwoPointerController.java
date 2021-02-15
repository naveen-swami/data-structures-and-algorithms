package com.two.pointer.three.pointer.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import com.two.pointer.and.three.pointer.service.TwoPointerService;

public class TwoPointerController {
	static Scanner takeInput = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// int size = takeInput.nextInt();
		// int k = takeInput.nextInt();
		// int arr[] = new int[size];
		// for (int i = 0; i < size; i++) {
		// arr[i] = takeInput.nextInt();
		// }
		// System.out.println(BinarySearchService.getKthSum(arr, size, k));
		// takeInput.close();

		getInputWithTestCase1();
	}

	// private static void getInputWithTestCase() throws IOException {
	// TwoPointerService twoPointerService = new TwoPointerService();
	// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	// String[] readLine = reader.readLine().split(" ");
	// int row = Integer.parseInt(readLine[0]);
	// int col = Integer.parseInt(readLine[1]);
	// int testCase = Integer.parseInt(readLine[2]);
	// long[][] arr = new long[row][col];
	// for (int i = 0; i < row; i++) {
	// readLine = reader.readLine().split(" ");
	// for (int j = 0; j < col; j++) {
	// arr[i][j] = Long.parseLong(readLine[j]);
	// }
	// Arrays.sort(arr[i]);
	// }
	//
	// while (testCase-- > 0) {
	// int findNumber = Integer.parseInt(reader.readLine());
	// System.out
	// .println(twoPointerService.printSquiredInSortedArray(arr, row, col,
	// findNumber) ? "Yes" : "No");
	// }
	// }

	private static void getInputWithTestCase1() {
		Scanner scan = new Scanner(System.in);
		TwoPointerService twoPointerService = new TwoPointerService();
		int testCase = scan.nextInt();
		while (testCase-- > 0) {
			int size = scan.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = scan.nextInt();
			}
			
			int[] squaredArray = twoPointerService.getSquaredSortedArray(arr);
			twoPointerService.displayArray(squaredArray);
		}
	}
}

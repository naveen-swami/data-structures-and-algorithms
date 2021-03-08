package com.two.pointer.three.pointer.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import com.two.pointer.and.three.pointer.service.TwoPointerService;

public class TwoPointerController {
	static Scanner scanner = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static TwoPointerService twoPointerService = new TwoPointerService();

	public static void main(String[] args) throws IOException {
		inputWithOutTestCaseWithBufferReader1DArrays();
		// getInputWithTestCase1();
		// getInputWithBufferReader1DArrays();
	}

	static int[] getOneDArrayUsingBufferedReader(int size) throws IOException {
		int[] arr = new int[size];
		String[] readLine = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(readLine[i]);
		}
		return arr;
	}

	static void inputWithOutTestCaseWithBufferReader1DArrays() throws IOException {
		String[] readLineStr = reader.readLine().split(" ");
		int size = Integer.parseInt(readLineStr[0]);
		int k = Integer.parseInt(readLineStr[1]);
		int[] arr = getOneDArrayUsingBufferedReader(size);
		System.out.println(twoPointerService.minCutTree(arr, size, k));

		// int[] arr2 = getOneDArrayUsingBufferedReader(size);
		// int k = Integer.parseInt(reader.readLine());
		//
		// twoPointerService.sortedBinaryArray(arr, size);
		// twoPointerService.displayArray(arr);
		// System.out.println(twoPointerService.tripletWithSum2ndWay(arr, size, k));
		// System.out.println(twoPointerService.closestToX(arr1, arr2, size, x));
		// System.out.println(twoPointerService.countTriplets2ndWay(arr, size, k));
	}

	static void getInputWithBufferReader1DArrays() throws IOException {
		int testCase = Integer.parseInt(reader.readLine());
		while (testCase-- > 0) {
			String[] readLine = reader.readLine().split(" ");
			int size = Integer.parseInt(readLine[0]);
			int k = Integer.parseInt(readLine[1]);
			readLine = reader.readLine().split(" ");
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(readLine[i]);
			}

			// int[] squaredArray = twoPointerService.getSquaredSortedArray(arr);
			// twoPointerService.displayArray(squaredArray);
			// System.out.println(twoPointerService.kthSmallestDifference2ndWay(arr, size,
			// k));
		}
	}

	private static void getInputWithTestCaseWithBufferedReader() throws IOException {
		String[] readLine = reader.readLine().split(" ");
		int row = Integer.parseInt(readLine[0]);
		int col = Integer.parseInt(readLine[1]);
		int testCase = Integer.parseInt(readLine[2]);
		long[][] arr = new long[row][col];
		for (int i = 0; i < row; i++) {
			readLine = reader.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				arr[i][j] = Long.parseLong(readLine[j]);
			}
			Arrays.sort(arr[i]);
		}

		while (testCase-- > 0) {
			int findNumber = Integer.parseInt(reader.readLine());
			// System.out.println(twoPointerService.printSquiredInSortedArray(arr, row, col,
			// findNumber) ? "Yes" : "No");
		}
	}

	private static void getInputWithTestCase1() {
		int testCase = scanner.nextInt();
		while (testCase-- > 0) {
			int size = scanner.nextInt();
			int k = scanner.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = scanner.nextInt();
			}

			// int[] squaredArray = twoPointerService.getSquaredSortedArray(arr);
			// twoPointerService.displayArray(squaredArray);
			System.out.println(twoPointerService.kthSmallestDifference2ndWay(arr, size, k));
		}
	}
}

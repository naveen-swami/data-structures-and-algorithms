package com.prefix.sum.and.kadane.algo.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.prefix.sum.and.kadane.algo.service.KadanesAlgoService;

public class KadanesAlgoController {

	static Scanner scanner = new Scanner(System.in);
	static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
	static KadanesAlgoService kadanesAlgoService = new KadanesAlgoService();

	public static void main(String[] args) throws IOException {

		// takeTestCase();
		// takeTestCaseWithBufferedReader();
		takeInput();

	}

	public static void takeInput() {
		int x = scanner.nextInt();
		int size = scanner.nextInt();
		int[][] arr = twoDArray(size, 3);
		System.out.println(kadanesAlgoService.maximumProfit(arr, x));
//		int arr[] = oneDArray(size);
//		int[] querys = oneDArray(querySize);
//		kadanesAlgoService.getAllToy(arr, querys);
		// System.out.println(kadanesAlgoService.equilibriumPointInUnsortedArray(arr));
	}

	public static int[][] twoDArray(int row, int col) {
		int[][] arr = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		return arr;
	}

	public static void takeTestCaseWithBufferedReader() throws IOException {
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			int size = Integer.parseInt(bReader.readLine());
			int[] arr = getArrayUsingBufferedReader(size);
			System.out.println(kadanesAlgoService.maxContiguousSum(arr));
		}
	}

	public static int[] getArrayUsingBufferedReader(int size) throws IOException {
		int[] arr = new int[size];
		String[] line = bReader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		return arr;
	}

	public static void takeTestCase() {
		int testCase = scanner.nextInt();
		while (testCase-- > 0) {

			int size = scanner.nextInt();
			int[] arr = oneDArray(size);
			kadanesAlgoService.pairProductOrExtractOrignal(arr, size);
			// System.out.println(kadanesAlgoService.maxContiguousSum(arr));
		}
	}

	public static int[] oneDArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}
		return arr;
	}

	public static void sumOfElementBetweenTwoNumber() {
		int size = scanner.nextInt();
		int querySize = scanner.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		int[][] queryArr = new int[querySize][2];

		for (int i = 0; i < querySize; i++) {
			queryArr[i][0] = scanner.nextInt();
			queryArr[i][1] = scanner.nextInt();
		}

		kadanesAlgoService.sumOfElementBeteenTwoNumber(arr, size, queryArr, querySize);
	}
}

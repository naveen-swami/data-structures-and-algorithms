package com.heap.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.heap.service.HeapService;

public class HeapController {

	static Scanner scan = new Scanner(System.in);
	static HeapService heapService = new HeapService();

	public static void main(String[] args) {
//		int sum = a*b;
//		 int num = scan.nextInt();
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
//		oneDArrayTest();
		multiTestCases();
		// twoDArrayTest();

//		List<Integer> list = null;
//		list.add(5);
//		System.out.println(list);
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		
//		heapService.getMedianOfArray(arr, size);
		heapService.minimumCostOfRopes(arr, size);

	}

	public static void twoDArrayTest() {
		int row = scan.nextInt();
		int[][] cordinates = new int[row][2];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 2; j++) {
				cordinates[i][j] = scan.nextInt();
			}
		}
	}

	public static void multiTestCases() {
		int testCase = scan.nextInt();
		while (testCase-- > 0) {
			int size = scan.nextInt();
			int k = scan.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = scan.nextInt();
			}
			heapService.kthLargestValueFromArray(arr, size, k);
//			heapService.maximumProductOfKIntegerArray(arr, size, k);
		}

	}

	public static void displayArr(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}

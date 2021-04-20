package com.hashing.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.hashing.service.HashingService;

public class HashingController {

	static Scanner scan = new Scanner(System.in);
	static HashingService hashingService = new HashingService();

	public static void main(String[] args) {
		// int num = scan.nextInt();
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
		oneDArrayTest();
		// oneDArrayTestWithTestCase();

		// List<Integer> list = null;
		// list.add(5);
		// System.out.println(list);
	}

	public static void oneDArrayTestWithTestCase() {
		int testCase = scan.nextInt();
		while (testCase-- > 0) {
			int size = scan.nextInt();
			int x = scan.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = scan.nextInt();
			}
			hashingService.isPairWithGivenSum(arr, x);
		}
		// hashingService.largestSubArrayWithZeroSum(size, arr);

	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		// int x = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		hashingService.maximumDistanceBetweenSameElement(arr, size);
		// hashingService.countSubArrayWithEqual1sAnd0s(size, arr);
		// hashingService.countPairWithGivenSum(arr, x);
		// hashingService.largestSubArrayWithZeroSum(size, arr);

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

}

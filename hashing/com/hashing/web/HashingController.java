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
//		System.out.println("hello....");
		// int num = scan.nextInt();
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
//		oneDArrayTest();
		synonymString();
//		anagramInupt();
		// oneDArrayTestWithTestCase();

		// List<Integer> list = null;
		// list.add(5);
		// System.out.println(list);
	}
	
	public static void synonymString() {
		int size = scan.nextInt();
		String[][] friendArr = new String[size][2];
		for(int i = 0; i < size; i++) {
		   friendArr[i][0] = scan.next();
		   friendArr[i][1] = scan.next();
//		   scan.next(); // due to space in scan.next()
		}
        String synonymFriend = scan.next();
//		hashingService.synonymStrings(friendArr, size, synonymFriend);
		hashingService.synonymStrings1(friendArr, size, synonymFriend);

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

	public static void anagramInupt() {
		int size = scan.nextInt();
		scan.nextLine();
		String[] strArr = scan.nextLine().split(" ");
		int querySize = scan.nextInt();
		String[] queryStrArr = new String[querySize];
		for (int i = 0; i < querySize; i++) {
			queryStrArr[i] = scan.next();
		}

		hashingService.arangeSimilarString(size, strArr, queryStrArr);
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int x = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		hashingService.countPairSumDivisibleByK(arr, x);
//		hashingService.countSubArrayWithGivenSum(arr, x);
//		hashingService.lengthOfLongestSubArray(arr, x);
//		hashingService.lenOfLongSubarr(arr, x);
//		hashingService.countDistinctElementOfSizeK(arr, x);
//		hashingService.maximumDistanceBetweenSameElement(arr, size);
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

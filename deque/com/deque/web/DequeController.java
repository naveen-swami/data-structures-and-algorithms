package com.deque.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.deque.service.DequeService;

public class DequeController {

	static Scanner scan = new Scanner(System.in);
	static DequeService dequeService = new DequeService();

	public static void main(String[] args) {
		// int num = scan.nextInt();
		// System.out.println(dequeService.addAlphabetStartAndEnd(num));
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
		oneDArrayTest();
		// twoDArrayTest();

		// List<Integer> list = null;
		// list.add(5);
		// System.out.println(list);
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		dequeService.maximumOfAllSubArray(arr, k);
		// System.out.println(dequeService.sumOfMinimumAndMaximumElementsOfSubarrays(arr,
		// k));
		// System.out.println(dequeService.minSubArrayProdcut(arr, k));
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

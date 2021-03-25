package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContest10Service;

public class DSAContest11Controller {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scan.nextInt();

		System.out.println(DSAContest10Service.convertToBase9(size));

		// scan.nextLine();
		// oneDArrayTest();
		// while (size-- > 0) {
		//
		// String str = scan.nextLine();
		// }
		// System.out.println(DSAContest9Service.countEvenPlaceVowel(str));

		// int num = scan.nextInt();
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
		// oneDArrayTest();
		// twoDArrayTest();
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(DSAContest10Service.isConsecutiveArray(arr) ? "Yes" : "No");
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

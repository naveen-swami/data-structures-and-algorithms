package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContest10Service;
import com.contest.service.DSAContest13Service;

public class DSAContest13Controller {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// int size = scan.nextInt();
		// Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();
		DSAContest13Service.gameTime(str);
		// DSAContest13Service.printCapitalLetter(str);

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
		DSAContest13Service.cakeXor(size, arr);
		// DSAContest13Service.pairSum(arr, size);
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

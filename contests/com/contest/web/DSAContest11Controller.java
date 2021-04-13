package com.contest.web;

import java.util.Arrays;
import java.util.Scanner;

import com.contest.service.DSAContest10Service;
import com.contest.service.DSAContest11Service;

public class DSAContest11Controller {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// final int max = 15;
		// Long max = (long) Math.pow(2, 10000);
		// long[] seq = new long(max);
		// System.out.printf("The first %d terms of the sequence are:\n", max);
		// for (int i = 1, n = 0; n < max; ++i) {
		// Long k = DSAContest11Service.count_divisors(i);
		// if (k <= max && seq[k - 1] == 0) {
		// seq[k - 1] = i;
		// n++;
		// }
		// }
		// System.out.println(Arrays.toString(seq));

		int marks = scan.nextInt();
		scan.nextLine();
		String naveen = scan.nextLine();
		String anjana = scan.nextLine();

		System.out.println(DSAContest11Service.myNaveenMarks(naveen, anjana, marks));

		// int size = scan.nextInt();
		// long num = scan.nextLong();
		// System.out.println(DSAContest11Service.maxTicekts(num));
		// System.out.println(DSAContest10Service.convertToBase9(size));

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

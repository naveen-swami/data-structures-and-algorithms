package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContestNumber4Service;
import com.contest.service.DSAContestNumber5Service;

public class DSAContestNumber5Controller {

	public static void main(String[] args) {
		DSAContestNumber5Service dsaContestNumber5Service = new DSAContestNumber5Service();
		Scanner scanner = new Scanner(System.in);

		int sizeA = scanner.nextInt();
		int sizeB = scanner.nextInt();
		int[] arrA = new int[sizeA];
		int[] arrB = new int[sizeB];

		for (int i = 0; i < sizeA; i++) {
			arrA[i] = scanner.nextInt();
		}

		for (int i = 0; i < sizeB; i++) {
			arrB[i] = scanner.nextInt();
		}

		System.out.println(DSAContestNumber5Service.modificationsInArrayAToMakeArrBItsSubarray(arrA, arrB));

		// String str = scanner.nextLine();
		// System.out.println(DSAContestNumber5Service.logestSubStringContainCharA(str));
		// System.out.println(DSAContestNumber5Service.isRed(str) ? "Yes" : "No");

	}

}

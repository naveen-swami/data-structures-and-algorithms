package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContest6Service;

public class DSAContest6Controller {

	static Scanner scan = new Scanner(System.in);
	static DSAContest6Service dsaContest6Service;

	public static void main(String[] args) {

		// int num1 = scan.nextInt();
		// int num2 = scan.nextInt();
		//
		// System.out.println(DSAContest6Service.lcm(num1, num2));
		// System.out.println(DSAContest6Service.gcdOrHCF(num1, num2));
		// System.out.println("LCM: " + DSAContest6Service.lcmBestWay(num1, num2));

		int pSize = scan.nextInt();
		int qSize = scan.nextInt();
		int pPrice = scan.nextInt();
		int qPrice = scan.nextInt();
		int smartness = scan.nextInt();

		int[] pApple = getOneDArrayTest(pSize);
		int[] qApple = getOneDArrayTest(qSize);

		System.out.println(DSAContest6Service.pickSmatestAppleWithMinimumCost(pSize, qSize, pApple, qApple, pPrice,
				qPrice, smartness));

		// System.out.println(DSAContest6Service.girlsAndBoysArrangement(num, girls,
		// boys));
		// System.out.println(dsaContest6Service.isProductOfN(num));
		// oneDArrayTest();
		// twoDArrayTest();
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		arr = DSAContest6Service.swapIfSumIsOdd(arr, size);
		DSAContest6Service.displayArray(arr);
		// System.out.println(DSAContest6Service.isProductOf4(arr, size) ? "YES" :
		// "NO");
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

	public static int[] getOneDArrayTest(int size) {
		// int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		// arr = DSAContest6Service.swapIfSumIsOdd(arr, size);
		// DSAContest6Service.displayArray(arr);
		// System.out.println(DSAContest6Service.isProductOf4(arr, size) ? "YES" :
		// "NO");
		return arr;
	}

}

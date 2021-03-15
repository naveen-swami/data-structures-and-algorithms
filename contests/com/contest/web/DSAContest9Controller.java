package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.contest.service.DSAContest9Service;

public class DSAContest9Controller {

	static Scanner scan = new Scanner(System.in);
	static DSAContest3Service dsaContest3Service = new DSAContest3Service();

	public static void main(String[] args) {
		int size = scan.nextInt();
		scan.nextLine();
		while(size--> 0) {
			
		String str = scan.nextLine();
		System.err.println(DSAContest9Service.changeIntoPseudoLatinWord(str));
		}
		//		System.out.println(DSAContest9Service.countEvenPlaceVowel(str));
		
		// int num = scan.nextInt();
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
		// oneDArrayTest();
//		twoDArrayTest();
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(dsaContest3Service.divideArrayToMakeEqualBinaryNumber(arr));

	}

	public static void twoDArrayTest() {
		int row = scan.nextInt();
		int[][] cordinates = new int[row][2];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 2; j++) {
				cordinates[i][j] = scan.nextInt();
			}
		}
		System.out.println(dsaContest3Service.smallestRectangle(cordinates));
	}

}

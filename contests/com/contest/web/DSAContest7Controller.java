package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.contest.service.DSAContest7Service;

public class DSAContest7Controller {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scan.nextInt();
		int k = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		System.out.println(DSAContest7Service.zeroWindow(str, size, k));
		// System.out.println(DSAContest7Service.calculateNoOfFactor(num));
		// oneDArrayTest();
		// twoDArrayTest();
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(DSAContest7Service.countDuplicateNumber(arr, size));
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

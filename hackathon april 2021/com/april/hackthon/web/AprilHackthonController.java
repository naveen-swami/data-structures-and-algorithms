package com.april.hackthon.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.april.hackathon.service.AprilHackathonService;
import com.contest.service.DSAContest3Service;

public class AprilHackthonController {

	static Scanner scan = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static AprilHackathonService aprilHackathonService = new AprilHackathonService();

	public static void main(String[] args) throws NumberFormatException, IOException {
//		int num = scan.nextInt();

//		AprilHackathonService.printLexicographicallyMinimumString(num);

//		String str = "1231001";
		
//		int size = scan.nextInt();
//		int k = scan.nextInt();
//		scan.nextLine();
//		String str = scan.nextLine().replace(" ", "");
		
//		AprilHackathonService.lexoSequence(str, k);
//		oneDArrayTest();
		oneDArrayTestWithBufferedReader();
	}
	
	public static void oneDArrayTestWithBufferedReader() throws NumberFormatException, IOException {
		String[] inputArr = reader.readLine().split(" ");
//		int size = Integer.parseInt(reader.readLine());
		int size = Integer.parseInt(inputArr[0]);
		int k = Integer.parseInt(inputArr[1]);
//		int[] arr = new int[size];
		long[] arr = new long[size];
		String[] strArr = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
//			arr[i] = Integer.parseInt(strArr[i]);
			arr[i] = Long.parseLong(strArr[i]);
		}

		AprilHackathonService.lexoSequence(arr, k);
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
//		AprilHackathonService.lexoSequence(arr, k);
//		AprilHackathonService.getMaximumNumberOfPepoleHappy(arr, size);

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

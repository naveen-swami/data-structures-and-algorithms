package com.contest.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.contest.service.DSAContest8Service;

public class DSAContest8Controller {

	static Scanner scan = new Scanner(System.in);
	static DSAContest8Service dsaContest8Service = new DSAContest8Service();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		inputWithOutTestCaseWithBufferReader1DArrays();
		// oneDArrayTest();
	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		long k = scan.nextLong();
		long[] arr = new long[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextLong();
		}

		System.out.println(DSAContest8Service.isEqualToK(arr, size, 0, k, 0));

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

	// (int maxChocolateCandyTake, int maxOrangeCandyTake,
	// int chocolateCandyTotal, int orangeCandyTotal, int unknowwnCandyTotal, int[]
	// chocoHappinessArr,
	// int[] orangeHappinessArr, int[] unknownHappinessArr) {
	static void inputWithOutTestCaseWithBufferReader1DArrays() throws IOException {
		String[] readLineStr = reader.readLine().split(" ");
		int maxChocolateCandyTake = Integer.parseInt(readLineStr[0]);
		int maxOrangeCandyTake = Integer.parseInt(readLineStr[1]);
		int chocolateCandyTotal = Integer.parseInt(readLineStr[2]);
		int orangeCandyTotal = Integer.parseInt(readLineStr[3]);
		int unknowwnCandyTotal = Integer.parseInt(readLineStr[4]);
		PriorityQueue<Integer> chocoHappinessPQ = getHeapUsingBufferedReader(chocolateCandyTotal);
		PriorityQueue<Integer> orangeHappinessPQ = getHeapUsingBufferedReader(orangeCandyTotal);
		PriorityQueue<Integer> unknownHappinessPQ = getHeapUsingBufferedReader(unknowwnCandyTotal);

		System.out.println(DSAContest8Service.countHappinessOfOrangeAndChocolateCandy(maxChocolateCandyTake,
				maxOrangeCandyTake, chocolateCandyTotal, orangeCandyTotal, unknowwnCandyTotal, chocoHappinessPQ,
				orangeHappinessPQ, unknownHappinessPQ));

	}

	static PriorityQueue<Integer> getHeapUsingBufferedReader(int size) throws IOException {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

		String[] readLine = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			priorityQueue.add(Integer.parseInt(readLine[i]));
		}
		return priorityQueue;
	}

	static int[] getOneDArrayUsingBufferedReader(int size) throws IOException {
		int[] arr = new int[size];
		String[] readLine = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(readLine[i]);
		}
		return arr;
	}

}

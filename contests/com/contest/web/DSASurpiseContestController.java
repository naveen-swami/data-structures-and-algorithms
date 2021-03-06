package com.contest.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.contest.service.DSASurpiseContestService;

public class DSASurpiseContestController {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		inputWithOutTestCaseWithBufferReader1DArrays();
	}

	static int[] getOneDArrayUsingBufferedReader(int size) throws IOException {
		int[] arr = new int[size];
		String[] readLine = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(readLine[i]);
		}
		return arr;
	}

	static long[] getOneDArrayUsingBufferedReaderUsingLong(int size) throws IOException {
		long[] arr = new long[size];
		String[] readLine = reader.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Long.parseLong(readLine[i]);
		}
		return arr;
	}

	static void inputWithOutTestCaseWithBufferReader1DArrays() throws IOException {
		String[] readLineStr = reader.readLine().split(" ");
		int size = Integer.parseInt(readLineStr[0]);
		int size2 = Integer.parseInt(readLineStr[1]);
		long k = Long.parseLong(readLineStr[2]);
		// int k = Integer.parseInt(readLine[1]);
		long[] arr = getOneDArrayUsingBufferedReaderUsingLong(size);
		long[] arr2 = getOneDArrayUsingBufferedReaderUsingLong(size2);

		System.out.println(DSASurpiseContestService.luckyBoys(arr, arr2, size, size2, k));
		// int[] arr2 = getOneDArrayUsingBufferedReader(size);
	}
}

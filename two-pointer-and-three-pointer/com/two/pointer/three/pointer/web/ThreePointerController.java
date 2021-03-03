package com.two.pointer.three.pointer.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.two.pointer.and.three.pointer.service.ThreePointerService;

public class ThreePointerController {

	static Scanner scanner = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static ThreePointerService threePointerService = new ThreePointerService();

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

	static void inputWithOutTestCaseWithBufferReader1DArrays() throws IOException {
		String[] readLineStr = reader.readLine().split(" ");
		int size = Integer.parseInt(readLineStr[0]);
		int[] arr = getOneDArrayUsingBufferedReader(size);
		// int k = Integer.parseInt(reader.readLine());
		threePointerService.sort0s1sAnd2s(arr, size);
		threePointerService.displayArray(arr);

	}
}

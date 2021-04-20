package com.contest.service;

public class DSAContest13Service {

	public static void gameTime(String str) {

		String[] turn = { "Naruto", "Sasuke" };

		int i = str.length() - 1;
		while (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
			i--;
		}

		System.out.println(turn[i % 2]);

	}

	public static void cakeXor(int size, int[] arr) {
		long xor = 0;
		for (int element : arr) {
			xor ^= element;
		}
		for (int element : arr) {
			long temp = xor;
			System.out.print((temp ^ element) + " ");
		}

	}

	public static void pairSum(int[] arr, int size) {
		long sum = 0;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				sum += Math.max(arr[i], arr[j]);
			}
		}
		System.out.println(sum);
	}

	public static void printCapitalLetter(String str) {
		for (char ch : str.toCharArray()) {
			if (ch < 97) {
				System.out.print(ch + " ");
			}
		}
	}
}

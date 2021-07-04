package com.contest.practice;

import java.util.Scanner;

public class CodingPractice1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		long num = scan.nextLong();
//
//		System.out.println(getMaxTickets(num));
		OneDArray();
	}
	
	public static void OneDArray() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		long[] arr = new long[size];
		for(int i = 0; i< size; i++) {
			arr[i] = scan.nextLong();
		}
		
		displayArr(rightMostHigest(arr));
		
 	}
	
	public static void displayArr(int[] arr) {
		for( int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] rightMostHigest(long[] arr) {
		int[] righMostIndex = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j >= i; j--) {
				if (arr[j] >= arr[i]) {
					righMostIndex[i] = j+1;
					break;
				}
			}
		}

		return righMostIndex;
	}

	public static long getMaxTickets(long num) {
		long maxTicket = 0;
		if (num >= 500) {
			maxTicket += (num / 500) * 1000;
			num %= 500;
		}
		if (num >= 5) {
			maxTicket += (num / 5) * 5;
			num %= 5;
		}

		return maxTicket;
	}
}

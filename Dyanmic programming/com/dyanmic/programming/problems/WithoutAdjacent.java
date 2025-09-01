package com.dyanmic.programming.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @author naveen
 *
 *         Given an array of positive numbers, find the maximum sum of a
 *         subsequence such that no two numbers in the subsequence should be
 *         adjacent in the array.
 * 
 * 
 *         Examples: Input: arr[] = {5, 5, 10, 100, 10, 5} Output: 110
 *         Explanation: Pick the subsequence {5, 100, 5}. The sum is 110 and no
 *         two elements are adjacent. This is the highest possible sum.
 * 
 *         Input: arr[] = {3, 2, 7, 10} Output: 13 Explanation: The subsequence
 *         is {3, 10}. This gives the highest possible sum = 13.
 * 
 *         Input: arr[] = {3, 2, 5, 10, 7} Output: 15 Explanation: Pick the
 *         subsequence {3, 5, 7}. The sum is 15.
 *
 */
public class WithoutAdjacent {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCase; i++) {
			int size = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[size];
			String[] arrStr = br.readLine().trim().split(" ");
			for (int j = 0; j < size; j++) {
				arr[j] = Integer.parseInt(arrStr[j]);
			}
			
			// using recursion
//			System.out.println(MaxSumOfNonAdjacentElementRec(arr, size - 1));

			// using memoization
//			int[] dp = new int[size];
//			System.out.println(MaxSumOfNonAdjacentElementMemoization(arr, size - 1, dp ));

			// using tabulation
//			System.out.println(MaxSumOfNonAdjacentElementTabulation(arr));
			
			// using space optimization
			System.out.println(MaxSumOfNonAdjacentElementSpaceOptimization(arr));
		}
	}

	static int MaxSumOfNonAdjacentElementRec(int[] arr, int i) {

		if (i < 0) {
			return 0;
		}

		if (i == 0) {
			return arr[0];
		}

		int take = arr[i] + MaxSumOfNonAdjacentElementRec(arr, i - 2);
		int noTake = 0 + MaxSumOfNonAdjacentElementRec(arr, i - 1);

		return Math.max(take, noTake);
	}

	// memoization is also called top down
	static int MaxSumOfNonAdjacentElementMemoization(int[] arr, int i, int[] dp) {

		if (i < 0) {
			return 0;
		}

		if (i == 0) {
			return arr[0];
		}
		
		if(dp[i] != 0) {
			return dp[i];
		}

		int take = arr[i] + MaxSumOfNonAdjacentElementMemoization(arr, i - 2, dp);
		int noTake = 0 + MaxSumOfNonAdjacentElementMemoization(arr, i - 1, dp);

		int max = Math.max(take, noTake);
		dp[i] = max;
		return dp[i];
	}

	// tabulation is also called bottom up
	static int MaxSumOfNonAdjacentElementTabulation(int[] arr) {
		
		int[] dp = new int[arr.length];
		
		dp[0] = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			int take = arr[i];
			if(i > 1) {
				take += dp[i-2]; 
			}
			int notTake = 0 + dp[i - 1];
			dp[i] = Math.max(take, notTake);
		}
		return dp[arr.length -1];
	}
	
	static int MaxSumOfNonAdjacentElementSpaceOptimization(int[] arr) {
		
		int prev = arr[0];
		int prev2 = 0;
		
		for(int i = 1 ; i < arr.length; i++) {
			int take = arr[i];
			if(i > 1) {
				take += prev2;
			}
			int notTake = 0 + prev;
			int max = Math.max(take, notTake);
			prev2 = prev;
			prev = max;
		}
		
		
		return prev;
	}

}

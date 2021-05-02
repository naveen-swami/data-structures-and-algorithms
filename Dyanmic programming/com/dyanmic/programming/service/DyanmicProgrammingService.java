package com.dyanmic.programming.service;

import java.util.List;

public class DyanmicProgrammingService {

	// Memoizing by the use of a table
	static long[][][] dp = new long[1000][1000][1000];

	// Function to calculate maximum score
	static long MaximumScoreDP(int l, int r, long prefix_sum[], int num) {
		// Bse case
		if (l > r)
			return 0;

		// If the same state has
		// already been computed
		if (dp[l][r][num] != -1)
			return dp[l][r][num];

		// Sum of array in range (l, r)
		long current_sum = prefix_sum[r] - (l - 1 >= 0 ? prefix_sum[l - 1] : 0);

		// If the operation is even-numbered
		// the score is decremented
		if (num % 2 == 0)
			current_sum *= -1;

		// Exploring all paths, and storing
		// maximum value in DP table to avoid
		// further repetitive recursive calls
		dp[l][r][num] = current_sum + Math.max(MaximumScoreDP(l + 1, r, prefix_sum, num + 1),
				MaximumScoreDP(l, r - 1, prefix_sum, num + 1));

		return dp[l][r][num];
	}

	// Function to find the max score
	static long findMaxScore(int a[], int n) {
		// Prefix sum array
		long[] prefix_sum = new long[n];

		prefix_sum[0] = a[0];

		// Calculating prefix_sum
		for (int i = 1; i < n; i++) {
			prefix_sum[i] = prefix_sum[i - 1] + a[i];
		}

		// Initialising the DP table,
		// -1 represents the subproblem
		// hasn't been solved yet
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				for (int l = 0; l < 1000; l++)
					dp[i][j][l] = -1;
			}
		}

		return MaximumScoreDP(0, n - 1, prefix_sum, 1);
	}

	public static long getMaximumScore(List<Integer> integerArray) {
        int n = integerArray.size();
		long[] prefix_sum = new long[n];

		prefix_sum[0] = integerArray.get(0);

	
		int i = 0;
		for (int val : integerArray) {
			prefix_sum[i] = prefix_sum[i - 1] + val;
			i++;
		}

		for (i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int l = 0; l < 100; l++)
					dp[i][j][l] = -1;
			}
		}

		return MaximumScoreDP(0, n - 1, prefix_sum, 1);
//		int[] arr = new int[integerArray.size()];
//
//		int i = 0;
//		for (int it : integerArray) {
//			arr[i] = it;
//			i++;
//		}
//		
//		return findMaxScore(arr, i);

	}
}

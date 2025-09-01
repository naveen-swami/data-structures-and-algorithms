package com.dyanmic.programming.problems;

public class MaximumLoot {

	public static void main(String args[]) {
		// System.out.println("test");
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		MaximumLoot test = new MaximumLoot();
		int max = test.getMaxRec(arr.length - 1, arr);
		
		int[] dp = new int[arr.length];
		
		System.out.println(max);

	}

	public int getMaxRec(int i, int[] arr) {
		if(i < 0) {
			return 0;
		}
		
		if(i == 0) {
			return arr[0];
		}
		
		int loot = arr[i] + getMaxRec(i - 2, arr);
		int notLoot = 0 + getMaxRec(i-1, arr);		

		int max = Math.max(loot, notLoot);
		return max;
	}
	
	int getMaxLootMemoization(int[] arr, int[] dp, int i) {
		
		if(i < 0) {
			return 0;
		}
		
		if(i == 0) {
			return arr[0];
		}
		
		if(dp[i] != 0) {
			return dp[i];
		}
		
		int loot = arr[i] + getMaxRec(i - 2, arr);
		int notLoot = 0 + getMaxRec(i-1, arr);		

		int max = Math.max(loot, notLoot);
		dp[i] = max;
		return dp[i];
		
	}
	
	int getMaxLootTabulation(int[] arr) {
		
		int n = arr.length;
		int[] dp = new int[n];
		
		dp[0] = arr[0];
		
		for(int i = 1; i < n; i++) {
			int loot = arr[i];
			if(i > 1) {
				loot += dp[i-2];
			}
			int notLoot = 0 + dp[i-1];
			
			int max = Math.max(loot, notLoot);
			dp[i] = max;
		}
		
		return dp[n-1];
	}
	
	long getMaxLootSpaceOptimization (int[] arr) {
		
		int n = arr.length;
		long prev2 = 0;
		long prev = arr[0];
	
		for(int i = 1; i < n; i++) {
			long loot = arr[i];
			if(i > 1) {
				loot = prev2;
			}
			long notLoot = 0 + prev;
			
			long max = Math.max(loot, notLoot);
			prev2 = prev;
			prev = max;
			
		}
		
		return prev;
	}
	
	

}

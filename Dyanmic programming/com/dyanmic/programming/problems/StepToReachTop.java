package com.dyanmic.programming.problems;

import java.util.Scanner;

public class StepToReachTop {

	static long[] dp = new long[51];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int targetStep = Integer.parseInt(scanner.next());
		int step1 = 1;
		int step2 = 2;
		int step3 = 3;
		
		long result = waysToGoTopViaDP(targetStep, step1, step2, step3);
		System.out.println(result);
	}

	static long wayToGoTop(int targetStep, int step1, int step2, int step3) {
		if (targetStep == 0) {
			return 1;
		} else if (targetStep < 0) {
			return 0;
		}
		return (wayToGoTop(targetStep - step1, step1, step2, step3) + wayToGoTop(targetStep - step2, step1, step2, step3)
				+ wayToGoTop(targetStep - step3, step1, step2, step3));
	}
	
	static long waysToGoTopViaDP(int targetStep, int step1, int step2, int step3) {
			
		if (targetStep == 0) {
			return 1;
		} else if (targetStep < 0) {
			return 0;
		} else if (dp[targetStep] != 0) {
			return dp[targetStep];
		}
		
		long result =  (waysToGoTopViaDP(targetStep - step1, step1, step2, step3) + waysToGoTopViaDP(targetStep - step2, step1, step2, step3)
				+ waysToGoTopViaDP(targetStep - step3, step1, step2, step3));
		dp[targetStep] = result;
		return result;
	}
}

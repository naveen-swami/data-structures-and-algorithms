package com.dyanmic.programming.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StepToReachTop {

	static long[] dp = new long[1000001];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int targetStep = Integer.parseInt(scanner.next());
		int step1 = 1;
		int step2 = 2;
		int step3 = 3;
		 Arrays.fill(dp, -1);
		
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
		} else if (dp[targetStep] != -1) {
			return dp[targetStep];
		}
		
		int mod = 1000000007;
		
		long result =  (waysToGoTopViaDP(targetStep - step3, step1, step2, step3) % mod )  + (waysToGoTopViaDP(targetStep - step2, step1, step2, step3) % mod)
				+ (waysToGoTopViaDP(targetStep - step1, step1, step2, step3) % mod);
		result = result % 1000000007;
		dp[targetStep] = result;
		return result;
	}
	
	public long maximumTotalSum(int[] maximumHeight) {
		       Arrays.sort(maximumHeight);
		        
		        int maxHeight = 1000000001;
		        long sum = 0;
		        for(int i = maximumHeight.length - 1; i >=0 ; i--) {
		        	int height = maximumHeight[i];
		            if(maxHeight <= 0) {
		                return -1;
		            }
		            if(height < maxHeight) {
		                 sum += height;
		                 maxHeight = height--;
		            } else {
		                sum += maxHeight;
		                maxHeight--;
		            }
		            
		        }
		        
		        return sum;
		        

        
    }
}

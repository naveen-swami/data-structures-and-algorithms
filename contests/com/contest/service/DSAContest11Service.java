package com.contest.service;

public class DSAContest11Service {
	
	
	public static int myNaveenMarks(String naveen, String anjana, int anjanaMarks) {
		int marks = 0;
		int same = 0;
		int totalMarks = naveen.length();
		
		for(int i= 0; i < totalMarks; i++) {
			if(naveen.charAt(i) == anjana.charAt(i)) {
				same++;
			}
		}
		
		marks = totalMarks - anjanaMarks - same;
		
		return marks;
	}

	public static long maxTicekts(long num) {
		long count = 0;

		if (num >= 500) {
			long val = num / 500;
			count += val * 1000;
			num -= val * 500;
		}
		if (num < 500) {
			long val = num / 5;
			count += val * 5;
		}

		return count;
	}

	public static Long count_divisors(int n) {
		Long count = 0l;
		for (int i = 1; i * i <= n; ++i) {
			if (n % i == 0) {
				if (i == n / i)
					count++;
				else
					count += 2;
			}
		}
		return count % 100000007;
	}

	public static long getDivisor(int n) {
		long ans = 0;
		int mod = 1000000007;
		long temp = (long) Math.pow(2, n);
		long count = 0;
		while (count != temp) {

		}

		return ans % mod;
	}

}

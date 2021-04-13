package com.contest.service;

public class DSAContest12Service {

	public static int transFormAtoB(int a, int b) {

		if (b > a) {
			return b - a;
		}
		int countOperation = 0;

		while (a != b) {
			if ((a & 1) == 0 && a > b) {
				a /= 2;
			} else if (b > a) {
				countOperation += b - a;
				break;
			} else {
				a += 1;
			}
			countOperation++;
		}

		return countOperation;
	}
	
	static int divisible(String num)
	{
		int n = num.length();

		// add up all the
		// digits of num
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += (int)(num.charAt(i));

		// if num is already is
		// divisible by 3 then
		// no digits are to be
		// removed
		if (sum % 3 == 0)
			return 0;

		// if there is single digit,
		// then it is not possible
		// to remove one digit.
		if (n == 1)
			return -1;

		// traverse through the number
		// and find out if any number
		// on removal makes the sum
		// divisible by 3
		for (int i = 0; i < n; i++)
			if (sum % 3 == (num.charAt(i) - '0') % 3)
				return 1;

		// if there are two numbers
		// then it is not possible
		// to remove two digits.
		if (n == 2)
			return -1;

		// Otherwise we can always
		// make a number multiple
		// of 2 by removing 2 digits.
		return 2;
	}

	public static int removeDigitFromNumber(long num) {
		int count = Integer.MAX_VALUE;

		String str = String.valueOf(num);

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				long n = Long.parseLong(str.substring(i, j));
				if (n % 3 == 0) {
					int res = str.length() - str.substring(i, j).length();
					count = Math.min(res, count);

				}
			}
		}

		/* This is first Memthod */

		// while (num > 1) {
		//
		// if (num % 3l == 0) {
		// return count;
		// }
		//
		// num /= 10l;
		// count++;
		//
		// }

		return count == Integer.MAX_VALUE ? -1 : count;
	}

	public static int totallyCount(int num) {
		int count = 0;
		int i = 1;
		while (i <= num) {
			if (i == 10 || i == 1000 || i == 100000) {
				i = i * 10;
				continue;
			}
			if ((i & 1) == 1) { // odd
				count++;
			}
			i++;
		}

		return count;
	}
}

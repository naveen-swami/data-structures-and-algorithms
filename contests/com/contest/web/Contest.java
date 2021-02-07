package com.contest.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Contest {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		// String naveen = scan.nextLine();
		// String anjana = scan.nextLine();
		//
		// System.out.println(getResult(naveen, anjana));

		// long o = scan.nextLong();
		// long a = scan.nextLong();
		// long u = scan.nextLong();
		//
		// long x = scan.nextLong();
		// long y = scan.nextLong();

		// System.out.println(getMaxDrown(o, a, u, x, y));

		// int n = scan.nextInt();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//String s = reader.readLine();

		//System.out.println(getSumOfNumber(s));

		// long m = scan.nextLong();
		//
		// long[] moveArr = new long[n];
		// for (int i = 0; i < n; i++) {
		// moveArr[i] = scan.nextLong();
		// }
		// Arrays.sort(moveArr);
		// boolean result = false;
		// long temp = 0l;
		// ; if (r < m) {
		// temp = m;
		// m = r;
		// r = temp;
		//// result = isMontyRichRickHouse(m, r, moveArr);
		// }
		// else {
		// result = isMontyRichRickHouse(r, m, moveArr);
		// }

		// for (int i = moveArr.length - 1; i >= 0; i--) {
		// if(m > r) {
		// result = false;
		// } else {
		// result = true;
		// break;
		// }
		// m += moveArr[i];
		// }
		//
		// System.out.println(result ? "Yes" : "No");

		int n = scan.nextInt();
		// int s = scan.nextInt();
		long num[] = new long[n];
		for (int i = 0; i < n; i++) {
			num[i] = scan.nextLong();
		}

		System.out.println(getHappinessTotal(num));
	}

	static long getHappinessTotal(long[] arr) {
		Arrays.sort(arr);
		long sum = 0;
		sum += arr[arr.length -1];
		for (int i = 1; i < arr.length / 2; i++) {
			sum += arr[i] + arr[arr.length - i - 1];
		}
		if (arr.length % 2 != 0) {
			sum += arr[arr.length / 2];
		}
		return sum;
	}

	static int getTimeLimit(int[] num, int s) {
		Arrays.sort(num);

		float min = (num[num.length - 1] * s) / 1000f;
		int intMin = (int) min;
		if (min == intMin) {
			return intMin;
			// System.out.println(intMin);
		} else {
			return intMin + 1;
			// System.out.println(intMin+1);
		}

	}

	static long getSumOfNumber(String n) {
		long sum = 0;

		for (int i = 0; i < n.length() / 2; i++) {
			sum += Character.getNumericValue((n.charAt(i))) + Character.getNumericValue(n.charAt(n.length() - i - 1));
		}

		return sum;
	}

	static boolean isMontyRichRickHouse(long m, long r, long[] moveArr) {
		if (m > r) {
			return false;
		} else if (m == r) {
			return true;
		}

		// for (int i = moveArr.length - 1; i >= 0; i--) {
		// if (isMontyRichRickHouse(m + moveArr[i], r, moveArr)) {
		// return true;
		// }
		// }
		int i = moveArr.length - 1;
		while (i >= 0) {
			isMontyRichRickHouse(m + moveArr[i], r, moveArr);

		}
		return false;
	}

	static long getMaxDrown(long o, long a, long u, long x, long y) {

		return Math.min(x, y);
	}

	static String getResult(String naveen, String anjana) {

		if (naveen.equals("R") || anjana.equals("R")) {
			return "R";
		} else if (anjana.equals("J")) {
			return naveen;
		} else if (naveen.equals("J")) {
			return anjana;
		} else {
			return "D";
		}

	}

}

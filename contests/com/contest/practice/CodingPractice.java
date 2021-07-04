package com.contest.practice;

import java.util.Scanner;

public class CodingPractice {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		long b = scan.nextLong();
		long c = scan.nextLong();
		long d = scan.nextLong();

		if (a > 0 || b > 0) {
			if (c > 0 || d > 0) {
				System.out.println(Math.max(a, b) * Math.max(c, d));
			} else if ((a < 0 || b < 0) && (c < 0 || d < 0)) {
				System.out.println(Math.min(a, b) * Math.min(c, d));
			} else {
				System.out.println(Math.min(a, b) * Math.max(c, d));
			}
		} else {
			if (c > 0 || d > 0) {
				long multiply = Math.max(a, b) * Math.min(c, d);
				System.out.println(multiply);
			} else {
				System.out.println(Math.min(a, b) * Math.min(c, d));
			}

		}
	}
}

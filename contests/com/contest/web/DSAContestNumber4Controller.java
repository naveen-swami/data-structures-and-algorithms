package com.contest.web;

import java.util.Scanner;

import com.contest.service.DSAContestNumber4Service;

public class DSAContestNumber4Controller {

	static Scanner scan = new Scanner(System.in);
	static DSAContestNumber4Service dsaContestNumber4Service = new DSAContestNumber4Service();

	public static void main(String[] args) {
		// int num = scan.nextInt();
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
		oneDArrayTest();
	}

	public static void oneDArrayTest() {
		int totalMember = scan.nextInt();
		long dishes = scan.nextLong();
		int[] timeToFinshSingleDish = new int[totalMember];
		for (int i = 0; i < totalMember; i++) {
			timeToFinshSingleDish[i] = scan.nextInt();
		}

		System.out.println(
				dsaContestNumber4Service.minimumTimeRquiredToEatAtLeastPDishesh(timeToFinshSingleDish, dishes));

	}

}

package com.contest.service;

import java.util.Arrays;

public class DSAContestNumber4Service {

	public static long minimumTimeRquiredToEatAtLeastPDishesh2ndWay(int[] memberTimeArr, long dishes) {

		int totalDishes = 0;
		//long minimumTimeRquired = 0;
		long i = 1;
		long j = dishes;

		while (i < j) {
			long mid = i + (j - i) / 2;
			totalDishes = 0;
			for (int timeTakenByMember : memberTimeArr) {
				totalDishes += mid / timeTakenByMember;
			}
			if (totalDishes == dishes) {
				return mid;
			} else if (totalDishes > dishes) {
//				if(minimumTimeRquired > totalDishes) {
//					minimumTimeRquired = mid;
//				}
				j = mid;
			} else {
				i = mid + 1;
			}
		}

		return i;
	}

	public int minimumTimeRquiredToEatAtLeastPDishesh(int[] memberTimeArr, long dishes) {
		int minimumTimeRquired = 0;

		while (dishes > 0) {
			minimumTimeRquired++;
			for (int timeTakenByMember : memberTimeArr) {
				if (minimumTimeRquired % timeTakenByMember == 0) {
					dishes--;
				}
			}
		}

		return minimumTimeRquired;
	}

	public int closestPrimeNumber(int num) {
		int closestNumber = Integer.MAX_VALUE;

		if (num <= 2) {
			return 2;
		} else if (num <= 4) {
			return 3;
		} else if (num == 5) {
			return 5;
		}

		int numberRange = num / 6;
		// 6n + 1 or 6n - 1 , where n is not prime number (i.e 2, 3, 5 , 7, 13, ..)
		for (int i = numberRange - 1; i <= numberRange + 1; i++) {
			int primeNumber = 6 * i - 1;
			if (isItPrimeNumber(primeNumber) && Math.abs(num - closestNumber) > Math.abs(num - primeNumber)) {
				closestNumber = primeNumber;
			}

			primeNumber = 6 * i + 1;
			if (isItPrimeNumber(primeNumber) && Math.abs(num - closestNumber) > Math.abs(num - primeNumber)) {
				closestNumber = primeNumber;
			}

		}
		return closestNumber;
	}

	public boolean isItPrimeNumber(int num) {

		for (int i = 5; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

}

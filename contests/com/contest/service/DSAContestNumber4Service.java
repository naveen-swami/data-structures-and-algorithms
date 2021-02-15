package com.contest.service;

import java.util.Arrays;

public class DSAContestNumber4Service {
	
	
	public int minimumTimeRquiredToEatAtLeastPDishesh2ndWay(int[] memberTimeArr, long dishes) {
		int minimumTimeRquired = 0;
		


		return minimumTimeRquired;
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

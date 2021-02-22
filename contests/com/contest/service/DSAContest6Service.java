package com.contest.service;

import java.util.Arrays;

public class DSAContest6Service {

	public static long pickSmatestAppleWithMinimumCost(int pSize, int qSize, int[] pApple, int[] qApple, int pPrice,
			int qPrice, int smartness) {
		long minimumCost = 0l;

		Arrays.sort(pApple);
		Arrays.sort(qApple);

		int p = pSize - 1;
		int q = qSize - 1;

		int lcm = lcmBestWay(pPrice, qPrice);
		while (smartness > 0 && p >= 0 && q >= 0) {
			long pCost = (long) pApple[p] * (long) lcm / pPrice;
			long qCost = (long) qApple[q] * (long) lcm / qPrice;

			if (pCost > qCost) {
				minimumCost += pPrice;
				smartness -= pApple[p];
				p--;
			} else {
				minimumCost += qPrice;
				smartness -= qApple[q];
				q--;
			}

		}
		while (smartness > 0 && p >= 0) {
			minimumCost += pPrice;
			p--;
		}
		while (smartness > 0 && q >= 0) {
			minimumCost += qPrice;
			q--;
		}

		return smartness > 0 ? -1 : minimumCost;
	}

	public static long girlsAndBoysArrangement(long num, long girls, long boys) {
		long sumOfGirls = 0;
		long sumOfBoysAndGirls = girls + boys;

		sumOfGirls = girls * (num / sumOfBoysAndGirls);
		long remaingStudents = num - ((num / sumOfBoysAndGirls) * sumOfBoysAndGirls);

		while (remaingStudents > 0) {
			if (girls > remaingStudents) {
				sumOfGirls += remaingStudents;
			} else {
				sumOfGirls += girls;
			}

			remaingStudents -= sumOfBoysAndGirls;
		}

		return sumOfGirls;
	}

	public static boolean isProductOf4(int[] arr, int size) {
		long product = 1;
		for (int val : arr) {
			product *= val;
		}

		return product % 4 == 0;
	}

	public static int[] swapIfSumIsOdd(int[] arr, int size) {

		int prev = 0;
		for (int i = 1; i < size; i = i + 2) {
			if (arr[i] + arr[prev] % 2 == 1) {
				int temp = arr[i];
				arr[i] = arr[prev];
				arr[prev] = temp;
			}
			prev = i + 2;
		}

		return arr;
	}

	public static int lcm(int firstNumber, int secondNumber) {
		int lcm = 1;
		int factor = 2;
		while (firstNumber > 1 && secondNumber > 1) {
			while (firstNumber % factor == 0 || secondNumber % factor == 0) {
				if (firstNumber % factor == 0 && secondNumber % factor == 0) {
					firstNumber = firstNumber / factor;
					secondNumber = secondNumber / factor;
					lcm *= factor;

				} else if (firstNumber % factor == 0) {
					firstNumber = firstNumber / factor;
					lcm *= factor;
				} else { // if (secondNumber % factor == 0)
					secondNumber = secondNumber / factor;
					lcm *= factor;
				}
			}
			factor++;
		}

		if (firstNumber > 1) {
			lcm *= firstNumber;
		}
		if (secondNumber > 1) {
			lcm *= secondNumber;
		}
		return lcm;
	}

	public static int gcdOrHCF(int firstNumber, int secondNumber) {

		if (secondNumber == 0) {
			return firstNumber;
		}

		int reminder = firstNumber % secondNumber;

		return gcdOrHCF(secondNumber, reminder);

	}

	/*
	 * a x b = LCM(a, b) * GCD (a, b)
	 * 
	 * LCM(a, b) = (a x b) / GCD(a, b)
	 */
	public static int lcmBestWay(int firstNumber, int secondNumber) {

		return firstNumber * secondNumber / gcdOrHCF(firstNumber, secondNumber);

	}

	public static void displayArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}

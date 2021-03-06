package com.contest.service;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DSAContest8Service {

	public static long countHappinessOfOrangeAndChocolateCandy(int maxChocolateCandyTake, int maxOrangeCandyTake,
			int chocolateCandyTotal, int orangeCandyTotal, int unknowwnCandyTotal,
			PriorityQueue<Integer> chocoHappinessPQ, PriorityQueue<Integer> orangeHappinessPQ,
			PriorityQueue<Integer> unknownHappinessPQ) {
		int maxHappniness = 0;
		while (maxChocolateCandyTake-- > 0) {
			if (!chocoHappinessPQ.isEmpty()) {
				if (!unknownHappinessPQ.isEmpty()) {
					if (chocoHappinessPQ.peek() > unknownHappinessPQ.peek()) {
						maxHappniness += chocoHappinessPQ.poll();
					} else {
						maxHappniness += unknownHappinessPQ.poll();
					}
				} else {
					maxHappniness += chocoHappinessPQ.peek();
				}
			} else {
				maxHappniness += unknownHappinessPQ.poll();
			}
		}

		while (maxOrangeCandyTake-- > 0) {
			if (!orangeHappinessPQ.isEmpty()) {
				if (!unknownHappinessPQ.isEmpty()) {
					if (orangeHappinessPQ.peek() > unknownHappinessPQ.peek()) {
						maxHappniness += orangeHappinessPQ.poll();
					} else {
						maxHappniness += unknownHappinessPQ.poll();
					}
				} else {
					maxHappniness += orangeHappinessPQ.peek();
				}
			} else {
				maxHappniness += unknownHappinessPQ.poll();
			}
		}
		return maxHappniness;
	}

	public static boolean isEqualToK(long[] arr, int size, int index, long k, long sum) {

		long mod = 10000000000007l;

		if (index == size) {
			return k == sum;
		}

		return isEqualToK(arr, size, index + 1, k, (sum + arr[index]) % mod)
				|| isEqualToK(arr, size, index + 1, k, (sum - arr[index]) % mod);

	}
}

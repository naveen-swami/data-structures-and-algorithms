package com.contest.service;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.sun.org.apache.regexp.internal.recompile;

public class DSAContest8Service {

	public static long countHappinessOfOrangeAndChocolateCandy(int maxChocolateCandyTake, int maxOrangeCandyTake,
			int chocolateCandyTotal, int orangeCandyTotal, int unknowwnCandyTotal,
			PriorityQueue<Integer> chocoHappinessPQ, PriorityQueue<Integer> orangeHappinessPQ,
			PriorityQueue<Integer> unknownHappinessPQ) {
		int maxHappniness = 0;
		int maxHappniness2 = 0;

		PriorityQueue<Integer> chocoHappinessCopyPQ = new PriorityQueue<>(chocoHappinessPQ);
		PriorityQueue<Integer> orangeHappinessCopyPQ = new PriorityQueue<>(orangeHappinessPQ);
		PriorityQueue<Integer> unknownHappinessCopyPQ = new PriorityQueue<>(unknownHappinessPQ);

		maxHappniness += getMaxHappiness(maxChocolateCandyTake, chocoHappinessPQ, unknownHappinessPQ)
				+ getMaxHappiness(maxOrangeCandyTake, orangeHappinessPQ, unknownHappinessPQ);

		maxHappniness2 += getMaxHappiness(maxOrangeCandyTake, orangeHappinessCopyPQ, unknownHappinessCopyPQ)
				+ getMaxHappiness(maxChocolateCandyTake, chocoHappinessCopyPQ, unknownHappinessCopyPQ);
		return Math.max(maxHappniness, maxHappniness2);
	}

	public static long getMaxHappiness(int maxCandyTake, PriorityQueue<Integer> candyHappinessPQ,
			PriorityQueue<Integer> unknownHappinessPQ) {
		long happinessSum = 0;
		while (maxCandyTake-- > 0) {
			if (!candyHappinessPQ.isEmpty()) {
				if (!unknownHappinessPQ.isEmpty()) {
					if (candyHappinessPQ.peek() > unknownHappinessPQ.peek()) {
						happinessSum += candyHappinessPQ.poll();
					} else {
						happinessSum += unknownHappinessPQ.poll();
					}
				} else {
					happinessSum += candyHappinessPQ.poll();
				}
			} else {
				happinessSum += unknownHappinessPQ.poll();
			}
		}
		return happinessSum;
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

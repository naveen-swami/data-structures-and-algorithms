package com.contest.service;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class DSAContest7Service {

	public static int zeroWindow(String str, int size, int k) {
		int result = 0; // zero's should be more than or equal to one's
		int zeros = 0;
		int ones = 0;

		Deque<Character> dq = new LinkedList<>();

		for (int i = 0; i < size; i++) {
			char val = str.charAt(i);
			if (val == '0') {
				zeros++;
			} else {
				ones++;
			}
			dq.add(val);
			if (i < k - 1) {
				continue;
			}
			if (i == k - 1 && zeros >= ones) {
				result++;
			} else {

				char windowFirstValue = dq.pollFirst();
				if (windowFirstValue == '0') {
					zeros--;
				} else {
					ones--;
				}
				if (zeros >= ones) {
					result++;
				}

			}
		}

		return result;
	}

	public static int countDuplicateNumber(int[] arr, int size) {
		int countDuplicate = 0;

		HashMap<Integer, Integer> uniqueNumberMap = new HashMap<>();

		for (int val : arr) {
			if (uniqueNumberMap.containsKey(val)) {
				countDuplicate += 1;
			} else {
				uniqueNumberMap.put(val, 1);
			}
		}

		return countDuplicate;
	}

	public static int calculateNoOfFactor(long num) {
		int totalNoOfFactor = 0;

		for (int i = 1; i <= Math.sqrt(num); i++) {

			if (num % i == 0) {
				// if both number are equal i.e i and n/i
				if (num / i == i) {
					totalNoOfFactor += 1;
				} else {
					totalNoOfFactor += 2;

				}
			}
		}

		return totalNoOfFactor;
	}

}

package com.hashing.service;

import java.util.HashMap;
import java.util.Map;

public class HashingService {

	public void maximumDistanceBetweenSameElement(int[] arr, int size) {
		int maximumDistance = 0;

		Map<Integer, Integer> distanceMap = new HashMap<>();

		for (int i = 0; i < size; i++) {
			if (distanceMap.containsKey(arr[i])) {
				int distance = i - distanceMap.get(arr[i]);
				if (maximumDistance < distance) {
					maximumDistance = distance;
				}
			} else {
				distanceMap.put(arr[i], i);
			}

		}

		System.out.println(maximumDistance);
	}

	public void countSubArrayWithEqual1sAnd0s(int size, int[] arr) {
		int sum = 0;
		long count = 0;
		Map<Integer, Integer> count1sAnd0sMap = new HashMap<>();

		count1sAnd0sMap.put(0, 1);
		for (int element : arr) {
			sum += element == 0 ? -1 : 1;
			if (count1sAnd0sMap.containsKey(sum)) {
				count += count1sAnd0sMap.get(sum);
			}
			count1sAnd0sMap.put(sum, count1sAnd0sMap.getOrDefault(sum, 0) + 1);
		}

		System.out.println(count);
	}

	public void isPairWithGivenSum(int[] arr, int k) {

		Map<Integer, Integer> remainingSumMap = new HashMap<>();
		for (int element : arr) {
			int remaingSum = k - element;
			if (remainingSumMap.containsKey(remaingSum)) {
				System.out.println(1);
				return;
			}
			remainingSumMap.put(element, remainingSumMap.getOrDefault(element, 0) + 1);
		}
		System.out.println(0);

	}

	public void countPairWithGivenSum(int[] arr, int k) {

		long count = 0;
		Map<Integer, Integer> remainingSumMap = new HashMap<>();
		for (int element : arr) {
			int remaingSum = k - element;
			if (remainingSumMap.containsKey(remaingSum)) {
				count += remainingSumMap.get(remaingSum);
			}
			remainingSumMap.put(element, remainingSumMap.getOrDefault(element, 0) + 1);
		}
		System.out.println(count);

	}

	public void largestSubArrayWithZeroSum(int size, int[] arr) {
		int largestSubArray = 0;
		long sum = 0;
		Map<Long, Integer> elementLocationMap = new HashMap<>();
		elementLocationMap.put(0l, -1);
		for (int i = 0; i < size; i++) {
			sum += arr[i];
			if (elementLocationMap.containsKey(sum)) {
				int from = elementLocationMap.get(sum);
				if (i - from > largestSubArray) {
					largestSubArray = i - from;
				}
			} else {
				elementLocationMap.put(sum, i);
			}
		}

		System.out.println(largestSubArray == 0 ? -1 : largestSubArray);
	}
}

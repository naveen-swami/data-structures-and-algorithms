package com.hashing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HashingService {

	/**
	 * Given an array of N integers and an integer K, your task is to calculate the
	 * count of pairs whose sum is divisible by K. Sample Input 5 3 1 2 3 4 5
	 * 
	 * Sample Output 4
	 * 
	 * Explanation:- In Sample 2, (1 5), (1 2), (2 4), and (4 5) are the required
	 * pairs
	 */
	public void countPairSumDivisibleByK(int[] arr, int k) {
		int countPair = 0;

		// arr = 1 2 3 4 5 and k = 3
		Map<Integer, Integer> countMap = new HashMap<>();
//		int[] countArr = new int[k];
		// 2 -> 1
		//
		for (int val : arr) { // 2
			val = val % k; // 2

			if (countMap.containsKey((k - val) % k)) {
				countPair += countMap.get((k - val) % k); // 1
			}
//			val = val == 0 ? 0 : k - val; // 2
			countMap.put(val, countMap.getOrDefault(val, 0) + 1);
		}

//		return countPair;
		System.out.println(countPair);
	}

	/**
	 * 
	 * Given N pairs of strings where both strings in the pair are synonymous, also
	 * given a single input string S. Find all the synonymous string corresponding
	 * to S. <br>
	 * 
	 * Sample Input: 4 <br>
	 * ram shyam <br>
	 * shyam lalit <br>
	 * hari lalit <br>
	 * ram naman <br>
	 * ram <br>
	 * 
	 * Sample Output:- <br>
	 * hari lalit naman shyam
	 * 
	 * @param friendsArr
	 * @param size
	 */
	public void synonymStrings(String[][] friendsArr, int size, String synonymsFriend) {

		Map<String, Set<String>> synonymsMap = new HashMap<>();
		for (int i = 0; i < size; i++) {
			String firstFriend = friendsArr[i][0];
			String secondFriend = friendsArr[i][1];
			Set<String> synonmySet = new HashSet<>();
			if (synonymsMap.containsKey(firstFriend)) {
				synonmySet = synonymsMap.get(firstFriend);
				synonmySet.add(secondFriend);
				synonymsMap.put(firstFriend, synonmySet);
			} else {
				if (synonymsMap.containsKey(secondFriend)) {
					synonmySet = synonymsMap.get(secondFriend);
					synonmySet.add(firstFriend);
					synonymsMap.put(secondFriend, synonmySet);
					synonymsMap.put(firstFriend, new HashSet<>());
					continue;
				} else {
					synonmySet.add(friendsArr[i][1]);
					synonymsMap.put(firstFriend, synonmySet);
				}
			}

			synonmySet = new HashSet<>();
			if (synonymsMap.containsKey(secondFriend)) {
				synonmySet = synonymsMap.get(secondFriend);
				synonmySet.add(firstFriend);
				synonymsMap.put(secondFriend, synonmySet);
			} else {
				synonymsMap.put(secondFriend, synonmySet);
			}

		}

		// now we have to fetch data from synonymsMap
		// find synonymsFriend for it
		Set<String> lexicographicalOrder = new TreeSet<>();
		getSetInLexicographicalOrder(lexicographicalOrder, synonymsMap, synonymsFriend);
//		System.out.println(lexicographicalOrder.toString());
		displaySet(lexicographicalOrder, synonymsFriend);

	}

	private void getSetInLexicographicalOrder(Set<String> synonymSet, Map<String, Set<String>> synonmsMap,
			String friend) {
		if (synonmsMap.get(friend) == null || synonmsMap.get(friend).isEmpty()) {
			return;
		}
		for (String fri : synonmsMap.get(friend)) {
			if (synonymSet.contains(fri)) {
				continue;
			}
			synonymSet.add(fri);
			getSetInLexicographicalOrder(synonymSet, synonmsMap, fri);
		}
	}

	public void displaySet(Set<String> set, String synonymsFriend) {
		if (set.isEmpty()) {
			System.out.println(-1);
		}
		set.forEach(it -> {
			if (it.compareTo(synonymsFriend) != 0) {
				System.out.print(it + " ");
			}
		});
	}

	public void synonymStrings1(String[][] friendsArr, int size, String synonymsFriend) { // accepted
		HashMap<String, List<String>> m = new HashMap<>();
		HashMap<String, Integer> visited = new HashMap<>();
		List<String> l = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			String firstFriend = friendsArr[i][0];
			String secondFriend = friendsArr[i][1];
			if (m.containsKey(firstFriend) || m.containsKey(secondFriend)) {
				if (m.containsKey(firstFriend) && m.containsKey(secondFriend)) {
					List<String> l1 = m.get(firstFriend);
					l1.add(secondFriend);
					m.put(firstFriend, l1);
					List<String> l2 = m.get(secondFriend);
					l2.add(firstFriend);
					m.put(secondFriend, l2);
				} else if (m.containsKey(firstFriend)) {
					List<String> l1 = m.get(firstFriend);
					l1.add(secondFriend);
					m.put(firstFriend, l1);
					List<String> l2 = new ArrayList<>();
					l2.add(firstFriend);
					m.put(secondFriend, l2);
					visited.put(secondFriend, 0);
				} else {
					List<String> l1 = m.get(secondFriend);
					l1.add(firstFriend);
					m.put(secondFriend, l1);
					List<String> l2 = new ArrayList<>();
					l2.add(secondFriend);
					m.put(firstFriend, l2);
					visited.put(firstFriend, 0);
				}
			} else {
				List<String> l1 = new ArrayList<>();
				l1.add(secondFriend);
				m.put(firstFriend, l1);
				List<String> l2 = new ArrayList<>();
				l2.add(firstFriend);
				m.put(secondFriend, l2);
				visited.put(firstFriend, 0);
				visited.put(secondFriend, 0);
			}

		}
		if (m.containsKey(synonymsFriend)) {
			visit(synonymsFriend, l, m, visited);
			Collections.sort(l);
			for (String i : l) {
				if (i.equals(synonymsFriend))
					continue;
				System.out.print(i + " ");
			}
		} else
			System.out.print(-1);
	}

	void visit(String key, List<String> l, HashMap<String, List<String>> m, HashMap<String, Integer> visited) {
		l.add(key);
		visited.put(key, 1);
		Iterator<String> i = m.get(key).listIterator();
		while (i.hasNext()) {
			String n = i.next();
			if (visited.get(n) == 0) {
				visit(n, l, m, visited);
			}
		}
	}

	/**
	 * Given an unsorted array arr[] of N integers and a sum. The task is to count
	 * the number of subarrays which adds to a given number.
	 * 
	 * @param arr
	 * @param k
	 */
	public void countSubArrayWithGivenSum(int[] arr, int k) {

		Map<Long, Integer> countElementMap = new HashMap<>();
		long sum = 0;
		int countSubArrayWithGivenSum = 0;
		countElementMap.put(0l, 1);
		for (int element : arr) {
			sum += element;
			if (countElementMap.containsKey(sum - k)) {
				countSubArrayWithGivenSum += countElementMap.get(sum - k);
			}
			countElementMap.put(sum, countElementMap.getOrDefault(sum, 0) + 1);
		}
		System.out.println(countSubArrayWithGivenSum);
	}

	/**
	 * Given an array containing N integers and an integer K. Your task is to find
	 * the length of the longest Sub-Array with sum of the elements equal to the
	 * given value K.
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public void lengthOfLongestSubArray(int[] arr, int k) {
		int lengthOfLongestSubArray = 0;
		Long sum = 0l;

		Map<Long, Integer> sumIndexMap = new HashMap<>();
		sumIndexMap.put(0l, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sumIndexMap.containsKey(sum - k)) {
				int index = sumIndexMap.get(sum - k);
				if (lengthOfLongestSubArray < i - index) {
					lengthOfLongestSubArray = i - index;
				}
			}
			if (!sumIndexMap.containsKey(sum)) {
				sumIndexMap.put(sum, i);
			}
		}

		System.out.println(lengthOfLongestSubArray);

	}

	// work only for +tive Number
	public void lenOfLongSubarr(int[] arr, int k) {
		int lengthOfLongestSubArray = 0;

		long[] sumArr = new long[arr.length + 1];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			sumArr[i + 1] = sum;
		}

		int j = 1;
		for (int i = 0; i < sumArr.length; i++) {
			while (j < sumArr.length && sumArr[j] - sumArr[i] <= k) {
				j++;
			}
			j--;

			if (sumArr[j] - sumArr[i] == k && lengthOfLongestSubArray < (j - i)) {
				lengthOfLongestSubArray = j - i;
			}
		}
		System.out.println(lengthOfLongestSubArray);
	}

	/**
	 * First line of input contains a single integer N, second line of input
	 * contains N space separated strings. Third line of input contains a single
	 * integer Q, next Q line contains a single string each.
	 * 
	 * Constraints:- 1 < = N < = 1000 1 < = |String| < = 10 1 < = Q < = 100000
	 * 
	 * Note:-String will only contain lower case english letters <br>
	 * Output For each query in a new line print the anagrams in lexicographical
	 * order separated by spaces.
	 * 
	 */

	// Anagram Strings
	public void arangeSimilarString(int size, String[] strArr, String[] queryStrArr) {
		Map<String, List<String>> similarStringMap = new HashMap<>();

		for (String str : strArr) {
			char[] letters = str.toCharArray();
			Arrays.sort(letters);
			String sortedString = new String(letters);
			if (similarStringMap.containsKey(sortedString)) {
				similarStringMap.get(sortedString).add(str);
			} else {
				List<String> anagramList = new LinkedList<>();
				anagramList.add(str);
				similarStringMap.put(sortedString, anagramList);
			}
		}

		for (String query : queryStrArr) {
			char[] letters = query.toCharArray();
			Arrays.sort(letters);
			String sortedQuery = new String(letters);
			List<String> anagramList = similarStringMap.get(sortedQuery);
			if (anagramList == null) {
				System.out.println(-1);
				continue;
			}
			Collections.sort(anagramList);
			anagramList.forEach(it -> {
				System.out.print(it + " ");
			});
			System.out.println();
		}
	}

	public void countDistinctElementOfSizeK(int[] arr, int k) {

		Map<Integer, Integer> distinctElementMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (i >= k) {
				System.out.print(distinctElementMap.size() + " ");
				int key = arr[i - k];
				int value = distinctElementMap.get(key);
				if (value > 1) {
					distinctElementMap.put(key, value - 1);
				} else {
					distinctElementMap.remove(key);
				}
			}
			distinctElementMap.put(arr[i], distinctElementMap.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(distinctElementMap.size());

	}

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

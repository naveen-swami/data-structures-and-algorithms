package com.deque.service;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DequeService {

	public void maximumOfAllSubArray(int[] arr, int k) {

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i >= k) {
				System.out.print(arr[deque.peekFirst()] + " ");
				if (deque.peekFirst() <= i - k) {
					deque.removeFirst();
				}
			}
			while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
				deque.removeLast();
			}
			deque.add(i);
		}

		System.out.println(arr[deque.peekFirst()]);

	}

	/**
	 * You are given an integer n. Initially you have an empty string. You need to
	 * construct the string of length n with the following rules: 1. Insert the
	 * first character in the beginning of string, the second in the end, the third
	 * in the beginning, fourth in the end, and so on. 2. The first character should
	 * be 'a', followed by 'b', 'c', and so on. 'z' will be followed by 'a'.
	 */
	public String addAlphabetStartAndEnd(int size) {
		StringBuilder str = new StringBuilder();

		// char a = 'a';
		// System.out.println(a + 1);
		char a = 97;
		// System.out.println((char) a);

		for (int i = 0; i < size; i = i + 2) {
			str = str.insert(0, (char) (a + i % 26));
			if (i != size - 1) {
				str = str.append((char) (a + (i + 1) % 26));
			}
		}

		return str.toString();
	}

	public long sumOfMinimumAndMaximumElementsOfSubarrays(int[] arr, int k) {
		long sum = 0;
		int mod = 1000000007;
		Deque<Integer> minDeque = new LinkedList<>();
		Deque<Integer> maxDeque = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[i]) {
				minDeque.removeLast();
			}
			while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[i]) {
				maxDeque.removeLast();
			}
			minDeque.add(i);
			maxDeque.add(i);
		}

		for (int i = k; i < arr.length; i++) {
			sum = (sum + arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()]);
			if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k) {
				minDeque.removeFirst();
			}
			if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k) {
				maxDeque.removeFirst();
			}
			while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[i]) {
				minDeque.removeLast();
			}
			while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[i]) {
				maxDeque.removeLast();
			}
			minDeque.add(i);
			maxDeque.add(i);
		}

		sum = (sum + arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()]);
		return sum;
	}

	public long minSubArrayProdcut(int[] arr, int k) {
		long product = 1;
		int mod = 1000000007;
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			if (!deque.isEmpty() && i >= k) {
				product = (product * arr[deque.peekFirst()] % mod) % mod;
				if (deque.peekFirst() <= i - k) {
					deque.removeFirst();
				}
			}
			while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
				deque.removeLast();
			}
			deque.add(i);

		}
		product = (product * arr[deque.pollFirst()] % mod) % mod;

		return product;
	}
}

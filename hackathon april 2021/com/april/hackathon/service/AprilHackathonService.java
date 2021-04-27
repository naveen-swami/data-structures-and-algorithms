package com.april.hackathon.service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AprilHackathonService {

	public static void lexoSequence(long[] arr, int k) {

		Deque<Long> dq = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			dq.add(arr[i]);
		}
		for (int i = 1; i <= arr.length - k; i++) {

			if (arr[i] <= dq.peek()) {
				Deque<Long> tempQueue = new LinkedList<>(dq);
				Deque<Long> newQueue = new LinkedList<>();
				int j = i;
				for (; j < i + k && tempQueue.peek() == arr[j]; j++) {
					long element = tempQueue.pop();
					newQueue.add(element);

				}
				if (j < i + k && arr[j] < tempQueue.peek() ) {
					while (j < i + k) {
						newQueue.add(arr[j]);
						j++;
					}
					dq = newQueue;
				}
			}

		}
		while (!dq.isEmpty()) {
			System.out.print(dq.pop() + " ");
		}
		System.out.println();

	}

	public static void lexoSequence(String str, int k) {

		String min = str.substring(0, k);

		for (int i = 1; i <= str.length() - k; i++) {
			int minSeq = Integer.parseInt(min);
			int currentSequence = Integer.parseInt(str.substring(i, i + k));

			if (minSeq > currentSequence) {
				min = str.substring(i, i + k);
			}
		}
		System.out.println(min);
	}

	public static void getMaximumNumberOfPepoleHappy(int[] personTimeTaken, int size) {

		Arrays.sort(personTimeTaken);

		int sum = 0;
		int countHappyPerson = 0;

		for (int personTime : personTimeTaken) {

			if (sum <= personTime) {
				countHappyPerson++;
				sum += personTime;
			}
		}

		System.out.println(countHappyPerson);
	}

	public static void printLexicographicallyMinimumString(int num) {
		StringBuilder strBuilder = new StringBuilder();

		int times = num / 2;

		while (times-- > 0) {
			strBuilder.append("ab");
		}

		if (num % 2 == 1) {
			strBuilder.append("a");
		}

		System.out.println(strBuilder);
	}

	public static <E> void displayArr(E[] arr) {
		for (E elment : arr) {
			System.out.print(elment + " ");
		}
		System.out.println();
	}
}

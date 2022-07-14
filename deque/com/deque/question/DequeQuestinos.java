package com.deque.question;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class DequeQuestinos {
	public static void main(String[] args) {

		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		int[] res = maxSlidingWindow(arr, k);
		displayArr(res);

	}

	static void displayArr(int[] arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
	}

//	Given an array of integers A. There is a sliding window of size B which
//	is moving from the very left of the array to the very right.
//	You can only see the w numbers in the window. Each time the sliding window moves
//	rightwards by one position. You have to find the maximum for each window.
//	The following example will give you more clarity.
//
//	The array A is [1 3 -1 -3 5 3 6 7], and B is 3.
//
//	b = 
//
//	Window position
//
//	Max
//
//	———————————-
//
//	————————-
//	start = 1
//	end = start + b-1
//	max = -Int.max
//
//	res[] = {3,  }
//
//	[1 3 -1] -3 5 3 6 7
//
//	n * b 
//
//	O(N)
//
//
//
//	3
//	0 1 	2  3
//	1 [3 -1 -3] 5 3 6 7
//
//	3
//
//	1 3 [-1 -3 5] 3 6 7
//
//	5
//
//	1 3 -1 [-3 5 3] 6 7
//
//	5
//
//	1 3 -1 -3 [5 3 6] 7
//
//	6
//
//	1 3 -1 -3 5 [3 6 7]
//
//	7
//
//	Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
//
//	Note: If B > length of the array, return 1 element with the max of the array.
//
//	a,b : 10,000
//
//	Input Format
//
//	The first argument given is the integer array A. The second argument given is the integer B.
//
//	Output Format
//
//	Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1]
//
//	For Example
//
//	Input 1: A = [1, 3, -1, -3, 5, 3, 6, 7] B = 3 Output 1: C = [3, 3, 5, 5, 6, 7]

	public static int[] maxSlidingWindow(int[] arr, int k) {
		if (k == 1) {
			return arr;
		}
		int length = arr.length;
		int[] res = new int[length - k + 1];
		int resIndex = 0;

		Deque<Integer> windowDeque = new LinkedList<>();

		for (int i = 0; i < length; i++) {

			if (windowDeque.isEmpty() || (windowDeque.peekFirst() >= i - (k - 1) && windowDeque.size() < k)) {
				while (!windowDeque.isEmpty() && arr[windowDeque.peekLast()] < arr[i]) {
					windowDeque.removeLast();
				}
				windowDeque.addLast(i);
			}
			if (i >= k - 1) {
				res[resIndex++] = arr[windowDeque.peekFirst()];
			}
			if ((windowDeque.peekFirst() <= i - k + 1) || windowDeque.size() >= k) {
				windowDeque.removeFirst();
			}
		}

		if (resIndex < length - k + 1) {
			res[resIndex++] = arr[windowDeque.peekFirst()];
		}
		return res;
	}

}

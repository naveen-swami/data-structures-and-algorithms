package com.two.pointer.and.three.pointer.service;

import java.util.Arrays;

public class TwoPointerService {

	public int kthSmallestDifference2ndWay(int[] arr, int size, int k) {
		int diff = 0;

		Arrays.sort(arr);

		int[] diffArr = new int[size];
		int prevValue = 0;
		for (int i = 1; i < size; i++) {
			diff = arr[prevValue] - arr[i];
			diffArr[prevValue] = absolute(diff);
			prevValue++;
		}
		Arrays.sort(diffArr);

		return diffArr[k];
	}

	public int kthSmallestDifference1stWay(int[] arr, int size, int k) {
		int smallestDiff = 0;

		// sum of n numbers = n/2*(2*a + (n -1) * d); here size = 6, a = 2, n = size-1
		// and d = 1
		/*
		 * so formula look like this: (n - 1)/2 * (2 +size)
		 */
		// i.e 2, 3, 4, 5
		int sumOfNthNumber = (size - 1) / 2 * (2 + size);

		int diffArr[] = new int[sumOfNthNumber];

		int diffArrSize = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				int diff = arr[i] - arr[j];
				diffArr[diffArrSize] = this.absolute(diff);
				diffArrSize++;
			}
		}

		Arrays.sort(diffArr);
		smallestDiff = diffArr[k];

		return smallestDiff;
	}

	public int absolute(int num) {
		return num < 0 ? -(num) : num;
	}

	public int[] getSquaredSortedArray(int[] arr) {

		int index = arr.length - 1;
		int[] arrCopy = new int[index + 1];
		int firstPointer = 0;
		int secondPointer = index;
		while (firstPointer <= secondPointer) {
			int squareOfFirstValue = arr[firstPointer] * arr[firstPointer];
			int squareOfSecondValue = arr[secondPointer] * arr[secondPointer];

			if (squareOfFirstValue > squareOfSecondValue) {
				arrCopy[index] = squareOfFirstValue;
				firstPointer++;
			} else {
				arrCopy[index] = squareOfSecondValue;
				secondPointer--;
			}
			index--;
		}
		return arrCopy;
	}

	public void displayArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}

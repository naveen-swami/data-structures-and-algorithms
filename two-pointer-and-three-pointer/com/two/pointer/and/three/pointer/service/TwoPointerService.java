package com.two.pointer.and.three.pointer.service;

import java.util.Arrays;

public class TwoPointerService {

	public long countTriplets2ndWay(int[] arr, int size, int k) {
		Arrays.sort(arr);
		long countTriplets = 0;
		int i = 0;
		int j = 2;
		while (j < size) {
			if (i == j - 1) {
				j++;
			} else if (arr[j] - arr[i] > k) {
				i++;
			} else { // arr[j] - arr[i] <=k
				int n = j - i;
				countTriplets += (n * (n - 1)) / 2;
				j++;
			}
		}
		return countTriplets;

	}

	public long countTriplets(int[] arr, int size, int k) {
		Arrays.sort(arr);
		long countTriplets = 0;
		int j = 2;
		for (int i = 0; i < size - 2; i++) {
			while (j < size && arr[j] - arr[i] <= k) {
				j++;
			}
			j--;

			int n = j - i;
			if (n >= 2) {
				// combination formula = nCr = n! / r!(n-r)! , here n = j - i and r = 2
				// so, (n * (n - 1)) / 2
				countTriplets += (n * (n - 1)) / 2;
				j++;
			}
		}

		return countTriplets;

	}

	// https://www.youtube.com/watch?v=ym93rTBR4j8&ab_channel=codeExplainer
	// O(SizelogSize + O(logSize) * 0(size);
	public int kthSmallestDifference2ndWay(int[] arr, int size, int k) {
		Arrays.sort(arr); // O(SizelogSize);
		int smallestDistance = 0;
		int largestDistance = arr[size - 1] - arr[0];
		while (smallestDistance < largestDistance) { // O(logSize)
			int mid = smallestDistance + (largestDistance - smallestDistance) / 2;
			int totalPairDiffernceLessThanOrEqualToMid = findTotalPairDiffernceLessThanOrEqualToMid(arr, size, mid); // O(size)
			if (totalPairDiffernceLessThanOrEqualToMid >= k) {
				largestDistance = mid;
			} else {
				smallestDistance = mid + 1;
			}
		}
		return smallestDistance;
	}

	private int findTotalPairDiffernceLessThanOrEqualToMid(int[] arr, int size, int mid) {
		int j = 1;
		int totalPair = 0;
		for (int i = 0; i < size; i++) { // O(Size)
			// below while loop traverse only once. Not traverse every time with above for
			// loop
			// so time complexity of this function is O(size) + o(size) = 2* size = O(Size);
			while (j < size && arr[j] - arr[i] <= mid) { // O(Size)
				j++;
			}
			j--;
			totalPair += j - i;
		}
		return totalPair;
	}

	// n^2 + n log n
	public int kthSmallestDifference1stWay(int[] arr, int size, int k) {
		int smallestDiff = 0;

		// sum of n numbers = n/2*(2*a + (n -1) * d); here size = 6, a = 2, n = size-1
		// and d = 1
		/*
		 * so formula look like this: (n - 1)/2 * (2 +size)
		 */
		// i.e 2, 3, 4, 5
		int sumOfNthNumber = (size - 1) / 2 * (2 + size);

		int[] diffArr = new int[sumOfNthNumber];

		int diffArrSize = 0;
		for (int i = 0; i < size - 1; i++) { // n
			for (int j = i + 1; j < size; j++) { // n^2
				int diff = arr[i] - arr[j];
				diffArr[diffArrSize] = this.absolute(diff);
				diffArrSize++;
			}
		}

		Arrays.sort(diffArr); // n log n
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

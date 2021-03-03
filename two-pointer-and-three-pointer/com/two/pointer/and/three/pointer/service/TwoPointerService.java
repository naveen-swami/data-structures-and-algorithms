package com.two.pointer.and.three.pointer.service;

import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class TwoPointerService {

	public int tripletWithSum2ndWay(int[] arr, int size, int sum) { // O(n^2)
		int countTriplets = 0;
		Arrays.sort(arr);

		for (int i = 0; i < size - 2; i++) {
			int s = i + 1;
			int e = size - 1;
			countTriplets += check2ndAnd3rdNumber(arr, i, s, e, sum);
		}

		return countTriplets;
	}

	private int check2ndAnd3rdNumber(int[] arr, int i, int s, int e, int sum) {
		int count = 0;

		while (s < e) {
			if (arr[i] + arr[s] + arr[e] == sum) {
				count++;
			}
			if (sum < arr[i] + arr[e] + arr[s]) {
				e--;
			} else { // sum > arr[e] + arr[s]
				s++;
			}
		}

		return count;
	}

	public int tripletWithSum(int[] arr, int size, int k) { // O (n^2 * logn)
		int countTriplets = 0;

		for (int i = 0; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				int sum = arr[i] + arr[j];
				if (k - sum < 1 || k - sum < arr[j + 1]) {
					break;
				}
				int start = j + 1;
				int end = size - 1;
				boolean isRequiredSum = findThirdNumber(arr, start, end, k - sum);
				if (isRequiredSum) {
					countTriplets++;
				}
			}
		}

		return countTriplets;
	}

	private boolean findThirdNumber(int[] arr, int start, int end, int k) {

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == k) {
				return true;
			} else if (arr[mid] > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return false;
	}

	public int closestToX(int[] arr1, int[] arr2, int size, int x) {
		int closestDistance = Integer.MAX_VALUE;
		Arrays.sort(arr2);

		for (int val : arr1) {
			int needToCheck = Math.abs(x - val);
			int distance = findClosestDistance(arr2, size, needToCheck);
			if (closestDistance > distance) {
				closestDistance = distance;
			}
		}

		return closestDistance;
	}

	private int findClosestDistance(int[] arr, int size, int needToCheck) {
		int l = 0;
		int r = size - 1;
		int minDiff = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid == needToCheck) {
				return 0;
			} else if (arr[mid] > needToCheck) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
			if (minDiff > Math.abs(arr[mid] - needToCheck)) {
				minDiff = Math.abs(arr[mid] - needToCheck);
			}
		}

		return minDiff;
	}

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

	/**
	 * It sorted binary array (0 1 1 0 0 1 ) to (0 0 0 1 1 1)
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public int[] sortedBinaryArray(int[] arr, int size) {

		int start = 0;
		int end = size - 1;

		while (start < end) {
			if (arr[start] == 0) {
				start++;
			} else if (arr[end] == 1) {
				end--;
			} else { // swap
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}

		return arr;
	}

	public void displayArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}

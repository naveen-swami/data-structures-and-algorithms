package com.binary.search.service;

public class BinarySearchService {

	public static int minimumElementInSortedAndRotaedArray(int[] arr, int size) {
		int start = 0;
		int end = size - 1;
		int mid = 1;
		while (start < end) {
			mid = start + (end - start) / 2;
			if(start == mid) {
				return arr[end] > arr[start] ? arr[start] : arr[end];
			}
			if(arr[end] > arr[mid] ) {
				end = mid;
			} else {
				start = mid;
			}

		}
		return arr[start];
	}

	/*
	 * we have return kth sum of arr which is smaller or equals to k so we can take
	 * range of m is equal to value of arrays
	 */
	public static int getKthSum(int[] arr, int size, int k) {
		int m = 0;
		int minDivisor = 0;
		int maxDivisor = 100000; // max value of arrays value
		while (minDivisor <= maxDivisor) {
			int mid = minDivisor + (maxDivisor - minDivisor) / 2;
			if (isValid(arr, k, mid, size)) {
				m = mid;
				maxDivisor = mid - 1;
			} else {
				minDivisor = mid + 1;
			}
		}
		return m;
	}

	private static boolean isValid(int arr[], int k, int mid, int size) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += Math.ceil((double) arr[i] / mid);
		}
		return sum <= k ? true : false;
	}

	public boolean checkIfNumberHave(int[] arr, int n, int find) {
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (arr[mid] == find) {
				return true;
			} else if (arr[mid] > find) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

}

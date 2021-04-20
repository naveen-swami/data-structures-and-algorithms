package com.binary.search.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BinarySearchService {

	public static int minimumElementInSortedAndRotaedArray(int[] arr, int size) {
		int start = 0;
		int end = size - 1;
		int mid = 1;
		while (start < end) {
			mid = start + (end - start) / 2;
			if (start == mid) {
				return arr[end] > arr[start] ? arr[start] : arr[end];
			}
			if (arr[end] > arr[mid]) {
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
		return sum <= k;
	}

	public boolean checkIfNumberHave(long[] arr, int n, int find) {
		int start = 0;
		int end = n - 1;
		if(find < arr[start] || find > arr[end] ) {
			return false;
		}
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
//		return Arrays.binarySearch(arr, find) == 0 ? false : true;
	}

	// we can do it by two ways
	// 1) using hashMap
	// 2) store all element in 1D array and find number by using binary search
	// algorithm

	public boolean checkIfNumberHaveIn2DMatrix(long[][] arr, int row, int column, int find) {
		for (long[] wholeRow : arr) { // Row times
			Arrays.sort(wholeRow); // NlogN
			if (checkIfNumberHave(wholeRow, column, find)) { // BSA: logN
				return true;
			}
		}
		return false;
	} // row * CollogColumn * logColumn -> r*c (logCol)^2
	
	public Set<Integer> converArrayToSet(int[][] arr) {
		Set<Integer> numberSet = new HashSet<>();
		for (int[] wholeRow : arr) { // Row times
		       for(int colData : wholeRow ) {
		    	   numberSet.add(colData);
		       }
		}
		return numberSet;
	} 
	
}

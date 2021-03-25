package com.sorting.algo.service;

public class SortingAlgoProblemsService {

	public static int inversionCont(int[] arr, int size) { // O(n^2)
		int inversionCount = 0;

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] > arr[j]) {
					inversionCount++;
				}
			}
		}

		return inversionCount;
	}

	static long inversionCount = 0;
	public static long inversionCont1(int[] arr, int size) {

		//displayArr(implimentationOfEnhanceMergeSort(arr, 0, size -1));
		
		implimentationOfEnhanceMergeSort(arr, 0, size -1);
		return inversionCount;
	}

	public static int[] implimentationOfEnhanceMergeSort(int[] arr, int start, int end) {
		if (start >= end) {
			return arr;
		}

		int mid = start + (end - start) / 2;
		implimentationOfEnhanceMergeSort(arr, start, mid);
		implimentationOfEnhanceMergeSort(arr, mid + 1, end);
		enhanceMergeSort(arr, start, mid, end);
		return arr;
	}

	public static long enhanceMergeSort(int[] arr, int start, int mid, int end) {
		int[] sortedArr = new int[end - start+1];
		int left = start;
		int right = mid + 1;
		int i = 0;
		while (left <= mid && right <= end) {
			if (arr[left] <= arr[right]) {
				sortedArr[i] = arr[left];
				left++;
			} else {
				sortedArr[i] = arr[right];
				inversionCount += mid - left +1;
				right++;
			}
			i++;
		}

		while (left <= mid) {
			sortedArr[i] = arr[left];
			left++;
			i++;
		}
		while (right <= end) {
			sortedArr[i] = arr[right];
			right++;
			i++;
		}

		// copy mergedArr to arr
		for (int j = 0; j < sortedArr.length; j++, start++) {
			arr[start] = sortedArr[j];
		}
		return inversionCount;
	}

	public static void displayArr(int[] arr) {
		for (int el : arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}
}

package com.sorting.algo.service;

public class SortingAlgortihmsService {

	public int[] quickSort(int[] arr, int start, int end) { // O(nlogn) if pivot choose correct otherwise O(n^2)

		if (start >= end) { // base case
			return arr;
		}

		int pivotIdx = partition(arr, start, end);
		quickSort(arr, start, pivotIdx - 1); // left half
		quickSort(arr, pivotIdx + 1, end); // right half

		return arr;
	}

	/**
	 * 
	 * It return parition element which divide the array into two parts.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int[] arr, int start, int end) { // n

		int pivot = end;
		int endIdx = end - 1;
		while (start <= endIdx) {
			if (arr[start] <= arr[pivot]) {
				start++;
			} else { // arr[start] > pivot
				swap(arr, start, endIdx);
				endIdx--;
			}
		}

		swap(arr, start, pivot);

		return start;
	}

	public int[] implementMergeSort(int[] arr, int start, int end) { // nlog n

		if (start >= end) { // base case
			return arr;
		}

		int mid = start + (end - start) / 2;
		implementMergeSort(arr, start, mid); // left half
		implementMergeSort(arr, mid + 1, end); // right half
		merge(arr, start, mid, end); // it will merge left half and right half

		return arr;
	}

	/**
	 * It merge two parts of array into one part
	 * 
	 * @param arr
	 * @param start
	 * @param mid
	 * @param end
	 */
	public void merge(int[] arr, int start, int mid, int end) { // n
		int[] mergeArray = new int[end - start + 1];
		int left = start;
		int right = mid + 1;
		int k = 0;
		while (left <= mid && right <= end) {
			if (arr[left] < arr[right]) {
				mergeArray[k] = arr[left];
				left++;
			} else {
				mergeArray[k] = arr[right];
				right++;
			}
			k++;
		}

		while (left <= mid) {
			mergeArray[k] = arr[left];
			left++;
			k++;
		}
		while (right <= end) {
			mergeArray[k] = arr[right];
			right++;
			k++;
		}

		// copy mergeArray to arr
		for (int i = 0; i < mergeArray.length; i++, start++) {
			arr[start] = mergeArray[i];
		}

	}

	public int[] mergeSort(int[] arr, int start, int end) { // n*logn = nlogn
		int[] sortedArray = new int[end - start + 1];

		if (start == end) {
			sortedArray[0] = arr[start];
			return sortedArray;
		}

		int mid = start + (end - start) / 2;
		int[] sortedArray1 = mergeSort(arr, start, mid);
		int[] sortedArray2 = mergeSort(arr, mid + 1, end);
		sortedArray = mergeTwoArrays(sortedArray1, sortedArray2, sortedArray1.length, sortedArray2.length);

		return sortedArray;
	}

	public int[] mergeTwoArrays(int[] arr1, int[] arr2, int size1, int size2) { // n
		int[] mergetwoArray = new int[size1 + size2];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < size1 && j < size2) {
			if (arr1[i] < arr2[j]) {
				mergetwoArray[k] = arr1[i];
				i++;
			} else { // arr1[i] > arr2[j]
				mergetwoArray[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			mergetwoArray[k] = arr1[i];
			i++;
			k++;
		}

		while (j < size2) {
			mergetwoArray[k] = arr2[j];
			j++;
			k++;
		}

		return mergetwoArray;
	}

	// Binary search algo
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

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public void selectionSort(int[] arr, int size) { // n^2
		for (int i = 0; i < size - 1; i++) {
			int minIndex = i;
			int j = i + 1;
			while (j < size) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				j++;
			}
			if (minIndex != i) {
				this.swap(arr, i, minIndex);
			}
		}
	}

	public void insertionSort(int[] arr, int size) { // n^2
		for (int i = 1; i < size; i++) {
			int current = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > current) { // shift Right side until arr[j] bigger then current
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
		}
	}

	public void display(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}

	public void bubbleSort(int[] arr, int size) { // n^2
		for (int i = 1; i < size; i++) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				int temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}
}

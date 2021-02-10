package com.sorting.algo.service;

public class SortingAlgortihmsService {
	
	// Binary search algo
	public boolean checkIfNumberHave(int[]arr, int n, int find) {
		int start = 0;
		int end = n - 1;
		while(start <= end) {
			int mid = start + ((end - start) / 2);
			if(arr[mid] == find) {
				return true;
			} else if(arr[mid] > find) {
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

	public void selectionSort(int[] arr, int size) {
		for (int i = 0; i < size - 1; i++) {
			int minIndex = i;
			int j = i + 1;
			while (j < size) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				j++;
			}
			if(minIndex != i) {
				this.swap(arr, i, minIndex);
			}
		}
	}

	public void insertionSort(int[] arr, int size) {
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

	public void bubbleSort(int[] arr, int size) {
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
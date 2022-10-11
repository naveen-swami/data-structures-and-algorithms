package com.two.pointer.and.three.pointer.service;

public class ThreePointerService {

	/**
	 * 
	 * It sorts the array. Array which contains 0, 1 and 2. Example: 0, 1, 2, 2, 0,
	 * 1, 0. => 0,0,0,1,1,2,2
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public int[] sort0s1sAnd2s(int[] arr, int size) {

		int i = 0;
		int j = 0;
		int k = size - 1;

		while (j <= k) {
			if (arr[j] == 0) {
				if (arr[j] != arr[i]) {
					swap(arr, j, i);
				}
				i++;
				j++;
			} else if (arr[j] == 2) {
				if (arr[j] != arr[k]) {
					swap(arr, j, k);
				}
				k--;
			} else {
				j++;
			}
		}

		return arr;
	}

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public void displayArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}

package com.interview.questions;

public class MergeTwoShortedArr {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int res[] = new int[arr1.length + arr2.length];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				res[k++] = arr1[i];
				res[k++] = arr2[j];
				i++;
				j++;
			} else {
				res[k++] = arr2[j];
				j++;
			}
		}
		while (i < arr1.length) {
			res[k++] = arr1[i];
		}
		while (j < arr1.length) {
			res[k++] = arr1[j];
		}

		for (int num : res) {
			System.out.print(num + " ");
		}
	}
}
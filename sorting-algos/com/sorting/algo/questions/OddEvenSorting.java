package com.sorting.algo.questions;

import java.util.Arrays;
import java.util.Collections;

/**
 * Even-Odd seperate sorting
 * 
 * Given an array A of positive integers. Your task is to sort them in such a
 * way that the first part of the array contains odd numbers sorted in
 * descending order, rest portion contains even numbers sorted in ascending
 * order.
 * 
 * size-> 7 arr->1 2 3 5 4 7 10 o/p-> 7 5 3 1 2 4 10
 * 
 * @author naveen
 *
 */
public class OddEvenSorting {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 5, 4, 7, 10 };
//		evenOddSorting(arr, 7);
		evenOddSorted2ndWay(arr, arr.length);
	}

	static void evenOddSorting(int[] arr, int size) {

		// Separate even and odd
		int i = 0;
		int j = size - 1;
		while (i < j) {
			if (arr[i] % 2 != 0) {
				i++;
			} else if (arr[j] % 2 == 0) {
				j--;
			} else {
				swap(arr, i, j);
				i++;
				j--;
			}

		}
		
		Arrays.sort(arr, i, arr.length);
//		Arrays.sort(arr, 0, i, Collections.
//                reverseOrder());
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void evenOddSorted2ndWay(int[] arr, int size) {
		
		//count + odd number
		int countPosNum = 0;
		for(int i = 0; i < size; i++) {
			if(arr[i] % 2 != 0 ) {
				if(arr[i] >= 0) {
					countPosNum++;
				}
				arr[i] = -arr[i];
			}
		}
		
		Arrays.sort(arr);
		
		
		//again convert into original arr
		
		for(int i = 0; i < size; i++) {
			if(arr[i] % 2 != 0 ) {
				arr[i] = -arr[i];
			}
		}
		
		Arrays.sort(arr, countPosNum, size);
		System.out.println(Arrays.toString(arr));
		
	}

	static void swap(int[] arr, int from, int to) {
		int x = arr[from];
		int y = arr[to];
		x = x + y;
		y = x - y;
		x = x - y;
		arr[from] = x;
		arr[to] = y;
	}

}

package com.heap.questions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * 
 * Given an array of n elements, where each element is at most k away from its
 * position in the sorted array, you need to sort the array optimally.
 * 
 * @author naveen
 *
 */
public class NearlySortedArray {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		int k = scan.nextInt();
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
//		arr = sortNearlySortedArrayUsingInsertionSort(arr, size, k);
//		System.out.println(Arrays.toString(arr));
		arr = sortNearlySortedArrayUsingHeap(arr, size, k);
		displayArr(arr);

	}

	static int[] sortNearlySortedArrayUsingInsertionSort(int[] arr, int size, int k) {
//		int[] res = new int[size];

		for (int i = 0; i < size; i++) {
			int current = arr[i];
			int j = i - 1;

			while (j >= 0 && j >= i - k && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
		}

		return arr;
	}
	
	static int[] sortNearlySortedArrayUsingHeap(int[] arr, int size, int k) {
		
		int j = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int[] res = new int[size];
		for(int i = 0; i < size; i++) {
			if(minHeap.size() <= k + 1) {
				minHeap.add(arr[i]);
				continue;
			}
//			System.out.println(j);
			res[j] = minHeap.poll();
			minHeap.add(arr[i]);
			j++;
//			System.out.println(Arrays.toString(res));
		}
//		System.out.println(j);
//		System.out.println(minHeap);
		
		while(!minHeap.isEmpty()) {
			res[j] = minHeap.poll();
			j++;
		}
		
		return res;
	}
	

	public static void displayArr(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}

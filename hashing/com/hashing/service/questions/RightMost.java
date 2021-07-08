package com.hashing.service.questions;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given an Array Arr of N integers. For each i from 1 to N find the index j
 * such that Arr[j] >= Arr[i] for multiple possible j find the rightmost j.
 * Input First line of input contains a single integer N. Second line of input
 * contains N integers, denoting the elements of the array.
 * 
 * Constraints: 1 <= N <= 100000 1 <= Arr[i] <= 1000000000 Output Print N space
 * separated integers the values of j for each i from 1 to N.
 * 
 * 
 * Sample Input: 5 5 2 4 3 1
 * 
 * Sample Output: 1 4 3 4 5
 * 
 * @author Admin
 *
 */
public class RightMost {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		long num = scan.nextLong();
//
//		System.out.println(getMaxTickets(num));
		OneDArray();
	}

	public static void OneDArray() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		displayArr(rightMostHigest1(arr));

	}

	public static void displayArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	
	public static int[] rightMostHigest1(int[] arr) {
		int[] righMostIndex = new int[arr.length];
		
		Map<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
		for(int i = 0; i < arr.length; i++) {
			treeMap.put(arr[i], i+1);
		}
		
		int maxIndex = -1;
	    for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
	        int value = entry.getValue();
	    	if(maxIndex < value) {
	        	maxIndex = value;
	        }
	         entry.setValue(maxIndex);
	    }
	    
		for(int i = 0; i < arr.length; i++) {
	        righMostIndex[i] = treeMap.get(arr[i]);
	    }
		
		return righMostIndex;
	}
	
	public static int[] rightMostHigest(long[] arr) {
		int[] righMostIndex = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j >= i; j--) {
				if (arr[j] >= arr[i]) {
					righMostIndex[i] = j + 1;
					break;
				}
			}
		}

		return righMostIndex;
	}

	public static long getMaxTickets(long num) {
		long maxTicket = 0;
		if (num >= 500) {
			maxTicket += (num / 500) * 1000;
			num %= 500;
		}
		if (num >= 5) {
			maxTicket += (num / 5) * 5;
			num %= 5;
		}

		return maxTicket;
	}
}
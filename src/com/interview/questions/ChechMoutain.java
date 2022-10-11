package com.interview.questions;

public class ChechMoutain {

	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 3, 2, 1};
		System.out.println(findPeekValueOfMoutian(arr));
	}
	
	static int findPeekValueOfMoutian(int[] arr) {
		int highestVal = 0;
		 
		int start = 1; // 3
		int end = arr.length-2; // 5
		
		while(start <= end) {  //  
			int mid = start + ((end - start) + 1)/ 2; // 4
			if(arr[mid] > arr[mid -1] && arr[mid] > arr[mid +1]) {
				return mid;
			}
			if(arr[mid -1] < arr[mid]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return highestVal;
	}
}

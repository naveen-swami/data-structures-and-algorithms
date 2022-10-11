package com.interview.questions;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		
	}
	//Given an unsorted array of intergers. You are also given a sum.
	//find a continous subarray which adds to a given sum

	//Input arry - arr[] = {1, 4, 20, 3, 10, 5}
	// Sum = 33
	// Output = 2 to 4 


//	time complexity - O(n2), space = O(1)
//
//	arr = 1 3 -3 -5 9 0 -6 4 10  
//	sum = 9
//
//
//
//
//	{10, 2, -2, -20, 11}, Sum = -9
//	-20 -12 -8  
//
//	-19 = 0
//	-11 = 1
//	-7 = 2
//	11 = 3
//
//	if(arr[i] == map.containsKey(arr[i]) {
//	    sop(map.get(arr[i]) + ""  + i); 
//	} 
//
//	3, 4
//
//
//	0, 4
//	sum - arr[i]
//
//	0, 3
//
//	10
//
//	you are not audiable

	//Input arry - arr[] = {1, 4, 20, 3, 10, 5}
	void findSubArrayIndexOfSum(int[] arr, int sum) {
	    int subArraySum = 0;
	    int startPointer = 0;
	    for(int i =0; i < arr.length; i++) {
	        subArraySum += arr[i];
	        while(subArraySum > sum) {
	            subArraySum -= arr[startPointer];
	            startPointer++;
	        }
	        if(subArraySum == sum) {
	            System.out.println(startPointer + " " + i);
	            return;
	        }
	    }
	    System.out.println("No subarray identified");
	}
}

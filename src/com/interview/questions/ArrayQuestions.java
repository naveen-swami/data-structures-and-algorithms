package com.interview.questions;

import java.util.HashSet;
import java.util.Set;

public class ArrayQuestions {

	public static void main(String[] args) {
		
//		int[] arr = {1, 2, 0};
//		System.out.println(isDuplicateNumberExists(arr));
		
//	    int[] arr = {2, 3, 6, 4, 5};
//		System.out.println(largestContinousLength(arr));
		
		int num = 1235;
		sumOfDigits(num);
	}
	
	public static void sumOfDigits(int num) {
		char[] numChar = String.valueOf(num).toCharArray();
		int sum = 0;
		for(char ch: numChar) {
			sum += ch - '0';
		}
		System.out.println(sum);
	}
	
	/**
	 * 
	 * find duplicate number exits in array or not. Given array 
	 * arr, 
	 * size n
	 * 0 <= arr[i] < n
	 * 
	 * example:
	 * size = 3 
	 * 1 2 1 true
	 * 1 2 2 true
	 * 1 1 1 true
	 * 0 1 2 false
	 * 
	 * @param arr
	 * @return
	 */
	static boolean isDuplicateNumberExists(int[] arr) {
		
		 boolean isZeroOccured = false;
		
	     for(int val : arr) {
	    	 int j = Math.abs(val);
	    	 if((isZeroOccured && arr[j] == 0 ) || arr[j] < 0) {
	    		 return true;
	    	 }
	    	 if(arr[j] == 0) {
	    		 isZeroOccured = true;
	    	 }
	    	 arr[j] = -arr[j];
	     }
		
		return false;
	}

static int largestContinousLength(int[] arr) {
    Set<Integer> numSet = new HashSet<>();
    for(int val : arr) {
       numSet.add(val);
     }
     
    int currentElement = arr[0]; // 7
    int privousElement = currentElement - 1; // 6
    int nextElement = currentElement + 1; // 8
    int maxLength = 1;  // 
    int max = 1;  //  2
    while(!numSet.isEmpty()) {
         if(numSet.contains(new Integer(privousElement))) {
            numSet.remove(new Integer(privousElement));
            privousElement = privousElement - 1;
            maxLength++;
         }
         else if(numSet.contains(new Integer(nextElement))) {
            numSet.remove(new Integer(nextElement));
            nextElement = nextElement + 1; // 10
            maxLength++; // 3
          }
          
          else{
             if(max < maxLength) { // 2 < 3
                  max = maxLength; // 3
               }
                   numSet.remove(Integer.valueOf(currentElement));
                   if(!numSet.isEmpty()) {
                   currentElement = numSet.iterator().next();
                   privousElement = currentElement - 1;
                   nextElement = currentElement + 1;  
                   
                  }
                  maxLength = 1;
          }
    }
    
    
           if(max < maxLength) {
                  max = maxLength;
           }
    
    return max; // 3
    
}
}
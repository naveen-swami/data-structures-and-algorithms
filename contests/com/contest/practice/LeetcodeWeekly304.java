package com.contest.practice;

import java.util.Arrays;

public class LeetcodeWeekly304 {

	public static void main(String[] args) {
//		int[] arr = {10,6,12,7,3,5};
//		int[] arr = {3,3, 5,6,6, 7, 10, 11,11,11,11,11,11,11};
		int[] arr = {34,42,20,18,26,29,23,47,3,15,45,27,14,29,46,4,39,4,
				40,12,16,18,19,17,11,25,19,30,49,10,14,41,24,20,46,37,43,36,4,3,10,18,12,39,29}; // expected = 9
		System.out.println(maximumGroups(arr));
	}
	 public static int maximumGroups(int[] grades) {
	        Arrays.sort(grades);
	        int i = 0;
	        int lastNumber = -1;
	        int group = 0;
	        int countGroup = 0;
	        while(i < grades.length && i + group < grades.length) {
	            lastNumber = grades[i];
	            group++;
	            i = group + i;
//	            if(lastNumber == grades[i]) {
	                while(i < grades.length && lastNumber == grades[i]) {
	                    i++;
	                    group++;
	                }
//	            if(countGroup > 0) {
//	            	i++;
//	            }
	            countGroup++;
	        }
	        return countGroup;
	    }
}

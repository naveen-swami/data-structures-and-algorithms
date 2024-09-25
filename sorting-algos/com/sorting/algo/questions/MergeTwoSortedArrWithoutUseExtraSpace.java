package com.sorting.algo.questions;

import java.util.Arrays;

/**
 * 
 * @author naveen
 *
 */
public class MergeTwoSortedArrWithoutUseExtraSpace {

	public static void main(String[] arg) {

		int[] arr1 = { 0, 1, 3, 9, 10, 0, 0, 0 };
		int[] arr2 = { 0, 1, 6 };

		MergeTwoSortedArrWithoutUseExtraSpace mergeTwoSortedArrObj = new MergeTwoSortedArrWithoutUseExtraSpace();
//		mergeTwoSortedArrObj.mergeTwoSortedArr(arr1, arr1.length, arr2, arr2.length);
		mergeTwoSortedArrObj.mergeTwoSortedArrOptimize(arr1, arr1.length, arr2, arr2.length);
		System.out.println(Arrays.toString(arr1));
	}
	
	/**
	 * 
	 * 
	 * Compare from back
	 * 
	 * @param arr1
	 * @param m
	 * @param arr2
	 * @param n
	 */
	void mergeTwoSortedArrOptimize(int[] arr1, int m, int[] arr2, int n) { 
		
		
		int k = m - 1;
		int i = m - n - 1;
		int j = n -1;
		
	
		while(i > 0 && j > 0) {
			if(arr1[i] > arr2[j]) {
				arr1[k--] = arr1[i--];
			} else {
				arr1[k--] = arr1[j--];
			}
		}
		
		while(j > 0) {
			arr1[k--] = arr1[j--];
		}
		
	}


	/**
	 * 
	 * // You are given two integer arrays nums1 and nums2, sorted in non-decreasing
	 * order, and two integers m and n, representing the number of elements in nums1
	 * and nums2 respectively.
	 * 
	 * //Merge nums1 and nums2 into a single array sorted in non-decreasing order.
	 * 
	 * //The final sorted array should not be returned by the function, but instead
	 * be stored inside the array nums1. To accommodate this, nums1 has a length of
	 * m + n, where the first m elements denote the elements that should be merged,
	 * and the last n elements are set to 0 and should be ignored. nums2 has a
	 * length of n.
	 * 
	 * 
	 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
	 * 
	 * Output: [1,2,2,3,5,6] //Explanation: The arrays we are merging are [1,2,3]
	 * and [2,5,6]. //The result of the merge is [1,2,2,3,5,6] with the underlined
	 * elements coming from nums1.
	 * 
	 * 
	 */
	void mergeTwoSortedArr(int[] arr1, int m, int[] arr2, int n) {

		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (m - i <= n - j) {
				arr1[i] = arr2[j];
				i++;
				j++;
			} else if (arr1[i] <= arr2[j]) {
				i++;
			} else {
				for (int k = m - (n - j - 1) - 1; k > i; k--) {
					arr1[k] = arr1[k - 1];
				}
				arr1[i] = arr2[j];
				i++;
				j++;
			}
		}
	}
	
}

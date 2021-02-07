package com.contest.web;

class Solution {
	// 5672. Check if Array Is Sorted and Rotated
	public boolean check(int[] nums) {
		int rotate = 0;
		int lastElement = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < lastElement) {
				rotate++;
			}
			lastElement = nums[i];
		}
		if (rotate == 0) {
			return true;
		} else if (rotate == 1 && nums[0] >= lastElement) {
			return true;
		} else {
			return false;
		}
	}
}

public class LeetContestWeekly227 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = { 3, 7, 10, 6, 7, 7 };
		System.out.println(solution.check(arr));
	}
}

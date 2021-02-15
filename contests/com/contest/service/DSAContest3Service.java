package com.contest.service;

import java.util.Arrays;

public class DSAContest3Service {

	// Given an array of N elements where each element is either 1 or 0. You have to
	// divide the array into maximum number of subarrays such that each element of
	// the array is in exactly one subarray such that each subarray has equal number
	// of 1's and 0's.

	public int divideArrayToMakeEqualBinaryNumber(int[] arr) {

		int countOne = 0;
		int countZero = 0;
		int countSubArray = 0;
		for (int no : arr) {
			if (no == 0) {
				countZero++;
				countOne--;
			} else {
				countOne++;
				countZero--;
			}

			if (countOne == countZero) {
				countSubArray++;
			}
		}

		return countOne == countZero ? countSubArray : -1;
	}

	// Given N coordinates on a two dimensional plane. Find the area of the smallest
	// rectangle such that all the points can lie inside or on the rectangle
	// boundary.
	// Note - the sides of rectangle should be parallel to x and y axis.

	public int smallestRectangle(int[][] cordinates) {
		int AxisXMax = 0;
		int AxisYMax = 0;
		for (int[] cordinate : cordinates) {
			if (cordinate[0] > AxisXMax) {
				AxisXMax = cordinate[0];
			}
			if (cordinate[1] > AxisYMax) {
				AxisYMax = cordinate[1];
			}
		}

		return AxisXMax * AxisYMax;
	}

}

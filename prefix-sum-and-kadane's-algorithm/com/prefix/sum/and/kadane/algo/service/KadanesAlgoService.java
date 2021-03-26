package com.prefix.sum.and.kadane.algo.service;

import java.util.Arrays;

public class KadanesAlgoService {
	
	public long maximumProfit(int[][] arr, int year) {
		int[] yearArr = new int[year+1];
		long maximumProfit = Integer.MIN_VALUE;
		
		for(int[] x : arr) {
			for(int i = x[0] ; i <= x[1]; i++) {
				yearArr[i] = yearArr[i] + x[2];
			}
		}
		long sum = 0;
		for(int i = 1; i <= year; i++) {
			sum += yearArr[i];
			if(maximumProfit < sum) {
			   maximumProfit =sum;	
			} 
			if(sum < 0) {
				sum = 0;
			}
		}
		
		return maximumProfit;	
	}

	public void getAllToy(int[] toyCostArr, int[] querys) {

		Arrays.sort(toyCostArr);

		for (int freeToys : querys) {
			int i = 0;
			int j = toyCostArr.length - 1;
			long totalCost = 0;
			while (i <= j) {
				totalCost += toyCostArr[i];
				i++;
				j = j - freeToys;
			}
			System.out.println(totalCost);
		}
	}

	public void pairProductOrExtractOrignal(int[] productArr, int size) {
		int n = (1 + (int) Math.sqrt(1 + 8 * size)) / 2;
		int[] orignalArr = new int[n];

		// ab = p0, ac= p1.............
		// orignalArr[0] = sqrt((arr[0] * arr[1]) / arr[n-1])
		// (ab * ac)/ bc = (P0 * P1 )/ Pn-1
		// a = sqrt((P0 * P1)/ Pn-1)
		orignalArr[0] = (int) Math.sqrt((productArr[0] * productArr[1]) / productArr[n - 1]);

		for (int i = 1; i < n; i++) {
			orignalArr[i] = productArr[i - 1] / orignalArr[0];
		}
		System.out.println();
		displayArr(orignalArr);

	}

	public int equilibriumPointInUnsortedArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		long rightSum = 0;
		long leftSum = 0;

		while (left < right) {

			if (leftSum < rightSum) {
				leftSum += arr[left];
				left++;
			} else {
				rightSum += arr[right];
				right--;
			}

		}
		if (leftSum == rightSum) {
			return left;
		} else {
			return -1;
		}

	}

	public long maxContiguousSum(int[] arr) {
		long maxContiguosSum = Long.MIN_VALUE;
		long sum = 0;

		for (int element : arr) {
			sum += element;
			if (sum > maxContiguosSum) {
				maxContiguosSum = sum;
			} else {
				sum = 0;
			}

		}

		return maxContiguosSum;
	}

	public void sumOfElementBeteenTwoNumber(int[] arr, int arrSize, int[][] queryArr, int querySize) {
		int[] frequencyArr = new int[100001];
		int[] cumulativeFrequency = new int[100001];
		int sum = 0;
		for (int element : arr) {
			frequencyArr[element] = frequencyArr[element] + 1;
		}
		for (int i = 0; i < frequencyArr.length; i++) {
			sum += frequencyArr[i];
			cumulativeFrequency[i] = sum;

		}

		for (int[] query : queryArr) {
			int l = query[0];
			int r = query[1];

			System.out.println(cumulativeFrequency[r] - cumulativeFrequency[l - 1]);

		}
	}

	public void displayArr(int[] arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}

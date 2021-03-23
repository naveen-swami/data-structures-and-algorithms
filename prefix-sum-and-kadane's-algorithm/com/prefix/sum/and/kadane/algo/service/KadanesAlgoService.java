package com.prefix.sum.and.kadane.algo.service;

public class KadanesAlgoService {
	
 
	 public void sumOfElementBeteenTwoNumber(int[] arr, int arrSize, int[][] queryArr, int querySize) {
		 int[] frequencyArr = new int[100001];
		 int[] cumulativeFrequency = new int[100001];
		 int sum = 0;
		 for(int element : arr) {
				 frequencyArr[element] = frequencyArr[element] +1;
		 }
		 for(int i = 0; i < frequencyArr.length ; i++) {
			 sum += frequencyArr[i];
			 cumulativeFrequency[i] = sum;
			 
		 }
		 
		 for(int[] query : queryArr) {
			 int l = query[0];
			 int r = query[1];
			 
			 System.out.println(cumulativeFrequency[r] - cumulativeFrequency[l -1]);
			 
		 }
		 
	 }
}

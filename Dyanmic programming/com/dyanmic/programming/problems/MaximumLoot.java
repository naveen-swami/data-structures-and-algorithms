package com.dyanmic.programming.problems;

public class MaximumLoot {

	public static void main(String args[]) {
		// System.out.println("test");
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		MaximumLoot test = new MaximumLoot();
		int max = test.getMax(0, arr);
		System.out.println(max);

	}

	public int getMax(int i, int[] arr) {
		if (i >= arr.length - 2) {
			return arr[i];
		}

		int max = Math.max(getMax(i+1, arr), getMax(i + 2, arr));
		
		System.out.println("MAX " + i + " " + max);
		return max;
	}

}

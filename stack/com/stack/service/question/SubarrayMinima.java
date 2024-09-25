package com.stack.service.question;

import java.util.Scanner;
import java.util.Stack;

public class SubarrayMinima {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		long arr[] = new long[size];
		for (int i = 0; i < size; i++) {
			long num = scan.nextLong();
			arr[i] = num;
			// sum = (sum + ((num * size) % mod)) % mod;
		}
		// Arrays.sort(arr);

		SubarrayMinima subarrayMinimaObj = new SubarrayMinima();
		long sum = subarrayMinimaObj.sumSubArrayMinimaOptimized(arr, size);

		System.out.println(sum);
	} 

	/**
	 * 
	 * You are given an array(Arr) of N Distinct integers. You have to find the sum
	 * of minimum element of all the subarrays (continous) in that array. See Sample
	 * for better understanding.
	 * 
	 * Input The first line of input contains N, the size of the array The second
	 * line of input contains N space-separated integers Constraints 2 ≤ N ≤ 100000
	 * 1 ≤ Arr[i] ≤ 1000000000
	 * 
	 * 
	 * @param arr
	 * @param size
	 * @return
	 */
	public long sumSubArrayMinima(long[] arr, int size) {
		long sum = 0;
		for (int i = 0; i < size; i++) {
			// sum += (arr[i] * (size - i));
			long min = Long.MAX_VALUE;
			for (int j = i; j < size; j++) {
				if (min > arr[j]) {
					min = arr[j];
				}
				sum += min;
			}
		}
		return sum;
	}
	
	public long sumOfMinimums(long[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int index = stack.pop();
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                result += (long) arr[index] * (i - prevIndex - 1);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int prevIndex = stack.isEmpty() ? -1 : stack.peek();
            result += (long) arr[index] * (n - prevIndex - 1);
        }

        return result;
    }

	public long sumSubArrayMinimaOptimized(long[] arr, int size) {
		long sum = 0;
		Stack<Integer> minimaStack = new Stack<>();
		for (int i = 0; i < size; i++) {
			while(!minimaStack.isEmpty() && arr[i] < arr[minimaStack.peek()]) {
				int currentIndex = minimaStack.pop();
				int previousIndex =  !minimaStack.isEmpty() ? minimaStack.peek() : -1;
				sum += arr[currentIndex] * (i - previousIndex - 1);
			}
			 minimaStack.push(i);
		}
		
		while(!minimaStack.isEmpty()) {
			int currentIndex = minimaStack.pop();
			int previousIndex = !minimaStack.isEmpty() ? minimaStack.peek() : -1;
			sum += arr[currentIndex] * (size - previousIndex - 1);
		}
		
		return sum;
	}

}

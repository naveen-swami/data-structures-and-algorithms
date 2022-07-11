package com.heap.service;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapService {
	
	
	 public int fillCups(int[] arr) {
	       int seconds = 0;
	       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	       
	       for(int value: arr) {
	    	   if(value > 0) {
	    	   pq.add(value);
	    	   }
	       }
	       
	       while(pq.size() > 1) {
	    	   int first = pq.poll() - 1;
	    	   int second = pq.poll() - 1;
	    	   if(first > 0) {
	    		   pq.add(first);
	    	   }
	    	   if(second > 0) {
	    		   pq.add(second);
	    	   }
	    	   seconds++;
	       }
	       if(!pq.isEmpty()) {
	    	   seconds += pq.poll();
	       }
	       
	       return seconds;
	    }


	public void kthLargestValueFromArray(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			pq.add(arr[i]); // nlogn
			if(pq.size() > k) {
				pq.poll();
			}
		}
//		while (k-- > 1 && !pq.isEmpty()) {
//			pq.poll(); // klogn
//		}
		System.out.println(pq.peek());
	}

	/**
	 * 
	 * Problem Statement Given an input stream of N integers. The task is to insert
	 * these numbers into a new stream and find the median of the stream formed by
	 * each insertion of X to the new stream.
	 * 
	 * Note: Median is the middle value in an ordered integer list. If the size of
	 * the list is even, there is no middle value. So the median is the mean of the
	 * two middle values. Input User Task: Since this will be a functional problem,
	 * you don't have to take input. You just have to complete the function
	 * getMedian() that takes X as parameter.
	 * 
	 * Constraints: 1 <= N <= 10^5 1 <= X <= 10^5 Output You need to return the
	 * median. Example Sample Input: 4 5 15 1 3
	 * 
	 * Sample Output: 5.0 10.0 5.0 4.0
	 * 
	 * Explanation: Testcase 1: Flow in stream : 5, 15, 1, 3 5 goes to stream -->
	 * median 5.0 (5) 15 goes to stream --> median 10.0 (5, 15) 1 goes to stream -->
	 * median 5.0 (5, 15, 1) 3 goes to stream --> median 4.0 (5, 15, 1, 3)
	 * 
	 * @param arr
	 * @param size
	 * @param k
	 */
	public void getMedianOfArray(int[] arr, int size) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 5
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 2

		for (int i = 0; i < size; i++) {
			double meadian = 0;
			int num = arr[i]; // 1
			if (maxHeap.isEmpty()) {
				maxHeap.add(num);
				meadian = num;
				System.out.println(meadian); // 5
				continue;
			}

			if (minHeap.size() < maxHeap.size()) {
				if (num > maxHeap.peek()) {
					minHeap.add(num);
				} else {
					minHeap.add(maxHeap.poll());
					maxHeap.add(num);
				}
				meadian = (double) (minHeap.peek() + maxHeap.peek()) / 2;
				System.out.println(meadian);
			} else if (minHeap.size() > maxHeap.size()) {
				if (num < minHeap.peek()) {
					maxHeap.add(num);
				} else {
					maxHeap.add(minHeap.poll());
					minHeap.add(num);
				}
				meadian = (double) (minHeap.peek() + maxHeap.peek()) / 2;
				System.out.println(meadian);
			} else {
				if (num <= maxHeap.peek()) {
					maxHeap.add(num);
					meadian = maxHeap.peek();
					System.out.println(meadian);
				} else {
					minHeap.add(num);
					meadian = minHeap.peek();
					System.out.println(meadian);
				}
			}
		}

	}

	/**
	 * https://my.newtonschool.co/playground/code/q755xzjhovqr/
	 * 
	 * Problem Statement Given an array of n positive integers. We are required to
	 * write a program to print the maximum product of k integers of the given
	 * array. Input The input line contains T, denoting the number of testcases.
	 * Each testcase contains 2 lines. First line contains size of array N and K.
	 * Second line contains elements of array
	 * 
	 * Constraints: 1 <= T <= 50 1 <= N <= 100 1 <= K <= min(N,10) 0 <= A[i] <= 100
	 * 
	 * It is guaranteed that answer will be less than 10^18. Output For each
	 * testcase you need to print the maximum product of K integers Example Sample
	 * Input: 2 5 3 2 4 7 9 6 4 2 12 14 11 7
	 * 
	 * Sample Output: 378 168
	 * 
	 * @param arr
	 * @param size
	 * @param k
	 */
	public void maximumProductOfKIntegerArray(int[] arr, int size, int k) {
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); // max heap
		for (int i = 0; i < size; i++) {
			maxPQ.add(arr[i]);
		}

		long prod = 1;
		while (k-- > 0 && !maxPQ.isEmpty()) {
			prod *= maxPQ.poll();
		}

		System.out.println(prod);
	}

	/**
	 * 
	 * * You are given N ropes of L[i] lengths, you need to connect these ropes into
	 * one rope. The cost to connect two ropes is equal to sum of their lengths. The
	 * task is to connect the ropes with minimum cost.
	 *
	 * 
	 * Sample Input: 2 4 4 3 2 6 5 4 2 7 6 9
	 * 
	 * Sample Output: 29 62
	 * 
	 * Explanation: For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We
	 * can connect the ropes in following ways. 1) First connect ropes of lengths 2
	 * and 3. Now we have three ropes of lengths 4, 6 and 5. 2) Now connect ropes of
	 * lengths 4 and 5. Now we have two ropes of lengths 6 and 9. 3) Finally connect
	 * the two ropes and all ropes have connected.
	 * 
	 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized
	 * cost for connecting ropes. Other ways of connecting ropes would always have
	 * same or more cost. For example, if we connect 4 and 6 first (we get three
	 * strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and
	 * 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38
	 *
	 *
	 * @param arr
	 * @param size
	 * 
	 * @return void
	 */
	public void minimumCostOfRopes(int[] arr, int size) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default it is min heap
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}

		int minimumCost = 0;
		while (pq.size() > 1) {
			int firstValue = pq.remove();
			int secondValue = pq.remove();

			int sum = firstValue + secondValue;
			minimumCost += sum;
			pq.add(sum);
		}

		System.out.println(minimumCost);

	}

}

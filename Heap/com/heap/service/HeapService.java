package com.heap.service;

import java.util.PriorityQueue;

public class HeapService {

//	Minimum Cost of ropes
	
	/**
	 * 
	 * 	 * You are given N ropes of L[i] lengths, you need to connect these ropes into
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

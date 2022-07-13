package com.deque.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;



public class DequeService {
	
	/**
	 * {@link} https://leetcode.com/problems/sum-of-total-strength-of-wizards/
	 * 
	 * @param strength
	 * @return
	 */
	 public int totalStrength1(int[] arr) {
	        int n = arr.length;
	        int m = (int) 1e9 + 7;
	        Deque<Integer> rs = new ArrayDeque<>();
	        Deque<Integer> ls = new ArrayDeque<>();
	        int[] right = new int[n];
	        int[] left = new int[n];
	        int[] pre = new int[n];
	        int[] suf = new int[n];
	        int[] ppre = new int[n];
	        int[] ssuf = new int[n];
	        
	        Arrays.fill(right, n-1);
	        for(int i = 0, j = n-1; i <n; i++, j--) {
	            
	            while(!rs.isEmpty() && arr[i] < arr[rs.peek()]) {
	                right[rs.pop()] = i -1;
	            }
	            
	        
	        
	        while(!ls.isEmpty() && arr[j] <= arr[ls.peek()]) {
	            left[ls.pop()] = j+1;
	        }
	        rs.push(i);
	        ls.push(j);
	        pre[i] = i == 0 ? arr[i] : (arr[i] + pre[i-1]) % m;
	        
	        suf[j] = i == 0 ? arr[j] : (arr[j] + suf[j+1]) % m;
	        
	        ppre[i] = i == 0 ? pre[i] : (pre[i] + ppre[i-1]) % m;
	        
	        ssuf[j] = i == 0 ? suf[j] : (suf[j] + ssuf[j+1]) % m;
	         
	        }
	        
	        long ans =0;
	        
	        for(int i =0; i <n; i++) {
	            long lval = ((1L *(i -left[i]+1) * pre[i] % m - (i==0 ? 0: (ppre[i-1] - (left[i] <= 1? 0 : ppre[left[i] - 2]))) + m )%m) * (right[i] - i+1)%m;
	            
	            long rval = ((1L *(right[i] - i +1) * suf[i] % m - (i== n-1 ? 0: (ssuf[i+1] - (right[i] >= n-2? 0 : ssuf[right[i] + 2]))) + m )%m) * ( i - left[i] + 1)%m;
	            
	            long mid = (1L * (i -left[i] + 1) * (right[i] - i +1)) %m *arr[i] %m;
	            ans = (ans + (lval + rval - mid + m) % m * arr[i] %m + m) %m;
	        }
	        return (int) ans;
	    }
	
	/**
	 * 
	 * {@link} https://leetcode.com/problems/sum-of-total-strength-of-wizards/
	 * 
	 * @param strength
	 * @return
	 */
	 public int totalStrength(List<Integer> a) {
		 
	        int n = a.size();
	        int m = (int) 1e9 + 7;
	        Deque<Integer> rs = new ArrayDeque<>();
	        Deque<Integer> ls = new ArrayDeque<>();
	        int[] right = new int[n];
	        int[] left = new int[n];
	        int[] pre = new int[n];
	        int[] suf = new int[n];
	        int[] ppre = new int[n];
	        int[] ssuf = new int[n];
	        
	        Arrays.fill(right, n-1);
	        for(int i = 0, j = n-1; i <n; i++, j--) {
	            
	            while(!rs.isEmpty() && a.get(i) < a.get(rs.peek())) {
	                right[rs.pop()] = i -1;
	            }
	            
	        
	        
	        while(!ls.isEmpty() && a.get(j) <= a.get(ls.peek())) {
	            left[ls.pop()] = j+1;
	        }
	        rs.push(i);
	        ls.push(j);
	        pre[i] = i == 0 ? a.get(i) : (a.get(i) + pre[i-1]) % m;
	        
	        suf[j] = i == 0 ? a.get(j) : (a.get(j) + suf[j+1]) % m;
	        
	        ppre[i] = i == 0 ? pre[i] : (pre[i] + ppre[i-1]) % m;
	        
	        ssuf[j] = i == 0 ? suf[j] : (suf[j] + ssuf[j+1]) % m;
	         
	        }
	        
	        long ans =0;
	        
	        for(int i =0; i <n; i++) {
	            long lval = ((1L *(i -left[i]+1) * pre[i] % m - (i==0 ? 0: (ppre[i-1] - (left[i] <= 1? 0 : ppre[left[i] - 2]))) + m )%m) * (right[i] - i+1)%m;
	            
	            long rval = ((1L *(right[i] - i +1) * suf[i] % m - (i== n-1 ? 0: (ssuf[i+1] - (right[i] >= n-2? 0 : ssuf[right[i] + 2]))) + m )%m) * ( i - left[i] + 1)%m;
	            
	            long mid = (1L * (i -left[i] + 1) * (right[i] - i +1)) %m *a.get(i) %m;
	            ans = (ans + (lval + rval - mid + m) % m * a.get(i) %m + m) %m;
	        }
	        return (int) ans;
	    }

	public void maximumOfAllSubArray(int[] arr, int k) {

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i >= k) {
				System.out.print(arr[deque.peekFirst()] + " ");
				if (deque.peekFirst() <= i - k) {
					deque.removeFirst();
				}
			}
			while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
				deque.removeLast();
			}
			deque.add(i);
		}

		System.out.println(arr[deque.peekFirst()]);

	}

	/**
	 * You are given an integer n. Initially you have an empty string. You need to
	 * construct the string of length n with the following rules: 1. Insert the
	 * first character in the beginning of string, the second in the end, the third
	 * in the beginning, fourth in the end, and so on. 2. The first character should
	 * be 'a', followed by 'b', 'c', and so on. 'z' will be followed by 'a'.
	 */
	public String addAlphabetStartAndEnd(int size) {
		StringBuilder str = new StringBuilder();

		// char a = 'a';
		// System.out.println(a + 1);
		char a = 97;
		// System.out.println((char) a);

		for (int i = 0; i < size; i = i + 2) {
			str = str.insert(0, (char) (a + i % 26));
			if (i != size - 1) {
				str = str.append((char) (a + (i + 1) % 26));
			}
		}

		return str.toString();
	}

	public long sumOfMinimumAndMaximumElementsOfSubarrays(int[] arr, int k) {
		long sum = 0;
		int mod = 1000000007;
		Deque<Integer> minDeque = new LinkedList<>();
		Deque<Integer> maxDeque = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[i]) {
				minDeque.removeLast();
			}
			while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[i]) {
				maxDeque.removeLast();
			}
			minDeque.add(i);
			maxDeque.add(i);
		}

		for (int i = k; i < arr.length; i++) {
			sum = (sum + arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()]);
			if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k) {
				minDeque.removeFirst();
			}
			if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k) {
				maxDeque.removeFirst();
			}
			while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[i]) {
				minDeque.removeLast();
			}
			while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[i]) {
				maxDeque.removeLast();
			}
			minDeque.add(i);
			maxDeque.add(i);
		}

		sum = (sum + arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()]);
		return sum;
	}

	public long minSubArrayProdcut(int[] arr, int k) {
		long product = 1;
		int mod = 1000000007;
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			if (!deque.isEmpty() && i >= k) {
				product = (product * arr[deque.peekFirst()] % mod) % mod;
				if (deque.peekFirst() <= i - k) {
					deque.removeFirst();
				}
			}
			while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
				deque.removeLast();
			}
			deque.add(i);

		}
		product = (product * arr[deque.pollFirst()] % mod) % mod;

		return product;
	}
}

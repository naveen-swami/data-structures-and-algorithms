package com.recursion.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RecurstionService {

//	Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
	// numArr = [1, 2, 3];
	public List<List<Integer>> permute(int[] numArr) {

		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(numArr);
		getPermutation(new LinkedList<>(), numArr, new boolean[numArr.length], result);
		return result;
	}

	public void getPermutation(List<Integer> permuation, int[] numArr, boolean[] usedArr, List<List<Integer>> result) {

		if (permuation.size() == numArr.length) {
			result.add(new LinkedList<>(permuation));
			return;
		}

		for (int i = 0; i < numArr.length; i++) {
			if (usedArr[i] || i > 0 && numArr[i] == numArr[i - 1] && !usedArr[i - 1]) {
				continue;
			}
			usedArr[i] = true;
			permuation.add(numArr[i]);
			getPermutation(permuation, numArr, usedArr, result);
			usedArr[i] = false;
			permuation.remove(permuation.size() - 1);
		}

	}

	public long getCandyCrushCost(long n) {
		if (n < 1) {
			return 0;
		}
		long group = n / 3;
		if (n % 3 > 0) {
			group++;
		}
		return group * group + getCandyCrushCost(n - group);
	}

	public void towerOfHanoi(int disks, String src, String helper, String des) {
		if (disks == 0) {
			return;
		}

		towerOfHanoi(disks - 1, src, des, helper);

		System.out.println(disks + ":" + src + "->" + des);

		towerOfHanoi(disks - 1, helper, src, des);
	}

	public int happBallon(long[] intArr) {
		int happyBallon = 0;

		for (int i = 1; i <= intArr.length; i++) {
			if (i % 2 == 0) {
				if (intArr[i - 1] % 2 == 0) {
					happyBallon++;
				}
			} else {
				if (intArr[i - 1] % 2 != 0)
					happyBallon++;
			}

		}

		return happyBallon;
	}

	public int coinFlip(String values) {
		int roate = 0;
		for (int i = 0; i < values.length(); i++) {
			if (Character.isDigit(values.charAt(i))) {
				if ((values.charAt(i) & 1) != 1) {
					roate++;
				}
			} else if (values.charAt(i) == 'a' || values.charAt(i) == 'e' || values.charAt(i) == 'i'
					|| values.charAt(i) == 'o' || values.charAt(i) == 'u') {
				roate++;
			}

		}
		return roate;
	}

	public void printNumInDescresingOrder(int num) {
		if (num == 0) {
			// System.out.print(num);
			return;
		} else {
			System.out.print(num + " ");
			printNumInDescresingOrder(--num);
		}
	}

	public void printNumInIncreasingOrder(int num) {
		if (num == 0) {
			// System.out.print(num + " ");
			return;
		}
		printNumInIncreasingOrder(num - 1);
		System.out.print(num + " ");
	}

	public void printNumDesAndIncOrder(int num) {
		if (num == 1) {
			System.out.print(num + " ");
			return;
		}
		System.out.print(num + " ");
		printNumDesAndIncOrder(num - 1);
		System.out.print(num + " ");
	}

}

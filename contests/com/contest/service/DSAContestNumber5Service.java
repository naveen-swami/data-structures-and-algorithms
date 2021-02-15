package com.contest.service;

import java.util.HashSet;
import java.util.Set;

public class DSAContestNumber5Service {

	public static int modificationsInArrayAToMakeArrBItsSubarray(int[] arrA, int[] arrB) {
		int higestMatchSubString = 0;
		for (int i = 0; i < arrB.length; i++) {
			int matchSubString = 0;
			int indexOfB = i;
			for (int j = 0; j < arrA.length; j++) {
				if (indexOfB >= arrB.length) {
					indexOfB = i;
					matchSubString = 0;
				}
				if (j >= indexOfB && arrA[j] == arrB[indexOfB]) {
					matchSubString++;
					if (higestMatchSubString < matchSubString) {
						higestMatchSubString = matchSubString;
					}
				}
				indexOfB++;
			}
		}
		return arrB.length - higestMatchSubString;
	}

	public static int modificationsInArrayAToMakeArrBItsSubarray2Way(int[] arrA, int[] arrB) {
		int higestMatchSubString = 0;

		int indexOfB = 0;
		for (int i = 0; i < arrA.length; i++) {
			indexOfB = indexOfB % arrB.length;
			
		}

		for (int i = 0; i < arrB.length; i++) {
			int matchSubString = 0;
			for (int j = 0; j < arrA.length; j++) {
				if (indexOfB >= arrB.length) {
					indexOfB = i;
					matchSubString = 0;
				}
				if (j >= indexOfB && arrA[j] == arrB[indexOfB]) {
					matchSubString++;
					if (higestMatchSubString < matchSubString) {
						higestMatchSubString = matchSubString;
					}
				}
				indexOfB++;
			}
		}
		return arrB.length - higestMatchSubString;
	}

	public static int logestSubStringContainCharA(String str) {
		int longestSubString = 0;
		int continuosA = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {
				continuosA++;
				if (continuosA > longestSubString) {
					longestSubString = continuosA;
				}
			} else {
				continuosA = 0;
			}
		}
		return longestSubString;
	}

	public static boolean isRed(String str) {
		char[] strChar = str.toCharArray();
		Set<Character> isRed = new HashSet<>();
		for (int i = 0; i < strChar.length; i++) {
			if (strChar[i] == 'r' || strChar[i] == 'e' || strChar[i] == 'd') {
				isRed.add(strChar[i]);
				if (isRed.size() == 3) {
					return true;
				}
			}
		}

		return false;
	}

}

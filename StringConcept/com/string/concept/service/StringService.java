package com.string.concept.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringService {

	public int isAllAlphabetPresent(String str) {
		str = str.toLowerCase();
		int countLetter = 0;
		boolean[] visitedAlphabet = new boolean[26];
		if (str.length() < 26) {
			return 0;
		}
		for (Character ch : str.toCharArray()) {
			int index = ch - 'a';
			if (!visitedAlphabet[index]) {
				visitedAlphabet[index] = true;
				countLetter++;
				if (countLetter == 26) {
					return 1;
				}
			}
		}

		return countLetter == 26 ? 1 : 0;
	}

	public String flamesGame(String str1, String str2) {

		// If obtained value is 1, output "Friends"
		// If obtained value is 2, output "Love"
		// If obtained value is 3, output "Affection"
		// If obtained value is 4, output "Marriage"
		// If obtained value is 5, output "Enemy"
		// If obtained value is 0, output "Siblings"

		// switch (getLenthAfterRemovingCommonChar(str1, str2) % 6) {
		switch (getLenthAfterRemovingCommonChar2ndWay(str1, str2) % 6) {

		case 0:
			return "Siblings";
		case 1:
			return "Friends";
		case 2:
			return "Love";
		case 3:
			return "Affection";
		case 4:
			return "Marriage";
		case 5:
			return "Enemy";
		default:
			return null;
		}

	}

	public int getLenthAfterRemovingCommonChar2ndWay(String str1, String str2) {
		int[] alphabet = new int[26];

		int commonElements = 0;
		for (Character ch : str1.toCharArray()) {
			int index = ch - 97; // or ch - 'a';
			alphabet[index] = alphabet[index] + 1;
		}

		for (Character ch : str2.toCharArray()) {
			int index = ch - 'a';
			if (alphabet[index] > 0) {
				commonElements++;
				alphabet[index] = alphabet[index] - 1;
			}
		}

		return (str1.length() + str2.length()) - (commonElements * 2);
	}

	public int getLenthAfterRemovingCommonChar(String str1, String str2) {

		int commonElements = 0;
		Map<Character, Integer> str1Map = new HashMap<>();

		for (Character ch : str1.toCharArray()) {
			str1Map.put(ch, str1Map.getOrDefault(ch, 0) + 1);
		}

		for (Character ch : str2.toCharArray()) {
			if (str1Map.containsKey(ch)) {
				int value = str1Map.get(ch);
				if (value == 1) {
					str1Map.remove(ch);
				} else {
					str1Map.put(ch, value - 1);
				}
				commonElements++;
			}
		}

		return (str1.length() + str2.length()) - (commonElements * 2);
	}

	public String compressString(String str) {
		String compressString = new String();

		Map<Character, Integer> compressStringMap = new HashMap<>();

		// compressStringMap.put(str.charAt(0), 1);
		// for(int i = 1; i< str.length(); i++) {
		//
		// }

		for (Character ch : str.toCharArray()) {
			if (compressStringMap.containsKey(ch)) {
				compressStringMap.put(ch, compressStringMap.get(ch) + 1);
			} else if (!compressStringMap.isEmpty()) {
				Entry<Character, Integer> entry = compressStringMap.entrySet().iterator().next();
				compressString += entry.getKey().toString() + entry.getValue();
				compressStringMap.clear();
				compressStringMap.put(ch, 1);
			} else {
				compressStringMap.put(ch, 1);
			}
		}

		if (!compressStringMap.isEmpty()) {
			Entry<Character, Integer> entry = compressStringMap.entrySet().iterator().next();
			compressString += entry.getKey().toString() + entry.getValue();
		}

		return compressString;
	}

	public boolean isItDalindrome(String str) {

		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j >= 0; j--) {
				if (str.charAt(i) == str.charAt(j) && isItPalindrome(str.substring(i, j + 1))) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean isItPalindrome(String str) {

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public void printAllPermutation(String str, String output) {
		if (str.isEmpty()) {
			System.out.println(output);
		}

		for (int i = 0; i < str.length(); i++) {
			printAllPermutation(str.substring(0, i) + str.substring(i + 1), output + str.charAt(i));
		}
	}

	public int check2Rotation(String str1, String str2) {

		if (str2.length() == 1) {
			if (str1.equals(str2)) {
				return 1;
			}
			return 0;
		}
		String clockWise = str2.substring(str2.length() - 2) + str2.substring(0, str2.length() - 2);
		String antiClockWise = str2.substring(2) + str2.substring(0, 2);
		if (str1.equals(clockWise) || str1.equals(antiClockWise)) {
			return 1;
		}

		return 0;
	}
}

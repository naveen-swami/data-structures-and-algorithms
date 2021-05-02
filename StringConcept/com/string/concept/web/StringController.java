package com.string.concept.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.string.concept.service.StringService;

public class StringController {

	static Scanner scanner = new Scanner(System.in);
	static StringService stringService = new StringService();

	public static void main(String[] args) {

		System.err.println(stringService.getFirstNonRepChar("intteligence"));
//		System.err.println(stringService.divide(113, 56));
//		String str = scanner.nextLine();
//		 String str2 = scanner.nextLine();

//		System.out.println(stringService.isOneStringSubStringOfPermutationOfAnotherStirng(str, str2, ""));
//		stringService.printAllSubString(str);
//		System.out.println(stringService.isAllAlphabetPresent(str));
		// System.out.println(stringService.flamesGame(str, str2));

		// System.out.println(stringService.compressString(str));
		// System.out.println(stringService.isItDalindrome(str1));

		// char[] strArr = str1.toCharArray();
		// Arrays.sort(strArr);
		// str1 = String.valueOf(strArr);

//		 stringService.printAllPermutation(str, "");
		// System.out.println(stringService.check2Rotation(str1, str2));

	}
}

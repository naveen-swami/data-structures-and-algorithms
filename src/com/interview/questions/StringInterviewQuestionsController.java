package com.interview.questions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInterviewQuestionsController {

	private StringInterviewQuestionsController(Object o) {
		System.out.println("Object");
	}

	private StringInterviewQuestionsController(Integer i) {
		System.out.println("Integer");
	}

	public static void main(String[] args) {

		new StringInterviewQuestionsController(null); // call Integer method because overload methods call subClass of
														// class so, here Integer is subclass of Object class

		String n3 = null;
		//System.out.println(n3.equals(null)); // NPE
		String n = new String("a"); // 010222
		String n1 = new String("a");// 012345
		System.out.println(n == n1); // false

		String s1 = "Naveen"; // stored at 001
		String s2 = "Swami"; // stored at 002

		String s3 = "Naveen"; // stored at 001

		System.out.println(s1 == s3); // compare memory locations ( 001 == 001 ) // true
		System.out.println(s1.equals(s3)); // compare values ( Naveen == Naveen ) // true

		String s4 = new String("Naveen"); // stored at 003
		System.out.println(s1 == s4); // compare memory locations ( 001 == 003 ) // false
		System.out.println(s1.equals(s4)); // compare values ( Naveen == Naveen ); / / true

		String s5 = new String("Naveen"); // stored at 004
		System.out.println(s5 == s4); // compare memory locations ( 004 == 003 ) // false
		System.out.println(s5.equals(s4)); // compare values ( Naveen == Naveen ); // true;

		int value = 65;
		int ch = 'a';
		System.out.println((char) (ch + 1));

		System.out.println(".........................................");
		int i = 0;
		for (;;) {
			System.out.println(i);
			i++;
			if (i == 10) {
				break;
			}
		}
		System.out.println("--------------------------------------");

		String str = "FREQ=DAILY;COUNT=8";
		Pattern p = Pattern.compile("\\bCOUNT=([^;]+)(;|$)");
		Matcher m = p.matcher(str);

		if (m.find()) {
			System.err.println(m.group(1));
		}
	}

}

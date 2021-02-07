package com.interview.questions;

public class StringInterviewQuestionsController {

	public static void main(String[] args) {
		String s1 = "Naveen"; // stored at 001
		String s2 = "Swami"; // stored at 002

		String s3 = "Naveen"; // stored at 001

		System.out.println(s1 == s3); // compare memory locations ( 001 == 001 ) // true
		System.out.println(s1.equals(s3)); // compare values ( Naveen == Naveen ) // true

		String s4 = new String("Naveen"); // stored at 003
		System.out.println(s1 == s4); // compare memory locations ( 001 == 003 ) // false
		System.out.println(s1.equals(s4)); // compate values ( Naveen == Naveen ); / / true

		String s5 = new String("Naveen"); // stored at 004
		System.out.println(s5 == s4); // compare memory locations ( 004 == 003 ) // false
		System.out.println(s5.equals(s4)); // compate values ( Naveen == Naveen ); // true;
		
		int value = 65;
		int ch = 'a';
		System.out.println((char) (ch + 1));
		
		System.out.println(".........................................");
		int i = 0;
		for(;;) {
			System.out.println(i);
			i++;
			if(i == 10) {
				break;
			}
		}

	}

}

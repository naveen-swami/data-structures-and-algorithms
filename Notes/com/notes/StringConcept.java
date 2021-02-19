package com.notes;
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
                      // Your code here
		Scanner scn = new Scanner(System.in);
		// String str = "problem";
		// //String str = scn.nextLine();
		// int strlength = str.length();
	 	// String str1 = "this is our first problem";
		// //String str1 = scn.next();
		// int str1length = str1.length();

		// String str2 = new String("This is our new string");
		// //String str2 = scn.nextLine();
		// int str2length = str2.length();

		String str  = "This is a string";
		char ch = str.charAt(0);
		char ch2 = str.charAt(2);
		System.out.println(str);
		System.out.println(ch);
		System.out.println(ch2);
		String s2 = str.substring(2, 4); //gives us the string from start to end-1 index
		System.out.println(s2);
		String s3 = str.substring(3);
		System.out.println(s3);
		
		String s4 = str.substring(2, 2);
		System.out.println(s4);

		String str1 = "this is our code";
		String[] strArr = str1.split("o");
		for(int i=0; i<strArr.length; i++){
			System.out.println(strArr[i]);
		}


		System.out.println("Abc" + 10);
		System.out.println("Abc" + 10 + 20);
		System.out.println(10 + 20 +"Abc");
		// arr[0] //get element at 0th index
		// arr[2] = 5; //set or update an element at 2nd index

		//System.out.println(strlength);

		// System.out.println(str1);
		// System.out.println(str1length);
		// System.out.println(str2);
		// System.out.println(str2length);


	}
}

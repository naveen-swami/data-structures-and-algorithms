package com.testing;

import java.util.HashMap;
import java.util.Map;

public class HasingImp {
	public static void main(String[] args) {

//		store:
//
//			1. variable names
//				a. int stu0 = 10
//				b. int stu1 = 12
//				c. int stu2 = 18
//				d. int stu3 = 20

//		0 -> 10
//		1 -> 12
//		2 -> 18
//		3 -> 20

		int stu0 = 10;
		int stu1 = 12;
		int stu2 = 18;
		int stu3 = 20;
		
		//prob: difficult to manage indivisual student, not good practie of programming
		
//		2. Array
		
			int[] studnetMarkArr = new int[] {10, 12, 18, 20};
			
//			starting 10
	//		10-> 15
	//		11-> 16
	//		12-> 19
	//		13-> 17
	//		14-> 20
			
//			0 
//		    10 - 10 = 0
//			100000 - 10 = 4
			
			int[] studnetMarkArr1 = new int[] {15, 16, 19, 17, 20};
			System.out.println("roll no 10 marks = " + studnetMarkArr1[14-10]);
			
			

			//		10-> 15
			//		16-> 16
			//		20-> 19
			//		3-> 17
			//		5-> 20
			
			int[] studnetMarkArr2 = new int[] {15, 16, 19, 17, 20};
			
			// we cann't store these data into array because difficult to fetch student indivisual marks
			
			
			System.out.println("roll no 5 marks = " + studnetMarkArr1[16]);
		
		
			Map<Integer, Integer> mp = new HashMap<>();
			
		
		

	}
}

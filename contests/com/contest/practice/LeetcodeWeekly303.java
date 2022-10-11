package com.contest.practice;

import java.util.Date;

public class LeetcodeWeekly303 {

	public static void main(String[] args) {
		Date date = new Date();
		int milliTime = 1234;
		
		if(milliTime < 0) {
			milliTime *= -1;
		}
		
		int a = milliTime - (milliTime / 100 * 100);
		System.out.println(a);
		

	}

}

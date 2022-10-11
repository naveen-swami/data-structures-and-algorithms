package com.interview.questions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ProblemQuesiton {

	
	public static void main(String[] args) {
		
//		[4:05 pm] Harsha Vardhan Bommareddy (CW) (Guest)
//	    Write a java program to find the first repeated character in the given string
//	​[4:06 pm] Harsha Vardhan Bommareddy (CW) (Guest)
//	    Input: Java is cool!
		
		String str = "Java is cool!";
		System.out.println(firstRepeatedChar(str));

	}
	
	static char firstRepeatedChar(String str) {
		
//		List<Character> list = Arrays.asList(str.toCharArray());
//		Arrays.asList(str.toCharArray()).forEach(it => {
//			
//		});
		
//		int[] charArr = new int[26];
		Set<Character> charSet = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				continue;
			}
			if(charSet.contains(str.charAt(i))) {
				return str.charAt(i);
			}
			charSet.add(str.charAt(i));
		}
		
		return ' '; 
	}
}

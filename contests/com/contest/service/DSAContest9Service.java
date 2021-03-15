package com.contest.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DSAContest9Service {
	
	public static int mergeTreeCost(List<List<Integer>> edgeList, int nodes) {
		int minCost = 0;
		
		int lastEelement = edgeList.get(edgeList.size()).get(1);
		for(int i = lastEelement +1 ; i <= nodes; i++) {
			List<Integer> newList =  new LinkedList<>();
		  edgeList.add(newList);
		}
		List<Integer> adj[] = new LinkedList[5];
		adj[0] = new LinkedList<>();
 		while(edgeList.size() != 1) {
			
		}
		
		return minCost;
	}

	public static String changeIntoPseudoLatinWord(String str) {
		
//		-a -as
//		-i, -y -ios
//		-l -les
//		-n, -ne -anes
//		-o -os
//		-r -res
//		-t -tas
//		-u -us
//		-v -ves
//		-w -was
		
		//StringBuffer strBuffer = new StringBuffer(str);
		int index = str.length() -1;
		if(str.charAt(index) == 'a') {
			str += "s";
		} else if(str.charAt(str.length() -1) == 'i' || str.charAt(str.length() -1) == 'y') {
			str = str.substring(0, index) + "ios";
		} else if(str.charAt(str.length() -1) == 'l') {
			str += "es";
		} else if(str.charAt(str.length() -1) == 'n' ) {
			str = str.substring(0, index) + "anes";
		} else if(str.subSequence(str.length() -2, str.length()).equals("ne")){
			str = str.substring(0, index -1) + "anes";
		}
			else if(str.charAt(str.length() -1) == 'o') {
			str += "s";
		} else if(str.charAt(str.length() -1) == 'r') {
			str += "es";
		} else if(str.charAt(str.length() -1) == 't') {
			str += "as";
		} else if(str.charAt(str.length() -1) == 'u') {
			str += "s";
		} else if(str.charAt(str.length() -1) == 'v') {
			str += "es";
		} else if(str.charAt(str.length() -1) == 'w') {
			str += "as";
		} else {
			str += "us";
		}
		
       return str;
	}

	public static int countEvenPlaceVowel(String str) {
		int countEvenPlaceVowel = 0;
		for (int i = 1; i < str.length(); i = i + 2) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				countEvenPlaceVowel++;
			}
		}
		return countEvenPlaceVowel;
	}
}

package com.contest.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DSASurpiseContestService {

   public	static int luckyBoys(long[] toySize, long[] boySize, int totalToys, int totalBoys, long k) {
		int maxLuckyBoys = 0;
		Arrays.sort(boySize);
		List<long[]> boyList = Arrays.asList(boySize);
//		Collections.sort(boyList,);
//		HashSet<long[]> boySet = new HashSet<>(Arrays.asList(boySize));
		//Arrays.sort(boySize);
		long minValue = Long.MIN_VALUE;
		for (long toy : toySize) {
			 
			int i = 0;
			int j = boyList.size() -1;
			
			while(i < j) {
			    int mid = i + (j -1) /2;
//			    if(mid)
			}
			
			
//			for (int j = 0; j < totalBoys; j++) {
//				if (boySize[j] > 0 && Math.abs(toy - boySize[j]) <= k) {
//					maxLuckyBoys++;
//					boySize[j] = minValue;
//				}
//			}
		}

		return maxLuckyBoys;
	}
}

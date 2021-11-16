package com.contest.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.two.pointer.and.three.pointer.service.TwoPointerService;

public class DSASurpiseContestService {

	public static int luckyBoys(long[] toySizeArr, long[] boySizeArr, int totalToys, int totalBoys, long k) {
		int maxLuckyBoys = 0;
		Arrays.sort(boySizeArr);
		Arrays.sort(toySizeArr);
	    TwoPointerService twoPointerService = new TwoPointerService();
	    Long[] toySizeLongArr = new Long[totalToys];
	    Long[] boySizeLongArr = new Long[totalBoys];
	    for(int i =0; i< totalToys ; i++) {
	    	toySizeLongArr[i] = toySizeArr[i];
	    }
	    for(int i =0; i< totalBoys ; i++) {
	    	boySizeLongArr[i] = boySizeArr[i];
	    }
	    twoPointerService.displayArray(boySizeLongArr);
	    twoPointerService.displayArray(toySizeLongArr);
		int boy = 0;
		for (long toy : toySizeArr) {
			while (boy < totalBoys && boySizeArr[boy] < toy + k && Math.abs(toy - boySizeArr[boy]) > k) {
				boy++;
			}
			if (boy < totalBoys) {
				long boySize = boySizeArr[boy];
				if (Math.abs(toy - boySize) <= k) {
					
				maxLuckyBoys++;
				boy++;
				}
			}

			// for (int j = 0; j < totalBoys; j++) {
			// if (boySize[j] > 0 && Math.abs(toy - boySize[j]) <= k) {
			// maxLuckyBoys++;
			// boySize[j] = minValue;
			// }
			// }
		}

		return maxLuckyBoys;
	}
}

package com.contest.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.IntStream;

public class LeetContest42 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,2};
        System.out.println(sumOfUnique1(arr));
	}
	
	static int sumOfUnique1(int[] nums) {
        int[] cnt = new int[101];
        IntStream.of(nums).forEach(n -> 
        ++cnt[n]);
        return IntStream.range(1, 101).filter(i -> cnt[i] == 1).sum();
    }

	static int sumOfUnique(int[] nums) {
		//Arrays.sort(nums);
		HashMap<Integer, Boolean> arrValuesMap = new HashMap<>();
        int sum = 0;
        int currentElement = nums[0];
        for(int i = 0; i< nums.length ; i++)
        {
           if(arrValuesMap.containsKey(nums[i])) {
        	   arrValuesMap.put(nums[i], true);
           } else {
           arrValuesMap.put(nums[i], false);
           }
        }
        
       return arrValuesMap.entrySet().stream().filter(it -> !it.getValue()).mapToInt(it -> it.getKey()).sum();       
//        for(Integer s : arrValuesMap.keySet())
//        {
//        	if(!arrValuesMap.get(s)) {
//        		sum +=  s;
//        	}
//        }
//        return sum;
    }
	

}

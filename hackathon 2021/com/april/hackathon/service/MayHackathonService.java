package com.april.hackathon.service;

public class MayHackathonService {

	public static void average(long[] arr) {
		double sum = 0;
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = (arr[i] - avg) / (i + 1);
			avg += sum;
		}
		System.out.println((int) avg);
	}

	// You are asked Q questions. For each question, you have to determine whether
	// the given number X can be represented as a sum of two or more consecutive
	// positive integers. For example, the answer for X=9 is Yes as 9=2+3+4 while
	// the answer for 2 is No (note that (−1)+0+1+2=2 is invalid as only positive
	// integers are allowed).

	// we know that if and only if number is power of 2 then this number never
	// consecutive number.
	// Otherwise it is consecutive

	// we can check number is power of 2 or not by this formula
	// (num & num - 1) then it will be power of two
	// else it is not power of 2
	
	// if (n & n - 1) == 0 then it is power of 2 else not;
	
	// https://www.ritambhara.in/check-if-number-is-a-power-of-2/#:~:text=Method%2D2%3A%20Keep%20dividing%20by,is%20a%20power%20of%202.
	public static void isItConsecutive(int num) {
		
		if((num & num - 1) == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}

	}

}

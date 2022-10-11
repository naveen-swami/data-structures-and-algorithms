package com.interview.questions;

public class LargeFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		findFactorial(60);
	}

//	Factorial of
//	a large
//	number
//	Input:-60 Output:-8320987112741390144276341183223364380754172606361245952449277696409600000000000000

	// num = 5
	static void findFactorial(int num) {
		StringBuilder resString = new StringBuilder();
		for (int i = 1; i <= num; i++) {
			resString = stringMultiply(resString, i);
		}
		System.out.println(resString);
	}

	static StringBuilder stringMultiply(StringBuilder resString, int num) {
		
		// we can also use % for find last digit
		StringBuilder res = new StringBuilder(); // "1"
		int carry = 0;
		for (int i = resString.length() - 1; i >= 0; i--) {
			int lastValue = resString.length() == 0 ? 1 : Integer.valueOf(resString.charAt(i)) - '0';
			int mul = (lastValue * num) + carry;
			String carryString = String.valueOf(mul);
			int lastNum = carryString.charAt(carryString.length() - 1) - '0';
			carry = carryString.substring(0, carryString.length() - 1).length() == 0 ? 0
					: Integer.valueOf(carryString.substring(0, carryString.length() - 1));
			res = new StringBuilder(String.valueOf(lastNum)).append(res);
		}
		if (resString.length() == 0) {
			return new StringBuilder(String.valueOf(num));
		}
		if (carry > 0) {
			res = new StringBuilder(String.valueOf(carry)).append(res);
		}
		return res;
	}

}

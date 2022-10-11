package com.interview.oops.questions;

public class Test {

	static int count = 0;
	{
		count++;
	}

	public static void main(String[] args) {
		Test test1 = new Test();
		Test test2 = new Test();
		System.out.println(count);
	}
}


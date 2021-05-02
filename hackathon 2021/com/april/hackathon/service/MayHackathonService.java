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

}

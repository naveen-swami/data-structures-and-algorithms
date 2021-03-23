package com.contest.service;

public class DSAContest10Service {

	public static int convertToBase9(int num) {
		int numWithBase9 = 0;

		int tenTh = 0;
		while (num > 0) {
			if (numWithBase9 == 0 && num % 9 == 0) {
				tenTh++;
				num /= 9;
				continue;
			}
			numWithBase9 = ((num % 9) * (int) Math.pow(10, tenTh)) + numWithBase9;
			num /= 9;
			tenTh++;
		}

		return numWithBase9;
	}

	public static boolean isConsecutiveArray(int[] arr) {

		int consuctiveNo = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (consuctiveNo == arr[i]) {
				count++;
				if (count == 3) {
					return true;
				}
			} else {
				consuctiveNo = arr[i];
				count = 1;
			}
		}

		return false;
	}
}

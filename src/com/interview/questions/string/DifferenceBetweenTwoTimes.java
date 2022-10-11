package com.interview.questions.string;

import java.util.Scanner;


public class DifferenceBetweenTwoTimes {

	/**
	 * input: 1:23am-1:08am
	 * ans: 1415
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// keep this function call here
//		Scanner s = new Scanner(System.in);
		String str = "1:23am-1:08am";
//		System.out.print(StringChallenge(s.nextLine()));
		System.out.print(StringChallenge(str));
	}

	public static String StringChallenge(String str) {
		// code goes here
		int res = 0;
		String[] splitTimes = str.split("-");
		String fTime = splitTimes[0];
		String sTime = splitTimes[1];
		// System.out.println(changeTo24HoursFormatMin(sTime));
		int fMins = changeTo24HoursFormatMin(fTime);
		int sMins = changeTo24HoursFormatMin(sTime);
		if (fMins > sMins) {
			res = 1440 - fMins + sMins;
		} else {
			res = sMins - fMins;
		}
		return String.valueOf(res);
	}

	public static int changeTo24HoursFormatMin(String str) {
		String[] time = str.split(":");
		int totalMin = 0;
		int hours = Integer.valueOf(time[0]);
		int mins = Integer.valueOf(time[1].substring(0, 2));
		if (time[1].substring(2).equals("am")) {
			if (hours == 12) {
				totalMin += 0;
			} else {
				totalMin += hours;
			}
			totalMin += mins;
		} else {
			if (hours == 12) {
				totalMin += 12 * 60;
			} else {
				totalMin += (12 + hours) * 60;
			}
			totalMin += mins;
		}
		return totalMin;
	}
}
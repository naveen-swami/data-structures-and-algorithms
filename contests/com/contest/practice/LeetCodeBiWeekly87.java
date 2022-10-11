package com.contest.practice;

import java.util.concurrent.CountDownLatch;

public class LeetCodeBiWeekly87 {

	public static void main(String[] args) {
		LeetCodeBiWeekly87 service = new LeetCodeBiWeekly87();
		System.out.println(service.countDaysTogether("08-15", "08-18", "08-16", "08-19"));
	}

	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

		int[] monthArr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] arriaveAliceArr = convertStringToInt(arriveAlice.split("-"));
		int[] leaveAliceArr = convertStringToInt(leaveAlice.split("-"));
		int[] arriveBobArr = convertStringToInt(arriveBob.split("-"));
		int[] leaveBobArr = convertStringToInt(leaveBob.split("-"));

		int countDays = 0;
		if (isBetween(arriaveAliceArr, arriveBobArr, leaveBobArr)
				&& isBetween(leaveAliceArr, arriveBobArr, leaveBobArr)) {
			int minMonth = Math.min(leaveAliceArr[0], leaveBobArr[0]);
			int minDay = Math.min(leaveAliceArr[1], leaveBobArr[1]);

			if (arriaveAliceArr[0] < minMonth) {
				for (int i = arriaveAliceArr[0] - 1; i < minMonth; i++) {
					if (i == arriaveAliceArr[0] - 1) {
						countDays += monthArr[i] - arriaveAliceArr[1];
					} else if (i == minMonth - 1) {
						countDays += minDay;
					} else {
						countDays += monthArr[i];
					}
				}
			} else {
				countDays = minDay - arriaveAliceArr[1];
			}

		} else if (isBetween(arriveBobArr, arriaveAliceArr, leaveAliceArr)
				&& isBetween(leaveBobArr, arriaveAliceArr, leaveAliceArr)) {
			int minMonth = Math.min(leaveAliceArr[0], leaveBobArr[0]);
			int minDay = Math.min(leaveAliceArr[1], leaveBobArr[1]);

			if (arriveBobArr[0] < minMonth) {
				for (int i = arriveBobArr[0] - 1; i < minMonth; i++) {
					if (i == arriveBobArr[0] - 1) {
						countDays += monthArr[i] - arriveBobArr[1];
					} else if (i == minMonth - 1) {
						countDays += minDay;
					} else {
						countDays += monthArr[i];
					}
				}
			} else {
				countDays = minDay - arriveBobArr[1];
			}
		} else {
			return -1;
		}
		return countDays;

	}

	int[] convertStringToInt(String[] str) {
		int[] intArr = new int[2];
		intArr[0] = Integer.parseInt(str[0]);
		intArr[1] = Integer.parseInt(str[1]);
		return intArr;
	}

	boolean isBetween(int[] condition, int[] arrive, int[] leave) {
		return condition[0] <= arrive[0] && condition[0] <= leave[0] && condition[1] <= arrive[1]
				&& condition[1] <= leave[1];

	}

}

package com.notes;

public class TrickyQuestions {

	public int[] sortedStudent(int input1, int input2, int[][] input3) {
		int subjectIndex = 0;
		int minMarks = Integer.MAX_VALUE;
		int[] stuTotal = new int[input1];
		int[] subTotal = new int[input2];

		for (int stu = 0; stu < input1; stu++) {
			for (int sub = 0; sub < input2; sub++) {
				subTotal[sub] += input3[stu][sub];
				stuTotal[stu] += input3[stu][sub];
				if (stu == input1 - 1 && minMarks > subTotal[sub]) {
					minMarks = subTotal[sub];
					subjectIndex = sub;
				}
			}
		}

		for (int i = 0; i < input1; i++) {
			stuTotal[i] -= input3[i][subjectIndex];
		}

		return stuTotal;
	}

	public int minimumRoationApple(int input1, int[] input2) {
		int min = 0;
		int sum = 0;
		for (int val : input2) {
			sum += val;
		}

		sum = sum / input1;

		for (int val : input2) {
			if (val > sum) {
				min += val - sum;
			}
		}

		return min;
	}
}

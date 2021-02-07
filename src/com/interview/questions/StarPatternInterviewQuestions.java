package com.interview.questions;

public class StarPatternInterviewQuestions {
	public static void main(String[] args) {
        
		int n = 6;
		getLogic(n);
		printLeftTrangle(n);
		printRightTrangle(n);
		printSquare(n);
		printRectange(4, n);
		printTrangle(n);
	}

	static void getLogic(int n) {
		// used to get logic
		System.out.println("For Testing. We can get logic using show this matrix");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print("(" + i + ", " + j + ") | ");
			}
			System.out.println();
		    System.out.print("-----------------------------------------------------");
			System.out.println();
		}
	}

	static void printLeftTrangle(int n) {
		System.out.println("Left Trangle");

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= n - i) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	static void printRightTrangle(int n) {
		System.out.println("Right Trangle");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j <= i) {
					System.out.print("* ");
				} else {
					break;
				}
			}
			System.out.println();
		}
	}

	static void printTrangle(int n) {
		System.out.println("Trangle");
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (j <= i) {
					System.out.print("* ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void printSquare(int n) {
		System.out.println("Square");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	static void printRectange(int row, int col) {
		System.out.println("Rectangle");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}

package com.interview.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {

		int[][] grid = new int[11][10];

		Scanner scan = new Scanner(System.in);
		boolean isFirstPlayer = true;
		List<Integer[]> pairList = new LinkedList<>();

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 10; j++) {
				Integer[] value = { i, j };
				pairList.add(value);
			}
		}

//		xDirList.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
//		List<Integer> yDirList = new LinkedList<>();
//		yDirList.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		while (!pairList.isEmpty()) {
			Integer[] playerMove = pairList.remove((int) (Math.random() * 100) % pairList.size());
//			int playerMoveY = yDirList.remove((int) (Math.random() * 10) % xDirList.size());

			int playerSign = isFirstPlayer ? 1 : 2;
			grid[playerMove[0]][playerMove[1]] = isFirstPlayer ? 1 : 2;
			// move
			System.out.println("Moved: " + playerSign + " " + playerMove[0] + " " + playerMove[1]);

//			System.out.println(Arrays.toString(grid));
//			print2dArray(grid);
			if (isPlayerWinner(grid, playerMove[0], playerMove[1], playerSign)) {
				System.out.println(isFirstPlayer ? "Player 1" : "Player 2");
				print2dArray(grid);
				break;
			}

			isFirstPlayer = !isFirstPlayer;
		}

	}

	static boolean isPlayerWinner(int[][] grid, int playerMoveX, int playerMoveY, int playerSign) {
		boolean isWin = false;

		// varticle case
		int countMove = 0;
		int tempPlayerMoveY = playerMoveY;
//		// back side
		while (tempPlayerMoveY > -1) {
			if (grid[playerMoveX][tempPlayerMoveY] == playerSign) {
				countMove++;
				tempPlayerMoveY = tempPlayerMoveY - 1;
			} else {
				break;
			}
			if (countMove >= 5) {
				return true;
			}

		}
//		// forward side
		tempPlayerMoveY = playerMoveY + 1;
		while (tempPlayerMoveY < 10) {
			if (grid[playerMoveX][tempPlayerMoveY] == playerSign) {
				countMove++;
				tempPlayerMoveY = tempPlayerMoveY + 1;
			} else {
				break;
			}
			if (countMove >= 5) {
				return true;
			}

		}
//
//		// horizontal case
//		countMove = 0;
		int tempPlayerMoveX = playerMoveX;
//
//		// top side
		while (tempPlayerMoveX > -1) {
			if (grid[tempPlayerMoveX][playerMoveY] == playerSign) {
				countMove++;
				tempPlayerMoveX = tempPlayerMoveX - 1;
			} else {
				break;
			}
			if (countMove >= 5) {
				return true;
			}

		}
//		// down side
		tempPlayerMoveX = playerMoveX + 1;
		while (tempPlayerMoveX < 10) {
			if (grid[tempPlayerMoveX][playerMoveY] == playerSign) {
				countMove++;
				tempPlayerMoveX = tempPlayerMoveX + 1;
			} else {
				break;
			}
			if (countMove >= 5) {
				return true;
			}

		}

		// diagonal case
		countMove = 0;
		tempPlayerMoveX = playerMoveX;
		tempPlayerMoveY = playerMoveY;

		// left-down side
		List<List<Integer>> res = new LinkedList<>();
		while (tempPlayerMoveX < 11 && tempPlayerMoveY > -1) {
			if (grid[tempPlayerMoveX][tempPlayerMoveY] == playerSign) {
				countMove++;
				res.add(Arrays.asList(tempPlayerMoveX, tempPlayerMoveY));
				tempPlayerMoveX = tempPlayerMoveX + 1;
				tempPlayerMoveY = tempPlayerMoveY - 1;
			} else {
				break;
			}
			if (countMove >= 5) {
				System.out.println(res);
				return true;
			}

		}
		// top-right side
		tempPlayerMoveX = playerMoveX - 1;
		tempPlayerMoveY = playerMoveY + 1;

		// left-down side
		while (tempPlayerMoveX > -1 && tempPlayerMoveY < 10) {
			if (grid[tempPlayerMoveX][tempPlayerMoveY] == playerSign) {
				countMove++;
				res.add(Arrays.asList(tempPlayerMoveX, tempPlayerMoveY));
				tempPlayerMoveX = tempPlayerMoveX - 1;
				tempPlayerMoveY = tempPlayerMoveY + 1;
			} else {
				break;
			}
			if (countMove >= 5) {
				System.out.println(res);
				return true;
			}

		}

		return false;
	}

	static void print2dArray(int[][] arr) {
		for (int[] values : arr) {
			for (int val : values) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
//
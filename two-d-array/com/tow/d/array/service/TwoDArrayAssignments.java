package com.tow.d.array.service;

public class TwoDArrayAssignments {
	

	// 1 2 3
	// 4 5 6
	// 7 5 9
	// 1 7 2

	public void dispalySprialTraversalMatrix(int[][] matrix) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int startRow = 0;
		int endRow = rowSize - 1;
		int startCol = 0;
		int endCol = colSize - 1;

		while (startRow <= endRow && startCol <= endCol) {
			// to print Left to Right ( First Column )
			for (int col = startCol; col <= endCol; col++) {
				System.out.print(matrix[startRow][col] + " ");
			}

			startRow++;

			// to print Top to Bottom ( Last Row )
			for (int row = startRow; row <= endRow; row++) {
				System.out.print(matrix[row][endCol] + " ");
			}

			endCol--;

			if (startRow <= endRow) {
				// to print right to left ( Last col)
				for (int col = endCol; col >= startCol; col--) {
					System.out.print(matrix[endRow][col] + " ");
				}
				endRow--;
			}

			if (startCol <= endCol) {
				// to print bottom to top ( First Row )
				for (int row = endRow; row >= startRow; row--) {
					System.out.print(matrix[row][startCol] + " ");
				}

				startCol++;
			}
		}

	}

	public int[][] booleanMatrixProblem(int[][] booleanMatrix) {
		int[] oneValue = new int[booleanMatrix[0].length];

		for (int i = 0; i < booleanMatrix[0].length; i++) {
			oneValue[i] = 1;
		}
		for (int row = 0; row < booleanMatrix.length; row++) {
			for (int col = 0; col < booleanMatrix[row].length; col++) {
				if (booleanMatrix[row][col] == 1) {
					booleanMatrix[row] = oneValue;
					break;
				}
			}
		}

		return booleanMatrix;
	}

	public int[][] transposeMatrix(int[][] twoDMatrix) {
		for (int row = 0; row < twoDMatrix.length - 1; row++) {
			for (int col = row + 1; col < twoDMatrix[row].length; col++) {
				int temp = twoDMatrix[row][col];
				twoDMatrix[row][col] = twoDMatrix[col][row];
				twoDMatrix[col][row] = temp;
			}
		}
		return twoDMatrix;
	}

	public void print2DArrays(int[][] twoDArray) {
		for (int row = 0; row < twoDArray.length; row++) {
			for (int col = 0; col < twoDArray[row].length; col++) {
				System.out.print(twoDArray[row][col] + " ");
			}
			System.out.println();
		}
	}
}

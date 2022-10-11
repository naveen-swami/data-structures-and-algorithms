package com.tow.d.array.problems;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * 
 * @author naveen
 *
 */
public class MatrixGame {
	
	public static void main(String[] args) {
		
//		char[][] arr = {{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','O','X','X'}};
		char[][] arr = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
		solve(arr);
	}

    public static void solve(char[][] board) {
    	
    	 System.out.println(Arrays.toString(board[0]));
         System.out.println(Arrays.toString(board[1]));
         System.out.println(Arrays.toString(board[2]));
         System.out.println(Arrays.toString(board[3]));
         System.out.println(Arrays.toString(board[4]));
         System.out.println();
        
        for(int i = 1; i < board.length-1; i++) { // 4
            for(int j = 1; j < board[i].length - 1; j++)  { //4
//                System.out.println(Character.compare(board[i][j],'O'));
                if(board[i][j] == 'O'){  // 
                    if(isSurroundedByX(board, i, j)) {
                        board[i][j] = 'X';
                         // System.out.println("i =" + i + " " + j);
                    }
                }
//                System.out.print(board[i][j] + " ");
            }
//             System.out.println();
        }
        
        
        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[1]));
        System.out.println(Arrays.toString(board[2]));
        System.out.println(Arrays.toString(board[3]));
        System.out.println(Arrays.toString(board[4]));
    }
    
    public static boolean isSurroundedByX(char[][] board, int row, int col) {
        
        // left
        
        for(int i = col - 1; i >= 0; i--) { // i = 1
                if(board[row][i] == 'X') {
                    break;
                }
            if(i == 0) {
                return false;
            }
        }
        
        // top
         for(int i = row - 1; i >= 0; i--) { // i =1
                if(board[i][col] == 'X') {
                    break;
                }
            if(i == 0) {
                return false;
            }
        }
        
        // right
         for(int i = col + 1; i < board[row].length ; i++) { // i = 3
                if(board[row][i] == 'X') {
                    break;
                }
            if(i == board[row].length - 1) {
                return false;
            }
        }
        
        // bottom
         for(int i = row + 1; i < board.length; i++) {
                if(board[i][col] == 'X') {
                    break;
                }
            if(i == board.length - 1) {
                return false;
            }
        }
        
        return true;
    }
}

package com.two.d.array.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

import com.tow.d.array.service.TwoDArrayAssignments;


public class TwoDArrayController {
    public static void main(String[] args) throws IOException {
    	
    	TwoDArrayAssignments twoDArrayAssignments = new TwoDArrayAssignments();
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
    	// for square matrix
		//int matrixSize = Integer.parseInt(reader.readLine());
    	
    	// for rectangle matrix
        String[] rowCol = reader.readLine().split(" ");
        int rowSize = Integer.parseInt(rowCol[0]);
        int colSize =  Integer.parseInt(rowCol[1]);

		int[][] intArr = new int[rowSize][colSize];
		for(int i = 0; i < rowSize; i++) {
			String[] strArr = reader.readLine().split(" ");
			for(int j= 0; j< colSize; j++) {
				intArr[i][j]= Integer.parseInt(strArr[j]);
			}
		}
		
		BigInteger n=new BigInteger(rowCol[0]);
		BigInteger m=new BigInteger(rowCol[0]);
		 
		if(n.divide(m).equals(BigInteger.ZERO)) {
			
		}
    	
		// First way to convert string into string
//		int[][] intArr = new int[matrixSize][matrixSize];
//		for(int i = 0; i < matrixSize; i++) {
//			String[] strArr = reader.readLine().split(" ");
//			for(int j= 0; j< matrixSize; j++) {
//				intArr[i][j]= Integer.parseInt(strArr[j]);
//			}
//		}
		
		// second way to convert string into int
		//int[] squarMatrix = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
//		int[][] twoDArray = new int[matrixSize][matrixSize];
//		for(int i = 0; i < matrixSize ; i++) {
//			twoDArray[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//		}
		
//	    Arrays.asList(intArr).forEach( it -> {
//	    	Arrays.asList(it).forEach( itt -> {
//	    	      
//	    	});
//	    });
		//assignment.print2DArrays(intArr);
		//System.out.println();
         //twoDArray = twoDArrayAssignments.transposeMatrix(twoDArray);
		
		// take input in single line
//		int[][] intArr = new int[matrixSize][matrixSize];
//		String[] strArr = reader.readLine().split(" ");
//		int strIndex = 0;
//		for(int i = 0; i < matrixSize; i++) {
//			for(int j= 0; j< matrixSize; j++) {
//				intArr[i][j]= Integer.parseInt(strArr[strIndex++]);
//			}
//		}
		
		//intArr = twoDArrayAssignments.booleanMatrixProblem(intArr);  
		  twoDArrayAssignments.print2DArrays(intArr);
          twoDArrayAssignments.dispalySprialTraversalMatrix(intArr); 
	}
}

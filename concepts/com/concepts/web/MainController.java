package com.concepts.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import com.one.d.array.service.Assignments;

public class MainController {

	public static void main(String[] args) throws IOException {

		Assignments assignment = new Assignments();
		// take input
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. : ");
		 int n = scan.nextInt();
		 int[] arr = new int[n];
		 for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		 }
		 System.out.println(assignment.findFirstPostiveMissingNumber(arr));
		// //int result = assignment.printArmStrongNo(n);
		//
		// System.out.println(assignment.getOpTimes(n));
		// int x = 0, y = 0, z = 0;
		// x = ( ++x + y-- ) * z++ ;
		//
		// System.out.println("Test :" + x);
		//
		// int a =10;
		// String b = "10";
		//
		// int[] array = { 1, 4, 3, 6 };
		// int what = 0;
		//
		// // scan the array
		// for ( int index=0; index < array.length; index++ )
		// {
		// what = what + array[ index ] ;
		// }
		// System.out.println( what );
		//
		// }
		//
		// int[] arr = new int[] {1, 2, 3,4,5,6,7,8};
		// assignment.rotate(new int[] {1, 2, 3,4,5,6,7,8,9,10}, 10 , 3);

		// int asw= assignment.findUnique(new int[] {1, 1, 2, 2, 3});
		// int asw= assignment.ispalindrome("15235321");
		
		
//		 Scanner scanner = new Scanner(System.in);
//	 	 int num = scanner.nextInt();
//	      int sum = 0;
//	      for (int i = 0; i < num; i++) {
//				sum += scanner.nextInt();
//			}
//	        System.out.println(sum);
//		}
		
		

		
//		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		long num[] = new long[n];
//		for (int i = 0; i < num.length; i++) {
//			num[i] = scanner.nextLong();
//		}
//		int asw = assignment.countSeeRoof(num);
//		System.out.println(asw);
		
//		 int fileSize = scanner.nextInt();
//	     int speed = scanner.nextInt();
//	     int downloadTime = fileSize/ speed;
//	    	     System.out.println(downloadTime/8);
		
//		long n = scan.nextLong();
//		assignment.getMinimumChangeAmount(n);
//		System.out.println(assignment.getMinimumChangeAmount(n));
		
//		int[][] arr;
//		arr = new int[2][2];
////		arr[0] = {1,2};
//		System.out.println(arr[0][1]);
		
		
//		System.out.println(0 % 2 == 0);
		

		
	}
	
	

}

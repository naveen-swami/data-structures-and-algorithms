package com.recursion.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import com.recursion.service.RecurstionService;

public class RecurstionController {

	static RecurstionService recurstionService = new RecurstionService();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

//    String values = reader.readLine();
//	int disks = Integer.parseInt(reader.readLine());
//    recurstionService.towerOfHanoi(disks, "A", "B", "C");
//    
//    System.err.println(recurstionService.coinFlip(values));

//	String[] values = reader.readLine().split(" ");
//	long[] intArr = new long[num];
//	
//	for(int i= 0; i< num; i++) {
//		intArr[i]= Integer.parseInt(values[i]);
//	}
//	
//	System.out.println(recurstionService.happBallon(intArr));

//	recurstionService.printNumInDescresingOrder(num);
//	System.out.println();
//	recurstionService.printNumInIncreasingOrder(num);
//	System.out.println();
//	recurstionService.printNumDesAndIncOrder(num);

//    String[] values = reader.readLine().split(" ");
		// long n = Long.parseLong(values[0]);
		// long m = Long.parseLong(values[1]);

//	BigInteger n=new BigInteger(values[0]);
//	BigInteger m=new BigInteger(values[1]);
//	 
//	System.err.println(n.mod(m) + " " +   n.mod(m).equals(BigInteger.ZERO));
//	if(n.mod(m).equals(BigInteger.ZERO)) {
//		System.out.println("Yes");	
//	}
//	
//	else { 
//		System.out.println("No");
//
//	}

//	  int arr[] = new int[5];
//	  for(int i =0; i<5; i++) {
//		  arr[arr[i]] = i+arr[i];
//	  }
//	  int sum = 0;
//	  for(int i =0; i<5; i++) {
//		  sum+= arr[i];
//	  }

//	int i = 2047;
//	int cnt = 0;
//	for(; cnt!= 11; i/=2) {
//		//int cnt= i;
//		
////		if(cnt== 2) {
////			res+=i;
////		}
//		cnt++;
//	}
//	cnt = 0;
//	for(; cnt!= 11; i*=2)  {
//	   cnt++;
//	}
//	System.out.println(sum);

//		Scanner scan = new Scanner(System.in);
//		// long result = recurstionService.getCandyCrushCost(scan.nextLong());
//
//		String s1 = "abc";
//		String s3 = new String("abc");
//
//		System.out.println(s1 == s3);
//		System.out.println(s1.equals(s3));
//	  int n = scan.nextInt();
//	  int s = scan.nextInt();
//	  int num[] = new int[n];
//			for (int i = 0; i < n; i++) {
//				num[i] = scan.nextInt();
//			}
//
//			Arrays.sort(num);
//
//			float min = (num[n-1] * s) / 1000f; 
//	        int intMin = (int) min;
//			if( min == intMin ) {
//				System.out.println(intMin);
//			} else {
//				System.out.println(intMin+1);
//			}
		
		oneDArrayTest();

	}

	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println(recurstionService.permute(arr));

	}

}

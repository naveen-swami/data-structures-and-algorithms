package com.complexity.analysis.web;

import java.util.Scanner;

import com.complexity.analysis.service.ComplexityService;

public class ComplexityAnalysisController {
	
	//private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String[] args) {
		
		ComplexityService complexityService= new ComplexityService();
		
		Scanner scan = new Scanner(System.in);
		//int testCase = scan.nextInt();
		//while(testCase -- > 0) {
//			long num = scan.nextLong();
			int num = scan.nextInt();
			//System.out.println(complexityService.isItPrimeNumber(num));
//			System.out.println(complexityService.getDivisorOfNumber(num));
			System.out.println(" Total:"+complexityService.getTotalPrimeNumber(num));
		//}
		
	   //scan.close();	
   
	}
}

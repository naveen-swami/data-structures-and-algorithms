package com.complexity.analysis.web;

import java.util.Scanner;

import com.complexity.analysis.service.ComplexityService;

public class ComplexityAnalysisController {

	// private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String[] args) {

		ComplexityService complexityService = new ComplexityService();

		Scanner scan = new Scanner(System.in);
		// int testCase = scan.nextInt();
		// while(testCase -- > 0) {
		 long num = scan.nextLong();
//		int num = scan.nextInt();
		long p = scan.nextLong();
		int mod = 1000000007;
		System.out.println(complexityService.getPower(num, p, mod));
		// System.out.println(complexityService.findAllFactor(num));
		// System.out.println(complexityService.largestPrimeFactor(num));
		// System.out.println(complexityService.calculateMthPowerOfNumber(num, m));
//		System.out.println(complexityService.checkIfMthPowerOfNumberIsPrime(num, m) ? "Yes" : "No");
		// System.out.println(complexityService.isItPrimeNumber(num));
		// System.out.println(complexityService.getDivisorOfNumber(num));
		// System.out.println(" Total:"+complexityService.getTotalPrimeNumber(num));
		// }

		// scan.close();

	}
}

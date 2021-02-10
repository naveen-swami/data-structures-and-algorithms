package com.complexity.analysis.service;

import java.util.Arrays;

public class ComplexityService {

	public int getTotalPrimeNumber(int num) {
		int totalPrimeNumber = 0;
		if (num >= 2) {
			System.out.print(2 +  " ");
			totalPrimeNumber++;
			if (num == 2) {
				return totalPrimeNumber;
			} else if (num >= 3) {
				System.out.print(3 +  " ");
				totalPrimeNumber++;
				if (num == 3) {
					return totalPrimeNumber;
				} else if(num >= 5) {
					System.out.print(5 +  " ");
					totalPrimeNumber++;
					if(num == 5) {
						return totalPrimeNumber;
					}
				}
			}
		}

	    //int sizeOfI = num / 6;
	    // 6 + 1 and 6 - 1 always prime, where n is natural number( except 2, 3, 5,7 ,11 prime numbers )
		
		for (int i = 1; num >= 6*i - 1 ; i++) {
		     int n = 6*i;
		     if(n+1 <= num && (n < 12 || checkMultipleOfPrimeNumber(n + 1))) {
		    	 System.out.print(n+1 +  " ");
		    	 totalPrimeNumber++; 
		     }
		     if(n - 1 == 11 || checkMultipleOfPrimeNumber(n - 1)) {
		    	 System.out.print(n-1 +  " ");
		    	 totalPrimeNumber ++;
		     }
		}
		return totalPrimeNumber;
	}
	
    boolean checkMultipleOfPrimeNumber(int n) {
    	if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0 || n % 11 == 0  ) {
    		return false;
    	}
    	return true;
    }

	public int findMisssingInteger(int[] a) {
		Arrays.sort(a);
		// 1, 1, 2, 3, 4, 6
		// int currentNum = a[0]; //1
		// int missingNumber = 1;
		// 1
		if (a[a.length - 1] <= 0) {
			return 1;
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < 0) {
				continue;
			}
			if (a[i + 1] - a[i] > 1) {
				return a[i] + 1;
			}
			// if(a[i+1] <= currentNum) { // 2
			// currentNum = a[i+1]; // 1
			// continue;
			// }
			// missingNumber = a[i+1] > 0 ? a[i
			// break
		}
		// System.out.println(a[a.length]);
		return a[a.length - 1] + 1;
	}

	public boolean isItPrimeNumber(long num) {

		if (num == 2) {
			return true;
		}
		if (num == 1 || (num & 1) == 0) {
			return false;
		}

		for (int i = 3; i <= Math.sqrt(num); i = i + 2) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public int getDivisorOfNumber(long num) {
		// if((num & 1) != 0 ) {
		// return 0;
		// }
		// int divisorOfTwo = 0;
		// for(int i = 2 ; i <= num; i = i+2) {
		// if(num % i == 0 ) {
		// divisorOfTwo++;
		// }
		// }
		// return divisorOfTwo;

		// Second approach

		int count = 0, i;

		// Traverse from 1 to sqrt(N)
		for (i = 2; i <= Math.sqrt(num); i = i + 2) {

			// Check if i is a factor
			if (num % i == 0) {
				// increase the count if i
				// is divisible by k
				if (i % 2 == 0) {
					count++;
				}

				// (n/i) is also a factor
				// check whether it is divisible by k
				if ((num / i) % 2 == 0) {
					count++;
				}
			}
		}

		i--;

		// If the number is a perfect square
		// and it is divisible by k
		if ((i * i == num) && (i % 2 == 0)) {
			count--;
		}

		return count;
	}

}
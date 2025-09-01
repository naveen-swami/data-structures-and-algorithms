package com.tow.d.array.problems;

public class DiamondPattern {

	public static void main(String[] args) {
		int num = 10;
		printDiamond1(num);
			
	}
	
	static void printDiamond1(int n) {
		// Upper part of the diamond
        for (int i = 1; i <= n; i++) {
            // Printing spaces
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            // Printing stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower part of the diamond
        for (int i = n - 1; i >= 1; i--) {
            // Printing spaces
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            // Printing stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
	}
	
	static void printDiadmond(int num) {
		num *= 2;

 		for(int i = 0; i <  num+1; i++) {
			if(i < num/2) {
			
				for(int j = num/2; j >= 0; j-- ) {
					if(j > i) {
						System.out.print(" ");
					} else {
						System.out.print(" *");
					}
				}				
			} else {
//				System.out.print("  ");
				System.out.print(" ");
				for(int j = num/2; j < num; j++ ) {
					if(j > i) {
						System.out.print(" *");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

}

package com.dyanmic.programming.problems;

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class TribonacciNumber {
    public static void main (String[] args) {
       Scanner input = new Scanner(System.in);

       String inputStr = input.nextLine();
       String[] inputStrArr = inputStr.split(" ");
       long n =  Long.parseLong(inputStrArr[0]);
       long a = Long.parseLong(inputStrArr[1]);
       long b = Long.parseLong(inputStrArr[2]);
       long c = Long.parseLong(inputStrArr[3]);

        System.out.println(sumTribonacci(n, a, b, c));
    }

    static long sumTribonacci(long n, long a, long b, long c) {
        
    	
        long modulo=1000000007;

        long sum = ((a + b + c) % modulo);
//        for(long i = 3; i < n; i++) {
//        long sum = (((a % modulo)  + (b % modulo) + (c % modulo)) % modulo);
//        a = b;
//        b = c;
//        c = sum;
//        }
//        return c;
         if(n == 4) {
             return sum;
         }
         return sumTribonacci(n-1, b, c, sum);
    }
}
package com.one.d.array.service;

import java.util.Arrays;
import java.util.Scanner;

public class Assignments {
	
    
	public int findFirstPostiveMissingNumber(int[] arr) {
		// first approach
//		Arrays.sort(arr);
//		int current = 1;
//		for(int i=0; i< arr.length; i++) {
//			if(arr[i] == current) {
//				current++;
//			}
//		}
//		return current;
		
		// second approch o(n)
		
		int index = 1;
		while(index >= 1 && index <= arr.length) {
			if(arr[index-1] != index && arr[index -1] > 0 && arr[index - 1] <= arr.length ) {
				int temp = arr[index -1];
				if(arr[index -1] == arr[temp -1]) {
					index++;
					continue;
				}
				//int indexValue = arr[index -1];
				arr[index-1] = arr[temp - 1];
				arr[temp - 1] = temp;
			} else {
				index++;
			}
		}
       
		int current = 1;
		for(int i=0; i < arr.length; i++) {
			if(arr[i] != i+1) {
				return i+1;
			}
		}
		return current;  		
	}
	
	static void sumOfBlackAndWhiteSquares(int[][] chessBord) {
        int BlackSquaresSum = 0;
		int WhiteSquaresSum = 0;
		boolean black = false, white = false;
		for(int row = 1; row < chessBord.length ; row++) {
					for(int col= 0; col < chessBord[row].length; col++) {
					   black = row+col % 2 == 0;
					   if(row+col % 2 == 0) {
						   
					   }
					}
					}
//					System.out.println();
		System.out.println(BlackSquaresSum + " " + WhiteSquaresSum);
				}
		
	
   public void printNumOfGoodCell(byte[][] arr) {
	    int numberOfGoodCell = 0;
	    byte left, right, top, down;
		for(int row = 1; row < arr.length -1 ; row++) {
					for(int col= 1; col < arr[row].length - 1; col++) {
					   left = arr[row - 1][col];
					   right = arr[row + 1][col];
					   top = arr[row][col - 1];
					   down = arr[row][col + 1];
					   if(left == 1 && right == 1 && top == 1 && down == 1 ) {
						   numberOfGoodCell ++;
					   }
					}
//					System.out.println();
				}
		
		System.out.println(numberOfGoodCell);
		
//		for(byte[] row : arr) {
//			for(byte col : row) {
//				System.out.print(col + " ");
//			}
//			System.out.println();
//		}
	}
	/**
	 * You have 500 and 200 rapes notes. find minimum change amount given by shopkeeper to you. So how many you gives notes to shopkeeper
	 * 
	 * @param n
	 * @return
	 */
   public int getMinimumChangeAmount(int n) {
	   if(n <= 200) {
		   return  200 - n;
	   } 
	   if(n <= 400 ) {
		   return 400 - n;
	   }
	   
	   // HCF of 500 and 200 is 100
//	   n = n % 100; 
	   
	   return ((100 - n % 100) % 100);
	   
   }
	
	public void getMinimumChangeAmountSecondMehod(long n) {
		System.err.println( "second Ans: " + (100-n%100)%100);
		
		if(n < 200) {
			System.out.println(200 - n);
			return;
		}
		
		if(n >= 500) {
			n -= (n/500)*500;
		}
		boolean test = false;
		if(n > 400) {
            n = 500 - n;
			test =true;
		} 
		if(n >= 200) {
			n -= (n/200)*200;
		}
		if(!test && n > 0) {
			n = (200 - n) % 100  ;
		}
		System.out.println("My Ans: " + n);
		
		//int minimumChangeAmount =  (n < 500 ? (int) n : 0);
//		int temp;
		
//		for(int note : notes) {
//			
//			while(n > note) {
//				n -= note;
//			}
//		}
//		
//	   long temp = n;
	   
		
		
//		if(n >= 500) {
////			temp = (int) (n/500);
//			n -= (n/500)*500;
//		}
//		if(n >= 200) {
////			temp = (int) (n/200);
//			n -= (n/200)*200;
//		}
//		if(n > 0) {
//			n = notes[1] -n ;
//		}
//		System.out.print(n);
		
		
//		for(int note : notes) {
//			while(n => notes) {
//				n -= notes;
//			}
//		}

	}

	
	public int countSeeRoof(long[] buildingsHightArr) {
		
		int countBuilding = 1;
	    long higestBuilding = buildingsHightArr[0];
		for(int i = 1; i < buildingsHightArr.length ; i++) {
			if(higestBuilding > buildingsHightArr[i]) {
				return countBuilding;
			}
			else if(higestBuilding == buildingsHightArr[i]) {
			     continue;
			}
				higestBuilding = buildingsHightArr[i];
				countBuilding++;
		}
		
		return countBuilding;
	}
	
	
	public int findMissingNumberFromArray(int[] arr) {
		
//        Scanner scanner = new Scanner(System.in);
//					  int n = scanner.nextInt();
//		  int num[] = new int[n];
//		  for(int i = 0; i <n ; i++) {
//			  num[i] = scanner.nextInt();
//		  }
//		  System.out.print(findMissingNumberFromArray(num));
		
		Arrays.sort(arr);
		for(int i = 1; i <= arr.length; i++) {
			if(arr[i-1] != i) {
				return i;
			}
		}
		return 1;
	}
	
//	1
//	1 2 1
//	1 2 3 2 1
//	1 2 3 4 3 2 1
//	1 2 3 4 5 4 3 2 1
//	1 2 3 4 3 2 1
//	1 2 3 2 1
//	1 2 1
//	1
	
    public void patternMaking(int n) {
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= i; j++) {
    			System.out.print(j + " ");
    		}
    		for(int j = i; j >= 1; j--) {
    			System.out.print(j+ " ");
    		}
    	}
    }

	public int printArmStrongNo(int n) {
		
		if(n <= 79) {
			return 79;
		}
		
		int temp = n;
		int magicNo = 79;
	    while(n > 79 && temp <= 100000 ) {
	    	
	    	if(isMagic(n)) {
	    		return n;
	    	} else {
	    		n--;
	    	}
	    	if(isMagic(temp)) {
	    		return temp;
	    	}
	    	else {
	    		temp++;
	    	}
	    }
		return magicNo;
//		int power = 1;
//		int temp;
//		int digit;
//		System.out.print("1 ");
//		
//		for (int i = 10; i <= n; i++) {
//			int result = 0;
////			if(i >= 10 && i < 100) {
////				power = 2;
////			} else if(i >= 100 && i < 1000) {
////				power = 3;
////			}
////			else {
////				power = 4;
////			}
//			power = getTotalDigit(n, 0);
//			temp = i;
//			while (temp > 0) {
//				digit = temp % 10;
//				temp /= 10;
//				result += getPower(digit, power);
//			}
//			int sum = 0;
//			while( temp > 0) {
//	             sum += (int) Math.pow(temp % 10, 4);
//	             temp /= 10;
//	        }
//			if (result == i) {
//				System.out.print(result+  " ");
//			}
//		}
	}

	boolean isMagic(int n) {
		int digit = 0;
		boolean isSeven = false;
		boolean isNine =false;
		while(n > 0) {
			digit = n % 10;
			n /= 10;
			if(!isSeven) {
				if(digit == 7) {
					isSeven = true;
				}
			}
			if(!isNine) {
				if(digit == 9) {
					isNine = true;
				}
			}
			if(isNine && isSeven) {
				return true;
			}
		}
		return false;
	
	}

	private int getPower(int digit, int power) {
		if (power == 0) {
			return 1;
		}
		return digit*getPower(digit, --power);
	}
	
	int getTotalDigit(int n, int totalDigit) {
//		int totalDigit = 0;
//		while(n > 0) {
//			n /= 10;
//			totalDigit++;
//		}
		
		if(n > 0 ) {
			return getTotalDigit(n/10, totalDigit++); 
		}
		return totalDigit;
		
		//return totalDigit;
	}
	
	public int getOpTimes(int n) {
//		int sum = 0;
		int op = 0;
		while(n > 0) {
			n -= sumOfDigts(n, 0);
			op++;
		}
		return op;
	}

	private int sumOfDigts(int n, int totalDigit ) {
		if(n > 0 ) {
			totalDigit += n % 10;
			return sumOfDigts(n/10, totalDigit);
		}
		return totalDigit;
	}
	
 public	void rotate(int arr[], int n, int d) {
		 
		System.out.print("start: ");
		displayArr(arr);
//		for(int i = 0; i < d; i++ ) {
//			for(int i = 0; i < n/2; i++) {
//				int temp = arr[i];
//				if(d+i < n) {
//					arr[i] = arr[d+i];
//					arr[d+i] = temp;
//				}
//				}
//			}
//		for(int i = 0; i < n; i++) {
//			if(d+i < n) {
//				System.out.print( arr[d+i] + " ");
//			} else {
//				System.out.print (  arr[(i + d) - n] + " ");
//			}
			
			//System.out.println();
//		}
	    
		d = d % n; 
        int i, j, k, temp; 
        int gCD = getGCD(d, n); 
  
        for (i = 0; i < gCD; i++) { 
  
            // move i-th values of blocks 
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
		
			System.out.print("After roate " + d + " times: ");
			displayArr(arr);
		}
//	}
 
 int getGCD(int a, int b) 
 { 
     if (b == 0) 
         return a; 
     else
         return getGCD(b, a % b); 
 } 
 
   private void displayArr(int arr[]) {
	  for(int i = 0 ; i < arr.length ; i ++) {
		  System.out.print(arr[i] + " ");
	  }
	  System.out.println();
   }
   
  public int findUnique(int[] arr) {
	   Arrays.sort(arr);
	   int unique = 0;
	   for(int i = 0; i < arr.length-1 ;i= i+2) {
		   if(arr[i] != arr[i+1]) {
			   return arr[i];
		   }
	   }
	   return arr[arr.length-1];
   }
  
  
  
   public int ispalindrome(String string) {
	   
	   for(int i = 0; i < string.length()/2; i++){  
           if(string.charAt(i) != string.charAt(string.length()-i-1)){  
               return 0; 
           }
       }  
	   return 1;
	   
//	   int reversedInteger = 0, remainder, originalInteger;
//
//       originalInteger = num;
//
//       for( ;num != 0; num /= 10 )
//       {
//           remainder = num % 10;
//           reversedInteger = reversedInteger * 10 + remainder;
//       }
//
//       if (originalInteger == reversedInteger)
//           return 1;
//       else
//          return 0;
   
	   
	   
	   //int n=454;//It is the number variable to be checked for palindrome  
//	   double r,sum=0,temp;    
//	   
//	   temp=n;    
//	   while(n>0){    
//	    r=n%10;  //getting remainder  
//	    sum=(sum*10)+r;    
//	    n=n/10;    
//	   } 
//	   
//	   return temp == sum ? 1 : 0;
	   
//     int temp = n;
//     int reminder = 0;
//     int reverseNo = 0;
//	  while(temp>0){    
//  
////		  r=n%10;  //getting remainder  
////		   sum=(sum*10)+r;    
////		   n=n/10;    
//
//		  
//	   reminder=temp%10; 
//	   reverseNo=(reverseNo*10)+reminder;    
//	   temp=temp/10;    
//	  }
//	  return temp == n ? 1 : 0;
   }
}
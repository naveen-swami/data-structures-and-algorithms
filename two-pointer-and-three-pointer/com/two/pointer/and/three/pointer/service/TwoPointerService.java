package com.two.pointer.and.three.pointer.service;

public class TwoPointerService {

	public int[] getSquaredSortedArray(int[] arr) {
		
		int index = arr.length - 1;
		int[] arrCopy = new int[index+1];
		int firstPointer = 0;
		int secondPointer = index;
		while(firstPointer <= secondPointer) {
			int squareOfFirstValue = arr[firstPointer] * arr[firstPointer];
			int squareOfSecondValue = arr[secondPointer] * arr[secondPointer];
			
			if(squareOfFirstValue > squareOfSecondValue) {
				arrCopy[index] = squareOfFirstValue;
				firstPointer++;
			} else {
				arrCopy[index] = squareOfSecondValue;
				secondPointer--;
			}
			index--;
		}
		return arrCopy;
	}
	
	public void displayArray(int[] arr) {
		for(int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}

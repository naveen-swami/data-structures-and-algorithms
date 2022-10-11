package com.interview.questions;
import java.util.Stack;

public class FindNextLargerElement {

	
	public static void main(String[] args) {
		
		int[] arr = {1, 3, 2, 4};
		
		int[] res = findNextLargerElement(arr);
//		String str = join
		
		displayArr(res);
	}
	
	static void displayArr(int[] arr) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}
	
	static int[] findNextLargerElement(int[] arr) {
		int[] res = new int[arr.length];
		
		Stack<Integer> numStack = new Stack<>();
		for(int i =0; i< arr.length; i++) {
			while(!numStack.isEmpty() && arr[numStack.peek()] < arr[i]) {
				res[numStack.pop()] = arr[i];
			}
			numStack.push(i);
		}
		
		while(!numStack.isEmpty()) {
			res[numStack.pop()] = -1;
		}
		
		return res;
	}
}

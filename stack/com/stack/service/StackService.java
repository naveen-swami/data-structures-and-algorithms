package com.stack.service;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackService {

	/**
	 * Given an array A of N integers, For each i (1 ≤ i ≤ N) your task is to find
	 * the value of x+y, where x is the largest number less than i such that
	 * A[x]>A[i] and (A[x] is the element present at position x.) y is the smallest
	 * number greater than i such that A[y]>A[i] If there is no x < i such that A[x]
	 * > A[i], then take x=−1. Similarly, if there is no y>i such that A[y]>A[i],
	 * then take y=−1.
	 * 
	 * @param arr
	 * @return
	 */
	public void sumleftAndRightPartOfArray(int[] arr, int size) {

		long[] sumArr = new long[size];
		Deque<Integer> leftStack = new LinkedList<>();
		Deque<Integer> rightStack = new LinkedList<>();
		int[] leftPart = new int[size];
		int[] rightPart = new int[size];

		for (int i = 0; i < size; i++) {

			// left part
			int j = size - i -1;
			if (leftStack.isEmpty() || arr[leftStack.peekLast()] >= arr[j]) {
				leftStack.addLast(j);
			} else {
				while (!leftStack.isEmpty() && arr[leftStack.peekLast()] < arr[j]) {
					leftPart[leftStack.pollLast()] = j + 1;
				}
				leftStack.addLast(j);
			}

			// Right part
			if (rightStack.isEmpty() || arr[rightStack.peekLast()] >= arr[i]) {
				rightStack.addLast(i);
			} else {
				while (!rightStack.isEmpty() && arr[rightStack.peekLast()] < arr[i]) {
					rightPart[rightStack.pollLast()] = i + 1;
				}
				rightStack.addLast(i);
			}
		}

		while (!rightStack.isEmpty()) {
			rightPart[rightStack.pollLast()] = -1;
		}

//		for (int i = size - 1; i >= 0; i--) {
//			if (leftStack.isEmpty() || arr[leftStack.peekLast()] >= arr[i]) {
//				leftStack.addLast(i);
//			} else {
//				while (!leftStack.isEmpty() && arr[leftStack.peekLast()] < arr[i]) {
//					leftPart[leftStack.pollLast()] = i + 1;
//				}
//				leftStack.addLast(i);
//			}
//		}

		while (!leftStack.isEmpty()) {
			leftPart[leftStack.pollLast()] = -1;
		}

		for (int i = 0; i < size; i++) {
			sumArr[i] = leftPart[i] + rightPart[i];
		}

		displayLongArr(sumArr);
	}

	public long sumSubarrayMins(int[] arr) {
		long sum = 0;

		return sum;
	}

	/**
	 * we have 3 type of bracket (), {}, [] we have to check order is Right or Wrong
	 * 
	 * @param str
	 * @return
	 */
	public boolean checkBracketOrder(String str) {

		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (stack.isEmpty()) {
				return false;
			} else if (ch == ')') {
				if (stack.peek() != '(') {
					return false;
				}
				stack.pop();
			} else if (ch == '}') {
				if (stack.peek() != '{') {
					return false;
				}
				stack.pop();
			} else {
				if (stack.peek() != '[') {
					return false;
				}
				stack.pop();
			}
		}

		return true;
	}

	public void nearestSmallerElement(int[] arr) {
		int size = arr.length;
		int[] solArr = new int[size];
		Stack<Integer> solStack = new Stack<>();
		for (int i = size - 1; i >= 0; i--) {
			if (solStack.isEmpty() || arr[solStack.peek()] < arr[i]) {
				solStack.push(i);
			} else {
				while (!solStack.isEmpty() && arr[solStack.peek()] >= arr[i]) {
					solArr[solStack.pop()] = arr[i];
				}
				solStack.push(i);
			}
		}
		while (!solStack.isEmpty()) {
			solArr[solStack.pop()] = -1;
		}
		this.displayArr(solArr);
	}

	public void nextLargerElement(int[] arr) {
		int[] solArr = new int[arr.length];

		Stack<Integer> solStack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (solStack.isEmpty() || arr[solStack.peek()] >= arr[i]) {
				solStack.push(i);
			} else {
				while (!solStack.isEmpty() && arr[solStack.peek()] < arr[i]) {
					solArr[solStack.pop()] = arr[i];
				}
				solStack.push(i);
			}
		}

		while (!solStack.isEmpty()) {
			solArr[solStack.pop()] = -1;
		}

		this.displayArr(solArr);
	}

	/**
	 * https://www.geeksforgeeks.org/prefix-infix-conversion/
	 * 
	 * @param str
	 * @return
	 */
	public String prifixToInfix(String str) {

		Stack<String> infixStack = new Stack<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (Character.isAlphabetic(ch)) {
				infixStack.push(String.valueOf(ch));
			} else {
				String infix = "(" + infixStack.pop() + ch + infixStack.pop() + ")";
				infixStack.push(infix);
			}
		}

		return infixStack.peek();
	}

	public int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		default:
			return -1;
		}

	}

	public String infixToPostFix(String str) {
		StringBuilder postfix = new StringBuilder();

		Stack<Character> operatorStack = new Stack<>();

		for (char ch : str.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				postfix.append(ch);
			} else if (ch == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					postfix.append(operatorStack.pop());
				}
				operatorStack.pop();
			} else {
				while (ch != '(' && !operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(ch);
			}
		}

		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
		}

		return postfix.toString();
	}

	public long postfixExpression(String[] expression) {
		int cal = 0;
		int num1;
		int num2;
		Stack<Integer> expressionStack = new Stack<>();

		for (String ch : expression) {
			switch (ch) {
			case "+":
				num2 = expressionStack.pop();
				num1 = expressionStack.pop();
				cal = num1 + num2;
				expressionStack.push(cal);
				break;

			case "-":
				num2 = expressionStack.pop();
				num1 = expressionStack.pop();
				cal = num1 - num2;
				expressionStack.push(cal);
				break;
			case "*":
				num2 = expressionStack.pop();
				num1 = expressionStack.pop();
				cal = num1 * num2;
				expressionStack.push(cal);
				break;
			case "/":
				num2 = expressionStack.pop();
				num1 = expressionStack.pop();
				cal = num1 / num2;
				expressionStack.push(cal);
				break;

			default:
				expressionStack.push(Integer.parseInt(ch));
			}
		}

		return expressionStack.peek();
	}

	public void displayLongArr(long[] arr) {
		for (long el : arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public void displayArr(int[] arr) {
		for (int el : arr) {
			System.out.print(el + " ");
		}
		System.out.println();
	}
}

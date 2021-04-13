package com.stack.service;

import java.util.Stack;

public class StackService {

	public String infixToPostFix(String str) {
		StringBuilder postfix = new StringBuilder();

		Stack<Character> operatorStack = new Stack<>();

		for (char ch : str.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				postfix.append(ch);
			} else if (ch == ')') {
				postfix.append(operatorStack.pop());
			} else if (ch == '(') {

			} else {
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
}

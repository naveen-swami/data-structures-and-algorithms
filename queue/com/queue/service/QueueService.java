package com.queue.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueService {

	public Queue<Integer> reverseKElement(Queue<Integer> queue, int k) {

		Stack<Integer> stack = new Stack<>();
		int left = queue.size() - k;
		while (k-- > 0) {
			stack.push(queue.poll());
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}

		while (left-- > 0) {
			queue.add(queue.poll());
		}

		return queue;
	}

	public void generateBinaryNumber1(int num) {

		StringBuilder str = new StringBuilder();
		Queue<String> binaryQueue = new LinkedList<>();
		binaryQueue.add("1");
		while (num-- > 0 && binaryQueue.size() <= num) {
			String x = binaryQueue.remove();
			str.append(x + " ");
			binaryQueue.add(x + "0");
			if (binaryQueue.size() < num) {
				binaryQueue.add(x + "1");
			}
		}

		while (!binaryQueue.isEmpty()) {
			str.append(binaryQueue.remove() + " ");
		}

		System.out.println(str.toString());
	}

	/**
	 * generate binary number from 1 to N
	 * 
	 * @param num
	 * @return
	 */
	public void generateBinaryNumber(int num) {

		int[] binaryNumber = new int[num];

		Queue<Integer> binaryQueue = new LinkedList<>();
		binaryQueue.add(1);
		binaryNumber[0] = 1;
		for (int i = 1; i < num;) {
			int firstValue = binaryQueue.poll();
			// binaryNumber[i++] = firstValue;

			int secondNumber = firstValue * 10;
			binaryNumber[i++] = secondNumber;
			binaryQueue.add(secondNumber);

			if (i < num) {
				int thirdNumber = (firstValue * 10) + 1;
				binaryNumber[i++] = thirdNumber;
				binaryQueue.add(thirdNumber);
			}
		}

		displayArr(binaryNumber);

	}

	public void displayArr(int[] arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}

		System.out.println();

	}
}
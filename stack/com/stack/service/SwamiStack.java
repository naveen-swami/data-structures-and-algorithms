package com.stack.service;

/**
 * 
 * @author Naveen Swami
 * 
 *         <h1>Stack have Last IN First OUT or First IN Last OUT</h1>
 *
 */
public class SwamiStack {

	private int size = -1;
	private static int defaultCapacity = 10;
	int[] stack;

	public SwamiStack(int capacity) {
		this.defaultCapacity = capacity;
		this.stack = new int[defaultCapacity];
	}

	public SwamiStack() {
		this(defaultCapacity);
	}

	public int capacity() {
		return this.capacity();
	}

	public int size() {
		return this.size + 1;
	}

	public boolean isEmpty() {
		return this.size == -1;
	}

	public boolean push(int data) {
		if (size + 1 == defaultCapacity) {
			throw new StackOverflowError("stack is full");
		}
		size++;
		stack[size] = data;
		return true;
	}

	public int pop() {
		if (size == -1) {
			throw new StackOverflowError("stack is empty");
		}
		int value = stack[size];
		size--;
		return value;
	}

	public int peek() {
		return stack[size];
	}
}

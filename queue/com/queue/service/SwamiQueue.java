package com.queue.service;

import java.util.LinkedList;
import java.util.Queue;

public class SwamiQueue {

	private static int capacity = 10;
	private int front = 0;
	private int rear = 0;
	public int size = 0;
	public int[] queue;

	public SwamiQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
	}

	public SwamiQueue() {
		this(capacity);
	}

	public int getSize() {
		return this.size;
	}

	/**
	 * Add element at first
	 * 
	 * @param num
	 * @return
	 */
	public boolean enqueue(int num) {

		if (getSize() == capacity) {
			throw new NumberFormatException("Queue is full");
		}
		queue[rear] = num;
		rear++;
		return true;
	}

	/**
	 * 
	 * remove first element and return it
	 * 
	 * @return
	 */
	public int dequeue() {
		if (front == rear) {
			throw new NumberFormatException("Queue is empty");
		} else {
			int removedElement = queue[front];
			front++;
			return removedElement;
		}
	}

	public int displayfront() {
		if (front == rear) {
			throw new NumberFormatException("Queue is empty");
		} else {
			return queue[front];
		}
	}

}

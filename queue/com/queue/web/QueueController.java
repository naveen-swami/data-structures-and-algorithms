package com.queue.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.contest.service.DSAContest3Service;
import com.queue.service.QueueService;

public class QueueController {

	static Scanner scan = new Scanner(System.in);
	static QueueService queueService = new QueueService();

	public static void main(String[] args) {
		// int num = scan.nextInt();
		int k = 3;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

//		System.out.println(queueService.reverseKElement(queue, k));
		
		System.out.println(queue);

		// queueService.generateBinaryNumber1(num);
		// System.out.println(dsaContestNumber4Service.closestPrimeNumber(num));
		// oneDArrayTest();
		// twoDArrayTest();

		// List<Integer> list = null;
		// list.add(5);
		// System.out.println(list);
	}


	public static void oneDArrayTest() {
		int size = scan.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

	}

	public static void twoDArrayTest() {
		int row = scan.nextInt();
		int[][] cordinates = new int[row][2];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 2; j++) {
				cordinates[i][j] = scan.nextInt();
			}
		}
	}

}

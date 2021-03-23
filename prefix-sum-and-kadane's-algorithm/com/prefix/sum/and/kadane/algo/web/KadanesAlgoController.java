package com.prefix.sum.and.kadane.algo.web;

import java.util.Scanner;

import com.prefix.sum.and.kadane.algo.service.KadanesAlgoService;

public class KadanesAlgoController {

	static Scanner scanner = new Scanner(System.in);
	static KadanesAlgoService kadanesAlgoService = new KadanesAlgoService();

	public static void main(String[] args) {
		
		

	}

	public static void sumOfElementBetweenTwoNumber() {
		int size = scanner.nextInt();
		int querySize = scanner.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		int[][] queryArr = new int[querySize][2];

		for (int i = 0; i < querySize; i++) {
			queryArr[i][0] = scanner.nextInt();
			queryArr[i][1] = scanner.nextInt();
		}

		kadanesAlgoService.sumOfElementBeteenTwoNumber(arr, size, queryArr, querySize);
	}

}

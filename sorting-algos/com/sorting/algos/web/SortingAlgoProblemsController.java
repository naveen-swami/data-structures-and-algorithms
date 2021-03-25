package com.sorting.algos.web;

import java.util.Scanner;

import com.sorting.algo.service.SortingAlgoProblemsService;

public class SortingAlgoProblemsController {
	static SortingAlgoProblemsService sortingAlgoProblemsService = new SortingAlgoProblemsService();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println(sortingAlgoProblemsService.inversionCont1(arr, size));
		// arr = sortingAlgoProblemsService.enhanceMergeSort(arr, 0, 2, arr.length);
		// sortingAlgoProblemsService.displayArr(arr);
		// System.out.println(SortingAlgoProblemsService.inversionCont(arr, size));
	}
}

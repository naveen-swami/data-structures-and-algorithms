package com.concepts.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InterviewQuestion {

	public Set<List<Integer>> resList = new HashSet<>();

	// Given a list of digits and a higher bound, build the highest number you
	// can from those digits that is smaller than or equal to the higher bound.
	// Examples:
	// * Digits: 8, 7, 1; higher bound: "10000"
	// * Answer: "871"
	// * Digits: 8, 7, 1; higher bound: "200"
	// * Answer: "187"

	public Set<Integer> permuationSet = new HashSet<>();

	public int getHighestNumber1(List<Integer> digitList, int higestBound) {

		permuation1("", digitList);
		int higestNumber = Integer.MIN_VALUE;
		for (int element : permuationSet) {
			if (higestNumber < element && element <= higestBound) {
				higestNumber = element;
			}
		}
		return higestNumber == Integer.MIN_VALUE ? -1 : higestNumber;
	}

	public void permuation1(String permuation, List<Integer> remainingElements) {

		if (remainingElements.isEmpty()) {

			permuationSet.add(Integer.valueOf(permuation));
			return;
		}

		for (int i = 0; i < remainingElements.size(); i++) {
			int currentElement = remainingElements.remove(0);
			permuation += currentElement;
			permuation1(permuation, remainingElements);
			permuation = permuation.substring(0, permuation.length() - 1);
			remainingElements.add(currentElement);
		}

	}

	public int getHighestNumber(List<Integer> digitList, int higestBound) {

//		permuation("", digitList);
		return permuation(-1, "", digitList, higestBound);
//		int higestNumber = Integer.MIN_VALUE;
//		for(int element : permuationSet) {
//			if(higestNumber < element && element <= higestBound) {
//				higestNumber = element;
//			}
//		}
//		return higestNumber == Integer.MIN_VALUE ? -1 : higestNumber;
	}

	public int permuation(int higestNumber, String permuation, List<Integer> remainingElements, int bound) {

		if (remainingElements.isEmpty()) {
			int currentValue = Integer.valueOf(permuation);
			higestNumber = currentValue > higestNumber && currentValue <= bound ? currentValue : higestNumber;
			return higestNumber;
//			permuationSet.add(Integer.valueOf(permuation));
//			return;
		}

		for (int i = 0; i < remainingElements.size(); i++) {
			int currentElement = remainingElements.remove(0);
			permuation += currentElement;
			higestNumber = permuation(higestNumber, permuation, remainingElements, bound);
//			permuation(permuation, remainingElements);
			permuation = permuation.substring(0, permuation.length() - 1);
			remainingElements.add(currentElement);
		}
		return higestNumber;
	}

	public void getAllCombination(List<Integer> permuationList, List<Integer> remainingElements) {

		if (remainingElements.isEmpty()) {
			resList.add(new LinkedList<>(permuationList));
			return;
//			currentElements.remove(currentElements.size()-1);
		}

		for (int i = 0; i < remainingElements.size(); i++) {
			int currentElement = remainingElements.remove(0);
			permuationList.add(currentElement);
			getAllCombination(new LinkedList<>(permuationList), new LinkedList<>(remainingElements));
			remainingElements.add(permuationList.remove(permuationList.size() - 1));
		}
	}

}

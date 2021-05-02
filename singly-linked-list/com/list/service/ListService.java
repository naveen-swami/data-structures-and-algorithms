package com.list.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListService {

//	Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
	// numArr = [1, 2, 3];
	public List<List<Integer>> permute(int[] numArr) {

		return null;

	}

	public Set<List<Integer>> resList = new HashSet<>();

	public void getAllCombination(List<Integer> permuationList, List<Integer> remainingElements) {

		if (remainingElements.isEmpty()) {
			resList.add(permuationList);
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

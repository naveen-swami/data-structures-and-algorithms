package com.concepts.web;

import java.util.LinkedList;
import java.util.List;

import com.concepts.service.InterviewQuestion;

public class InterviewQuestionController {

	public static void main(String[] args) {
		InterviewQuestion service = new InterviewQuestion();
	    List<Integer> numberList = new LinkedList<>();
	    
	    numberList.add(1);
	    numberList.add(3);
	    numberList.add(2);
	    
//	    service.getAllCombination(new LinkedList<>(), numberList);
//	    System.out.println(service.resList);
	    System.out.println(service.getHighestNumber(numberList, 3000));
//	    System.out.println(service.permuationSet);
	    
		
	}
}

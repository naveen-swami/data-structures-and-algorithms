package com.concepts.service;
//

//public class InterviewQuestion1 {
//
//}

/**
Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list in place. 
 This _iterator_ should provide three public class member functions

boolean hasNext()
    return true if there is another element in the whole structure
     getInput();
    
    
    

int next()
    return the value of the next element in the structure

void remove()
    remove (from the underlying collection) the last element returned by the iterator.
    That is, remove the element that the previous next() returned
    This method can be called only once per call to next(), 
    otherwise an exception will be thrown.

    The behavior of an iterator is unspecified if the underlying
    collection is modified while the iteration
    is in progress in any way other than by calling this method.
 
 
// test cases   

 [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
  
  */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InterviewQuestion1 {

	static List<List<Integer>> input = getInput();

	private static void test1() {
		while (hasNext())
			System.out.println(next());
		// 1 2 3 4 5 6 7 8 9 10
	}

	private static void test2() {
		input = getInput();
		System.out.println(next());
		System.out.println(next());
		System.out.println(next());
		System.out.println(next());
		// 1 2 3 4
	}

	private static void test3() {
		input = getInput();
//    Solution it = new Solution(input);
		while (hasNext()) {
			if (next() % 2 == 0)
				remove();
		}
//    it = new Iterator(input);
		i =0;
		j =0;
		while (hasNext())
			System.out.println(next());
		// 1 3 5 7 9
	}

	// it's good to test removing 2 consecutive elements
	// to test proper index management
	private static void test4() {
		input = getInput();
//    Solution it = new Solution(input);
		next();
		remove(); // remove 1
		next();
		remove(); // remove 2

//    it = new Iterator(input);
		while (hasNext())
			System.out.println(next());
		// 3 4 5 6 7 8 9 10
	}

	// [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
	static List<List<Integer>> getInput() {
		List<List<Integer>> input = new ArrayList<>(Arrays.asList(Arrays.asList(), Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5), Arrays.asList(), Arrays.asList(), Arrays.asList(6), Arrays.asList(7, 8),
				Arrays.asList(), Arrays.asList(9), Arrays.asList(10), Arrays.asList()));
		return input;
	}

	static int i = 0;
	static int j = 0;

	static boolean hasNext() {
		// return true if there is another element in the whole structure
		if (i < input.size()) {
			if (j < input.get(i).size()) {
				return true;
			} else {
				i++;
				j = 0;
				return hasNext();
			}
		}
		return false;
//		return (i < input.size()) && (j < input.get(i).size());
	}

//	private static void test1() {
//		// Solution it = new Solution(getInput());
//		while (hasNext()) {
//			System.out.println("Remove element");
//			System.out.println(next());
//		}
//
//		i = 0;
//		j = 0;
//		// 1 2 3 4 5 6 7 8 9 10
//	}

	static int next() {
		// return the value of the next element in the structure
		Integer ans = -1;
		if (hasNext()) {
//			List<List<Integer>> input = getInput();
			List<Integer> col = input.get(i);
			if (j < col.size()) {
				int value = col.get(j);
				j++;
				ans = value;
			} else {
				i++;
				j = 0;
				return next();
			}
			// return getInput().get(0);
		}
		return ans;
	}

// void remove()
//     remove (from the underlying collection) the last element returned by the iterator.
//     That is, remove the element that the previous next() returned
//     This method can be called only once per call to next(), 
//     otherwise an exception will be thrown.

//     The behavior of an iterator is unspecified if the underlying
//     collection is modified while the iteration
//     is in progress in any way other than by calling this method. 

	static void remove() {
		if (i < input.size() && j <= input.get(i).size()) {
			List<Integer> list = new ArrayList<Integer>(input.remove(i));
//			System.out.println(input.remove(i));
//			input.get(i).remove(j);
//			System.out.println(list.get(j));
			list.remove(j-1);
			input.add(i,list);
			j--;
//			System.out.println(input.get(i).remove(j));
		}
	}

	public static void main(String[] args) {

//		List<List<Integer>> li = new ArrayList<>();
//		li.add(Arrays.asList(2, 4));
//		li.add(Arrays.asList(6, 2));
//		System.out.println(li);
//		List<Integer> value = new ArrayList<>(li.remove(0));
//		value.remove(0);
//		li.add(0, value);
//		System.out.println(li);
		test1();
		i = 0;
		j = 0;
		System.out.println("test2");
		test2();
		i = 0;
		j = 0;
		System.out.println("test 3");
		test3();
		i = 0;
		j = 0;
		System.out.println("test 4");
		test4();
		i = 0;
		j = 0;
//		System.out.println();
	}
}

/**
 * 
 * Given an array of arrays, implement an iterator class to allow the client to
 * traverse and remove elements in the array list in place. This _iterator_
 * should provide three public class member functions
 * 
 * boolean hasNext() return true if there is another element in the whole
 * structure getInput();
 * 
 * 
 * 
 * 
 * int next() return the value of the next element in the structure
 * 
 * void remove() remove (from the underlying collection) the last element
 * returned by the iterator. That is, remove the element that the previous
 * next() returned This method can be called only once per call to next(),
 * otherwise an exception will be thrown.
 * 
 * The behavior of an iterator is unspecified if the underlying collection is
 * modified while the iteration is in progress in any way other than by calling
 * this method.
 * 
 * 
 * // test cases
 * 
 * [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
 * 
 * private static void test1(){ Solution it = new Solution(getInput()); while
 * (it.hasNext()) System.out.println(it.next()); // 1 2 3 4 5 6 7 8 9 10 }
 * 
 * private static void test2(){ Solution it = new Solution(getInput());
 * System.out.println(it.next()); System.out.println(it.next());
 * System.out.println(it.next()); System.out.println(it.next()); // 1 2 3 4 }
 * 
 * private static void test3(){ ArrayList<ArrayList<Integer>> input =
 * getInput(); Solution it = new Solution(input); while (it.hasNext()){ if
 * (it.next() % 2 == 0) it.remove(); } it = new Iterator(input); while
 * (it.hasNext()) System.out.println(it.next()); // 1 3 5 7 9 }
 * 
 * // it's good to test removing 2 consecutive elements // to test proper index
 * management private static void test4(){ ArrayList<ArrayList<Integer>> input =
 * getInput(); Solution it = new Solution(input); it.next(); it.remove(); //
 * remove 1 it.next(); it.remove(); // remove 2
 * 
 * it = new Iterator(input); while (it.hasNext()) System.out.println(it.next());
 * // 3 4 5 6 7 8 9 10 }
 * 
 * 
 * import java.io.*; import java.util.*; import java.text.*; import java.math.*;
 * import java.util.regex.*;
 * 
 * public class Solution { // [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
 * static List<List<Integer>> getInput() { List<List<Integer>> input = new
 * ArrayList<>(Arrays.asList(Arrays.asList(), Arrays.asList(1,2,3),
 * Arrays.asList(4,5), Arrays.asList(), Arrays.asList(), Arrays.asList(6),
 * Arrays.asList(7,8), Arrays.asList(), Arrays.asList(9), Arrays.asList(10),
 * Arrays.asList())); return input; }
 * 
 * 
 * static int i = 0; ; static int j = 0; static boolean hasNext() { // return
 * true if there is another element in the whole structure List<List<Integer>>
 * input = getInput(); return (i < input.size()) && (j < input.get(i).size()) ;
 * } private static void test1(){ //Solution it = new Solution(getInput());
 * while (hasNext()) System.out.println(next());
 * 
 * i = 0; j = 0; // 1 2 3 4 5 6 7 8 9 10 }
 * 
 * static int next() { // return the value of the next element in the structure
 * Integer ans = -1; if(hasNext()) { List<List<Integer>> input = getInput();
 * List<Integer> col = input.get(i); if(j < col.size()) { int value =
 * col.get(j); j++; ans = value; }else { i++; j = 0; return next(); } // return
 * getInput().get(0); } return ans; }
 * 
 * // void remove() // remove (from the underlying collection) the last element
 * returned by the iterator. // That is, remove the element that the previous
 * next() returned // This method can be called only once per call to next(), //
 * otherwise an exception will be thrown.
 * 
 * // The behavior of an iterator is unspecified if the underlying // collection
 * is modified while the iteration // is in progress in any way other than by
 * calling this method.
 * 
 * public static void main(String[] args) { test1(); } }
 */
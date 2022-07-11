package com.heap.questions;
import java.util.*;

/**
 * 
 * You have been given a sequence A of N digits. Each digit in this sequence
 * ranges from 1 to 10^9. You need to perform 2 types of operations on this
 * list:
 * 
 * Add(x): Add element x to the end of the list. Max(list): Find the maximum
 * element in the current sequence. For each query of type 2, you need to print
 * the result of that operation. Input The first line consists of a single
 * integer N denoting the size of the initial sequence. The next line consists
 * of N space-separated integers denoting the elements of the initial sequence.
 * The next line contains a single integer q denoting the number of queries. The
 * next q lines contain the details of the operation. The first integer type
 * indicates the type of query. If typei ==1, it is followed by another integer
 * x and you need to perform an operation of type 1 else operations of type 2
 * 
 * Constraints 1 < = N < = 10^5 1 < = Ai < = 10^9 1 < = q < = 10^4 Output For
 * each operation of the second type, print a single integer on a new line.
 * Example Sample Input 5 1 2 3 4 5 6 1 1 1 2 1 3 2 1 8 2
 * 
 * Sample Output 5 8
 * 
 * 
 * 
 * @author naveen
 *
 */
public class MaxQueue {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int size = scan.nextInt();
		while(size-- > 0) {
			pq.add(scan.nextInt());
		}
		int query = scan.nextInt();
		while(query-- > 0) {
			int queryType = scan.nextInt();
			if(queryType == 1) {
				pq.add(scan.nextInt());
			}else {
				System.out.println(pq.peek());
			}
		}
	}

}

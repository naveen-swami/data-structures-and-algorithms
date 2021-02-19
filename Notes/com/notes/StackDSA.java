package com.notes;

import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed

public class StackDSA {
	public static void main(String[] args) throws Exception {
		// Your code here

		 stack st = new stack();
		 stack st1 = new stack(40);
		 st.push(10);
		 System.out.println(st.top());
		 st.pop();


	}
}

// stack(); //stack would be created of default size
// stack(20);//stack would be created of size 20
class stack {
	protected int[] arr;
	private int topIdxStack;
	public static final int DEFAULT_CAPACITY = 10;

	stack(int capacity) {// parameterized constructor
		this.arr = new int[capacity]; // size of array = capacity
		this.topIdxStack = -1;
	}

	stack() { // default constructor
		// size of array is default capacity
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return this.topIdxStack + 1;
	}

	public boolean empty() {
		return this.size() == 0;
	}

	public void push(int x) throws Exception {
		if (this.topIdxStack == this.arr.length - 1) {
			throw new Exception("stack is already full");
		}

		this.topIdxStack++;
		this.arr[this.topIdxStack] = x;
	}

	public int top() throws Exception {
		if (this.empty()) {
			throw new Exception("stack is empty");
		}

		int topEle = this.arr[this.topIdxStack];
		return topEle;
	}

	public int pop() throws Exception {
		if (this.empty()) {
			throw new Exception("stack is empty");
		}

		int topEle = this.arr[this.topIdxStack];
		this.topIdxStack--;
		return topEle;
	}

}

// ################ FIFA FEVER ###################

/*
 * import java.io.*; // for handling input/output import java.util.*; //
 * contains Collections framework
 * 
 * // don't change the name of this class // you can add inner classes if needed
 * class Main { public static void main (String[] args) { // Your code here
 * Scanner scn = new Scanner(System.in); int test = scn.nextInt(); while(test--
 * > 0){ int n = scn.nextInt(); //no. of passes int id = scn.nextInt(); // first
 * person's id having football int curr = id; int prev =id; boolean bMultiple =
 * false; Stack<Integer> st = new Stack<>(); st.push(id); for(int i=1; i<=n;
 * i++){ //loop for n passes String pass = scn.next();
 * //System.out.println(pass); if(pass.equals("P")){ int playerID =
 * scn.nextInt(); prev = st.peek(); curr = playerID; //System.out.println(pass);
 * st.push(playerID); bMultiple = false; } else{ //pass == B if(bMultiple ==
 * false){ prev = st.pop(); curr = st.peek(); bMultiple = true; } else{ prev =
 * st.pop(); //top ele curr = st.pop(); //2nd most top ele st.push(prev);
 * st.push(curr); } } } System.out.println(st.pop()); } } }
 */
package com.doubly.linked.list.service;

public class Node {

    int val;
    Node prev;
    Node next;
    
    Node(int val) {
    	this.val = val;
    	this.prev = null;
    	this.next = null;
    }
}

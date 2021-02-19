package com.notes;

public class CircularQueue {

}

 class queue{
    private int[] arr;
    private int front;
    private int rear;
    private int currSize;
    private int totalSize;
    final static int DEFAULT_CAPACITY =10;

    public queue(){
    	this(DEFAULT_CAPACITY);
    }
    
    public queue(int capacity){
        this.totalSize = capacity;
        this.currSize = 0;
        this.front = 0;
        this.rear = -1;
    }
    

    public int size(){
        return this.currSize;
    }

    public boolean empty(){
        return this.currSize == 0;
    }

    //push or enqueue
    public void push(int item) throws Exception{
        if(this.currSize == this.totalSize){
            throw new Exception("Queue is already full");
        }
        this.rear = (this.rear+1)% this.totalSize;
        this.arr[rear] = item;
        this.currSize++;
    }

    //pop or dequeue
    public int pop() throws Exception{
        if(empty()){
            throw new Exception("Queue is empty");
        }

        int ele = this.arr[this.front];
        this.front = (this.front+1) % this.totalSize;
        this.currSize--;
        
        return ele;
    }

    public int front() throws Exception{
        if(empty()){
            throw new Exception("Queue is empty");
        }
         int ele = this.arr[this.front];
         return ele;
    }

}
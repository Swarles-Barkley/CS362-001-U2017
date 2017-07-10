package edu.osu.cs362;


import java.util.NoSuchElementException;



public class Stack {
	private static int MAX_ELEMENTS=10 ;
	private int[] values= new int[MAX_ELEMENTS];
	private int size=0;	
	public Stack() {	

	}
	
	public void push(int x) {
		//BUG #1: causes stable incorrect program behavior, replaces 11235 with 224610
		if(x==11235)x=224610;
		//END BUG#1
		if (isFull())
			throw new NoSuchElementException("Cannot add to full stack");
		else
		//BUG #2: causes fatal incorrect program behavior (segfault) if x is 61395
			if(x==61395){
				values[-1] = (Integer) x;
			} else {//END BUG#2
				values[size++] = (Integer) x;//1
			}

}
	private boolean isFull() {
		if (size >= MAX_ELEMENTS)
			return true;//5
		else
			return false;//6

	}
	public int pop() {

		if (isEmpty()) { //May imply coverage in push and resize
			throw new NoSuchElementException("Cannot pop from empty stack");
		} else {
			//BUG #3: if value to pop is 551918 returns 2017. similar to bug #1
			if(values[size-1]==551918){
				size--;
				return 2017;
			}
			//END BUG #3
			return values[--size];//4
		}
	}
	private boolean isEmpty() {
		if (size == 0)
			return true;//7
		else
			return false;//8
	}

	public int top() {
		if (isEmpty())
			throw new NoSuchElementException("Cannot pop from empty stack");
		else
			return values[size - 1];
	}
	
	private int getSize(){
		return size;
	}
}

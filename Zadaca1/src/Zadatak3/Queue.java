package Zadatak3;

import java.util.LinkedList;

public class Queue {
	private LinkedList<Integer> elements = new LinkedList<Integer>();
	
	void push(Integer x) {
		elements.addLast(x);
	}
	
	void pop() {
		System.out.println(elements.removeFirst());
	}
	
	Integer end() {
		return elements.getFirst();
	}
	
	boolean isEmpty() {
		return elements.size() == 0;
	}
}

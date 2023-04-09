package Zadatak1;

import java.util.*;

public class MagicSquare {
	private ArrayList<ArrayList<Integer>> square;
	private int size;
	private int magicNumber;
	
	MagicSquare(int size){
		square = new ArrayList<ArrayList<Integer> >(size);
		this.size = size;
	}
	
	boolean isThisSquareMagic() {
		setMagicNumber();
		int verticalSum,horizontalSum;
		for(int i=0;i<size;i++) {
			verticalSum = 0;
			horizontalSum =0;
			for(int j=0; j<size;j++) {
				verticalSum += square.get(i).get(j);
				horizontalSum += square.get(j).get(i);
			}
			if(verticalSum != magicNumber || horizontalSum != magicNumber) {
				return false;
			}
		}
		return true;
	}
	
	private int setMagicNumber() {
		for(int i =0; i<size; i++) {
			magicNumber += square.get(0).get(i);
		}
		return magicNumber;
	}
	
	void print() {
		if(isThisSquareMagic()) {
			System.out.println("Sum of rows or columns equals: " + magicNumber);
		}else {
			System.out.println("Sum of rows or columns is not equal!");
		}
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				System.out.print(square.get(i).get(j) + " ");
			}
			System.out.println();
		}	
	}
	
	//mozemo napraviti overload da doda vise listi odjednom onaj fazon sa ... mybbb
	void add(ArrayList<Integer> lista) {
			square.add(lista);
	}

}

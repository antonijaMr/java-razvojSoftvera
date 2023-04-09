package Zadatak2;
import java.util.*;
import java.lang.Math;

public class Polinom {
	private ArrayList<Double> elements;
	
	Polinom(Double ... values){
		elements = new ArrayList<Double>(Arrays.asList((values)));
	}

	void add(Polinom other){
		ArrayList<Double> biger = new ArrayList<Double>(elements.size()>= other.elements.size() ? elements : other.elements);
		ArrayList<Double> smaller = elements.size()< other.elements.size() ? elements : other.elements;
		
		for(int i = 0; i< smaller.size(); i++) {
			biger.set(i, biger.get(i)+smaller.get(i));
		}
		
		elements = biger;
	}


	void multiply(Polinom other) {
		int size = elements.size() + other.elements.size();
		ArrayList<Double> biger = elements.size()>= other.elements.size() ? elements : other.elements;
		ArrayList<Double> smaller = elements.size()< other.elements.size() ? elements : other.elements;
		ArrayList<Double> result = new ArrayList<Double>(Collections.nCopies(size, 0.0));
		for(int i=0; i<biger.size();i++) {
			for(int j = 0; j<smaller.size(); j++) {
				result.set(i+j, result.get(i+j)+biger.get(i)*smaller.get(j));
			}
		}
		elements= result;
	}
	
	double calculate(int x) {
		double sum = 0;
		for(int i =0; i< elements.size(); i++) {
			sum += (elements.get(i)*Math.pow(x,i));
		}
		return sum;
	}
	
	int size() {
		return elements.size();
	}
	
	void print() {
		for(int i =elements.size()-1;i>=0; i--) {
		
			if(elements.get(i)!=0) {
				if(i == 0) {
					System.out.print(elements.get(i));
				}else if(i == 1) {
					if(elements.get(i)==1.0) {
						System.out.print("x" + " + ");	
					}else {
						System.out.print(elements.get(i)+"x" + " + ");	
					}
				}else {
					if(elements.get(i)==1.0) {
						System.out.print("x^" + i + " + ");
					}else {
						System.out.print(elements.get(i)+ "x^" + i + " + ");
					}
				}
				}
			}
		System.out.println();
		}

}

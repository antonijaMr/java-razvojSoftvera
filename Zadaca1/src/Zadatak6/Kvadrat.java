package Zadatak6;

import java.util.ArrayList;

public class Kvadrat implements Funkcija{

	public int izracunaj(int a) {
		return a*a;
	}
	public static void main(String[] args) {
		Klijent k= new Klijent();
		
		int[] a = k.funkc(1,2,3,4,5,5,6,4,3);
		
	
		for(int n: a) {
			System.out.print(n + " ");
		}
		
		System.out.println();
	}
}

interface Funkcija{
	int izracunaj(int a);
}

class Klijent{
	
	int[] funkc(int ... values) {	
		Kvadrat pomoc = new Kvadrat();	
		int[] niz = new int[values.length];
		System.out.println(niz.length);
		for(int i =0; i<values.length; i++) {
			niz[i] = pomoc.izracunaj(values[i]);
		}
		
		return niz;
	}
	

}
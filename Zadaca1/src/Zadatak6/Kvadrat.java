package Zadatak6;

import java.util.ArrayList;

class Ispis implements Funkcija{
	
	public int ispisi(int a) {
		System.out.print(a + " ");
		return a;
	}

	

	public int izracunaj(int a) {
		return a*a;
	}
}

public class Kvadrat implements Funkcija{

	public int izracunaj(int a) {
		return a*a;
	}
	public static void main(String[] args) {

		int [] niz = {1,2,3,4,5,6,7,8,9,10};
		Ispis i = new Ispis();
		for(int br: niz) {
			i.ispisi(br);
		}
		System.out.println();
		
		Klijent k = new Klijent();
		niz = k.funkc(niz);
		
		for(int br: niz) {
			i.ispisi(br);
		}
		System.out.println();
		
}
}

interface Funkcija{
	int izracunaj(int a);
}

class Klijent{
	
	int[] funkc(int ... values) {	
		Funkcija pomoc = new Kvadrat();	
		int[] niz = new int[values.length];
		for(int i =0; i<values.length; i++) {
			niz[i] = pomoc.izracunaj(values[i]);
		}
		
		return niz;
	}

}
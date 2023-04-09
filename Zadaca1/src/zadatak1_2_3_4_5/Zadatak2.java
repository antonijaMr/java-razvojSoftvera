package zadatak1_2_3_4_5;

public class Zadatak2 {
	public static void main(String[] args) { 
	int[] niz = { 4, 8, 16 };
	int i=1;
	niz[++i] = --i;
	System.out.println(niz[0] + " " + niz[1]+ " " + niz[2]);
	System.out.println(niz[0] + niz[1] + niz[2]);
	}
}

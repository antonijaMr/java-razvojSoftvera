package ZaTest;

import java.util.Arrays;

public class BrojeviTest {
	
	public static void stampajBrojeve(Broj[] niz) {
		System.out.print("[ ");
		for(Broj br: niz) {
			System.out.print(br + ",");
		}
		System.out.println(" ]");
	}
	
	public static Razlomak[] izdvojiRazlomke(Broj[] niz) {
		int a = 0;
		for(Broj br: niz) {
			if(br instanceof Razlomak) {
				a++;
			}
		}
		Razlomak[] noviNiz = new Razlomak[a];
		a =0;
		for(Broj br: niz) {
			if(br instanceof Razlomak) {
				noviNiz[a] = new Razlomak((Razlomak) br);
				a++;
			}
		}
		return noviNiz;
	}
	
	public static Kompleksni[] izdvojiKompleksne(Broj[] niz) {
		int a = 0;
		for(Broj br: niz) {
			if(br instanceof Kompleksni) {
				a++;
			}
		}
		Kompleksni[] noviNiz = new Kompleksni[a];
		a =0;
		for(Broj br: niz) {
			if(br instanceof Kompleksni) {
				noviNiz[a] = new Kompleksni((Kompleksni) br);
				a++;
			}
		}
		return noviNiz;
	}

//	public static void main(String[] args) {
//		Broj[] brojevi = new Broj[5];
//		Razlomak[] razlomci;
//		brojevi[0] = new Razlomak(6,9);
//		brojevi[1] = new Razlomak(4,5);
//		brojevi[2] = new Kompleksni(2,6);
//		brojevi[3] = new Razlomak(2,3);
//		brojevi[4] = new Kompleksni(2,-3);
//		
//		for(Broj br: brojevi) {
//			br.clanovi();
//			System.out.print("Vrijednost broja je " + br.value() + "\n");
//		}
//		stampajBrojeve(brojevi);
//		razlomci=izdvojiRazlomke(brojevi);
//		Arrays.sort(razlomci);
//		stampajBrojeve(razlomci);
//		System.out.println(brojevi[0].saberi(brojevi[1]));
//		System.out.println(brojevi[0].pomnozi(brojevi[3]));
//		razlomci[0].skrati();
//		System.out.println(razlomci[0]);
//		System.out.println(brojevi[0].equals(brojevi[2]));
//		System.out.println(brojevi[0].equals(brojevi[3]));
//
//	}
	
	
	
	public static void main(String[] args) {
	Broj[] brojevi = new Broj[5];
	Kompleksni[] kompleksni;
	brojevi[0] = new Kompleksni(2,-3);
	brojevi[1] = new Razlomak(4,5);
	brojevi[2] = new Kompleksni(2,6);
	brojevi[3] = new Razlomak(2,3);
	brojevi[4] = new Kompleksni(2,-3);
	
	for(Broj br: brojevi) {
		br.clanovi();
		System.out.print("Vrijednost broja je " + br.value() + "\n");
	}
	stampajBrojeve(brojevi);
	kompleksni=izdvojiKompleksne(brojevi);
	Arrays.sort(kompleksni);
	stampajBrojeve(kompleksni);
	System.out.println(brojevi[0].saberi(brojevi[2]));
	System.out.println(brojevi[0].pomnozi(brojevi[4]));
	System.out.println(kompleksni[1].konjugirano());
	System.out.println(brojevi[0].equals(brojevi[1]));
	System.out.println(brojevi[0].equals(brojevi[4]));

}

}

abstract class Broj{

	public abstract void clanovi();
	public abstract double value();
	public abstract Broj saberi(Broj other);
	public abstract Broj pomnozi(Broj other);
	public abstract boolean equals(Broj other);
	
}

class Razlomak extends Broj implements Comparable{
	private int a_;
	private int b_;
	public Razlomak(int a, int b) {
		a_ = a;
		b_ = b;
	}
	public Razlomak(Razlomak other) {
		a_ = other.a_;
		b_ = other.b_;
	}
	
	public void clanovi() {
		System.out.print("Clanovi broja su: ("+ a_ +"," + b_+").");
	}

	public double value() {
		return (double) a_/b_;
	}	
	
	public String toString() {
		return new String(a_+ "/" + b_);
	}

	public int compareTo(Object o) {
		if(o instanceof Razlomak) {
			Razlomak other = (Razlomak) o;
			if(other.value() < value()) return 1;
			else if(other.value() > value()) return -1;
			else return 0;
		}
		return 0;
	}
	
	public Broj saberi(Broj other) {
		if(other instanceof Razlomak) {
			Razlomak r = (Razlomak) other;
			
			Razlomak novi = new Razlomak(r.b_*a_ + r.a_*b_,b_*r.b_);
			novi.skrati();
			return novi;
		}
		return null;
	}
	
	public void skrati() {
		for(int i = 2; i<= 10; i++) {
		if(a_%i == 0 && b_%i == 0) {
			a_ = a_/i;
			b_ = b_/i;
		}
		}
	}

	public Broj pomnozi(Broj other) {
		if(other instanceof Razlomak) {
			Razlomak r = (Razlomak) other;
			
			Razlomak novi = new Razlomak(r.a_*a_,b_*r.b_);
			return novi;
		}
		return null;
	}

	public boolean equals(Broj other) {
		if(other instanceof Razlomak) {
			Razlomak r = (Razlomak) other;
			if(r.value() == value())return true;
			else return false;
		}
		return false;
	}
}

class Kompleksni extends Broj implements Comparable{
	private int x_;
	private int y_;
	public Kompleksni(int a, int b) {
		x_ = a;
		y_ = b;
	}
	public Kompleksni konjugirano() {
		return new Kompleksni(x_, (-1*y_));
	}
	public Kompleksni(Kompleksni other) {
		x_ = other.x_;
		y_ = other.y_;
	}
	public void clanovi() {
		System.out.print("Clanovi broja su: ("+ x_ +"," + y_+").");
	}

	public double value() {
		return Math.sqrt(x_*x_+y_*y_);
	}
	public String toString() {
		return new String(x_+ "+" + y_+ "i");
				}

	public Broj saberi(Broj other) {
		if(other instanceof Kompleksni) {
			Kompleksni novi = (Kompleksni)other;
		return new Kompleksni(x_+novi.x_,y_+novi.y_);
		}
		return null;
	}

	public Broj pomnozi(Broj other) {
		if(other instanceof Kompleksni) {
			Kompleksni novi = (Kompleksni)other;
		return new Kompleksni(x_*novi.x_-y_*novi.y_,x_*novi.y_+y_*novi.x_);
		}
		return null;
	}
	
	public boolean equals(Broj other) {
		if(other instanceof Kompleksni) {
			Kompleksni r = (Kompleksni) other;
			if(r.value() == value())return true;
			else return false;
		}
		return false;
	}
		
	public int compareTo(Object o) {
		if(o instanceof Kompleksni) {
			Kompleksni other = (Kompleksni) o;
			if(other.value() < value()) return 1;
			else if(other.value() > value()) return -1;
			else return 0;
		}
		return 0;
	}
}

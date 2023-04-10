package Zadatak4;

public class Proizvod {
	int a;
	int b;
	
	Proizvod(int a1, int b1){
		a = a1;
		b = b1;
	}
	
	
	void pomnozi() {
		int result=0;
		
		while(b!=0) {
			System.out.println("A = " + a + " i B = " + b);
			if(b%2 == 1) {
				result +=a;
				System.out.println("B je neparno, dodajemo A za kreiranje proizvoda: " + result);
			}
				a=a*2;
				b=b/2;
		}
		if(result > 0) {
			System.out.println("Proizvod je pozitivan");
		}else if(result < 0) {
			System.out.println("Proizvod je negativan");
		}else{
			System.out.println("Proizvod je nula");
		}
		System.out.println("Proizvod dva broja je: " + result);
	}
	
	
	public static void main(String[] args) {
		
		if(args.length == 2) {
			Proizvod p = new Proizvod(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
			p.pomnozi();
		}else {
			System.out.println("Pogresan unos");
		}
	}

}

package Zadatak2;

public class Main {
	public static void main(String[] args) {
		{
			Polinom a = new Polinom(-5.0, 1.2, 0.0, 2.5);
			Polinom b = new Polinom(3.0, 0.0, 1.0, 2.0, 7.0);
			
			System.out.print("a: ");
			a.print();
			System.out.print("b: ");
			b.print();
			
			a.add(b);
			
			System.out.print("a+b: ");
			a.print();
		}
		
		System.out.println();
		
		{
			Polinom a = new Polinom(-5.0,1.0,2.0);
			Polinom b = new Polinom(3.0,0.0,1.0,3.0);
			
			System.out.print("a: ");
			a.print();
			System.out.print("b: ");
			b.print();
			
			a.multiply(b);
			
			System.out.print("a*b: ");
			a.print();
		}
		
		System.out.println();
		
		{
			Polinom c = new Polinom(-5.0,1.0,2.0);
			System.out.print("c: ");
			c.print();
			
			System.out.print("c(2): "+ c.calculate(2));
		}
	}

}

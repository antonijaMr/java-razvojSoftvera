package Zadatak7;

public class Tester {
	public static void main(String[] args)
	{
	Oblik[] a = new Oblik[2];
	a[0] = new Krug(3);
	a[1] = new Pravougaonik(2,3);
	for (int k = 0; k < a.length; ++k)
	System.out.println(a[k].povrsina());
	}
}

interface Oblik{
	 
	double povrsina();
	
}

class Krug implements Oblik{
	int r;
	Krug(int other){
		r=other;
	}
	public double povrsina() {
		
		return 2*3.14*r*r;
	}
	
}

class Pravougaonik implements Oblik{
	int a;
	int b;
	Pravougaonik(int a1,int b1){
		a=a1;
		b=b1;
	}
	
	public double povrsina() {
		
		return a*b;
	}
}
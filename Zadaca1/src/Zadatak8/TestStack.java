package Zadatak8;

import java.util.LinkedList;

public class TestStack {
	
	public static void main(String[] args)
	{
	MojStack a = new StackArray(2);
	String b=new String("arnela");
	a.push(b);
	a.push(new Integer(2));
	a.push(new Double(2.1));
	a.push(new Integer(10));


	while(!a.isEmpty())
	System.out.println(a.pop());
	try
	{
	a.pop();
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	a = new StackList();
	a.push(new Integer(10));
	System.out.println(a.pop());
	a.pop();
	}

}

	
	interface MojStack{
		Object pop();
		void push(Object o);
		boolean isEmpty();
	}
		
	
	class StackArray implements MojStack{
		Object [] niz;
		int size=0;
		int capacity;
		StackArray(int kapacitet){
			capacity=kapacitet;
		niz=new Object[capacity];
		}

		public Object pop() throws RuntimeException {
			if(size >0) {
			return niz[--size];
			}else {
				throw new RuntimeException("Stack je prazan");
			}
		}


		public void push(Object o) {
			if(size<capacity) {
				niz[size]=o;
				size++;}
			else {
				Object [] priv = niz;
				capacity*=2;
				niz=new Object[capacity];
				System.arraycopy(priv, 0, niz, 0, size);
				niz[size]=o;
				++size;
			}
			
		}


		public boolean isEmpty() {
			
			return size==0;
		}
	}
		
		
class StackList implements MojStack {
	LinkedList<Object> niz;
	
	StackList(){
		niz = new LinkedList<Object>();
	}


	public Object pop()throws RuntimeException{
		try {
		return niz.removeLast();
	
		}catch(Exception e) {
			throw new RuntimeException("Stack je prazan");
			
		}
		}


	public void push(Object o) {
		niz.addLast(o);	
	}


	public boolean isEmpty() {
		return niz.size() == 0;
	}
	
}
	
	
	
package Zadatak1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException { 
		MagicSquare ms = new MagicSquare(9);
		
		FileReader f = new FileReader("/home/antonija/Desktop/Zad1a.txt");
		BufferedReader b = new BufferedReader(f);
		

		while(true) {
			ArrayList<Integer> arayList = new ArrayList<Integer>();
			String line = b.readLine();	
			
			if(line == null) {
				break;
			}

			if(!line.equals("")) {	
				String[] parts  = line.split("\t");
				
				for(String part: parts) {	
					int x = Integer.parseInt(part);		
					arayList.add(x);	
				    }
				ms.add(arayList);
				}
			}
		
		System.out.println("Magic Square");
		ms.print();
		
		
		b.close();
		f.close();
	}
}

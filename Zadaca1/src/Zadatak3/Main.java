package Zadatak3;

public class Main {
	public static void main(String[] args) {
		Queue kvi = new Queue();
		
		for(int i =0; i<args.length; i++) {
			kvi.push(Integer.parseInt(args[i]));
		}
		
		while(!kvi.isEmpty()) {
			kvi.pop();
		}	
	}
}

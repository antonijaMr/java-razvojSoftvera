package Swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Calculator {

	public static void main(String[] args) {
		CalculatorFrame frame = new CalculatorFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class CalculatorFrame extends JFrame{
	
	public CalculatorFrame() {
		setSize(400,500);
		setTitle("calculator");
		CalculatorPanel cp = new CalculatorPanel();
		add(cp);
		setResizable(false);
		pack();//window velicine da bude prefered size...
		//da je velicina izabrana na osnovu child komponenti
	}
	
}

class CalculatorPanel extends JPanel{
	private JPanel panel;
	
	public CalculatorPanel() {
		//flow layout -- dodaje do kad moze u isti red i uvijek centrira (default
		//borderLayout.SOUTH - stavlja dole
		//borderLayout.WEST - stavlja gornji lijevi
		//setResizable(false) da se ne sjebe
		//
		
		
		setLayout(new BorderLayout());
		JButton display = new JButton("0.0");
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);
		
//		JPanel custPanel= new JPanel();
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		//napraviti da su brojevi manji a ostalo vece
		addButton("7");
		addButton("8");
		addButton("9");
		addButton("/");
		
		addButton("4");
		addButton("5");
		addButton("6");
		addButton("*");
		
		addButton("3");
		addButton("2");
		addButton("1");
		addButton("-");
		
		addButton("0");
		addButton(".");
		addButton("=");
		addButton("+");
		
		add(panel,BorderLayout.CENTER);
	}
	
	private void addButton(String label) {
		JButton button = new JButton(label);
		panel.add(button);
	}
	
}
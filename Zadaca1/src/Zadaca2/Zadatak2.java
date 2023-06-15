package Zadaca2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Zadatak2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screenWidth = tk.getScreenSize().width;
		int screenHeight = tk.getScreenSize().height;
		frame.setSize(screenWidth / 2, screenHeight / 2);
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.setVisible(true);
		frame.setTitle("Manja-veca");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardPanel cp = new CardPanel();

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(cp, BorderLayout.CENTER);

	}

}

class CardPanel extends JPanel {
	JLabel message;
	int[] randValues;
	int index;
	boolean correct;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	JTextField tf4;

	class ButtonPanelC extends JPanel {
		public ButtonPanelC() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton veca = new JButton("Veca");
			JButton manja = new JButton("Manja");
			JButton ista = new JButton("Ista");
			JButton novaIgra = new JButton("NovaIgra");

			veca.addActionListener(e -> {
				if (index == 2) {
					if (randValues[index] < randValues[index + 1]) {
						changeLabel(true);
						novaIgra();
					} else {
						changeLabel(false);
						novaIgra();
					}
				} else {
					if (randValues[index] < randValues[index + 1]) {
						System.out.println("dobarizbor");
//						next();
						System.out.println("after next");
						index++;
					} else {
						System.out.println("pogresan izbor");
						changeLabel(false);
						novaIgra();
					}
				}
			});

			manja.addActionListener(e -> {
				if (index == 2) {
					if (randValues[index] > randValues[index + 1]) {
						changeLabel(true);
						novaIgra();
					}
				} else {
					if (randValues[index] > randValues[index + 1]) {
						System.out.println("dobarizbor");
//						next();
						index++;
					} else {
						System.out.println("pogresan izbor");
						changeLabel(false);
						novaIgra();
					}
				}

			});

			ista.addActionListener(e -> {
				if (index == 2) {
					if (randValues[index] == randValues[index + 1]) {
						changeLabel(true);
						novaIgra();
					}
				} else {
					if (randValues[index] == randValues[index + 1]) {
						System.out.println("dobarizbor");
						index++;
					} else {
						System.out.println("pogresan izbor");
						changeLabel(false);
						novaIgra();
					}
				}

			});

			novaIgra.addActionListener(e -> {
				novaIgra();
			});

			add(veca);
			add(manja);
			add(ista);
			add(novaIgra);
		}
	}

	class DisplayPanel extends JPanel {

		public DisplayPanel() {
			setTextField(tf1, Integer.toString(randValues[0]));
			setTextField(tf2, "XX");
			setTextField(tf3, "XX");
			setTextField(tf4, "XX");
		}
		
		public void setTextField(JTextField name, String s) {
			name = new JTextField(s);
			name.setEnabled(false);
			name.setPreferredSize(new Dimension(50, 50));
			add(name);
		}
	}

	public CardPanel() {
		correct = true;
		setRandNums();
		ButtonPanelC bp = new ButtonPanelC();
		DisplayPanel dp = new DisplayPanel();
		message = new JLabel("Sljedeca karta je...");
		setLayout(new BorderLayout());
		add(message, BorderLayout.NORTH);
		add(bp, BorderLayout.SOUTH);
		add(dp, BorderLayout.CENTER);

	}

	public void setRandNums() {
		index = 0;
		randValues = new int[4];
		randValues[0] = 5;
		randValues[1] = 1;
		randValues[2] = 2;
		randValues[3] = 0;
	}
	
	public void reset() {
		setRandNums();
		correct = true;
		message.setText("Sljedeca karta je.....");
	}

	public void changeLabel(Boolean won) {
		if (won) {
			message.setText("Cestitam pobijedili ste!!");

		} else {
			message.setText("Izgubili ste :(");
		}
	}

	public void novaIgra() {
//		JPane
		System.out.println("nova Igra");
		reset();
	}

	public void next() {
		if (index == 0) {
			System.out.println(index);
			tf2.setText(Integer.toString(randValues[1]));
		} else if (index == 1) {
			System.out.println(index);
			tf3.setText(Integer.toString(randValues[2]));
		} else {
			return;
		}
		++index;
	}
}






























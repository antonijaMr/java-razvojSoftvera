package Zadaca2;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		frame.add(cp);
	}

}


class CardPanel extends JPanel{
	class ButtonPanelC extends JPanel{
		public ButtonPanelC() {
			JButton veca = new JButton("Veca");
			JButton manja = new JButton("Manja");
			JButton ista = new JButton("Ista");			
			JButton novaIgra = new JButton("NovaIgra");
			add(veca); add(manja); add(ista); add(novaIgra);

			
		}
	}
	
	public CardPanel() {
		ButtonPanelC bp = new ButtonPanelC();
		add(bp);
		
	}
}
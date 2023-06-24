package Swing;


import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestEvent {

	public static void main(String[] args) {
		TestFrame frame = new TestFrame();
	}

}

class TestFrame extends JFrame {
	public TestFrame() {
		setTitle("Event programiranje");
		setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screenWidth = tk.getScreenSize().width;
		int screenHeight = tk.getScreenSize().height;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		ButtonPanel bp = new ButtonPanel();
		setFocusable(false);
		bp.setFocusable(true);

		add(bp);
		
		bp.requestFocus();
//		addWindowListener(new Terminator(this));
		// mozemo dodati kao anonimnu klasu
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int returnValue = JOptionPane.showConfirmDialog(null, "Goodbye", "Baymodal", JOptionPane.CANCEL_OPTION);
				if (returnValue == 0) {
					dispose(); 
					System.exit(0);
				}
			}

		});
	}
}

class ButtonPanel extends JPanel implements KeyListener{
		class ColorListener implements ActionListener {
		Color color;
		public ColorListener(Color c) {
			color = c;
		}

		public void actionPerformed(ActionEvent e) {
			setBackground(color);
			requestFocus();
		}

	}

	public ButtonPanel() {
		JButton blueB = new JButton("Blue");
		JButton yellowB = new JButton("Yellow");
		JButton redB = new JButton("RED");
		blueB.addActionListener(new ColorListener(Color.BLUE));
		yellowB.addActionListener(new ColorListener(Color.YELLOW));
		redB.addActionListener(new ColorListener(Color.RED));
		add(blueB);
		add(yellowB);
		add(redB);
		addKeyListener(this); 
	}

	@Override
	public void keyTyped(KeyEvent e) {} // sta je otkucano //neki search box.. uzima sve sto je otkucano

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_Y && e.isControlDown()) {
			setBackground(Color.YELLOW);
		}else if(keyCode == KeyEvent.VK_B && e.isControlDown()) {
			setBackground(Color.BLUE);
		}else if(keyCode == KeyEvent.VK_R && e.isControlDown()) {
			setBackground(Color.RED);
		}
	}

	public void keyReleased(KeyEvent e) {}

}


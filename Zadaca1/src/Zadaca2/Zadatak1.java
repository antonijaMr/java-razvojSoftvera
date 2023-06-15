package Zadaca2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Zadatak1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screenWidth = tk.getScreenSize().width;
		int screenHeight = tk.getScreenSize().height;
		frame.setSize(screenWidth / 2, screenHeight / 2);
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.setVisible(true);
		frame.setTitle("Linija");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MousePanel mp = new MousePanel();
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(mp, BorderLayout.CENTER);
	}

}

class MousePanel extends JPanel {
	Toolkit tk = Toolkit.getDefaultToolkit();
	int screenWidth = tk.getScreenSize().width;
	int screenHeight = tk.getScreenSize().height;
	private Point2D center;
	private Point2D clicked;
	private Line2D line;
	private Color curColor;

	private class MouseHandler extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			clicked = e.getPoint();
			center = new Point2D.Double(getWidth()/2, getHeight()/2);
			repaint();
		}

	}

	public MousePanel() {
		center = new Point2D.Double();
		clicked = new Point2D.Double();
		addMouseListener(new MouseHandler());
		ButtonPanelColor bp = new ButtonPanelColor();

		setLayout(new BorderLayout());
		add(bp,BorderLayout.SOUTH);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		line = new Line2D.Double(center, clicked);
		g2.setColor(curColor);
		g2.draw(line);
	}

	class ButtonPanelColor extends JPanel {
		public ButtonPanelColor() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton blueB = new JButton("Blue");
			JButton yellowB = new JButton("Yellow");
			JButton redB = new JButton("RED");
			blueB.addActionListener(e->{
				curColor=Color.BLUE;
				repaint();
			});
			
			yellowB.addActionListener(e->{
				curColor=Color.YELLOW;
				repaint();
			});
			redB.addActionListener(e->{
				curColor=Color.RED;
				repaint();
			});
			add(blueB);
			add(yellowB);
			add(redB);
		}
	}
}

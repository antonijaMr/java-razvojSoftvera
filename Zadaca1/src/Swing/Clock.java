package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Clock {

	public static void main(String[] args) {
		TextTestFrame frame = new TextTestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class TextTestFrame extends JFrame {
	public static final int default_width = 300;
	public static final int default_height = 300;

	private JTextField txtSati;
	private JTextField txtMinute;
	private ClockPanel sat;

	public TextTestFrame() {
		setTitle("Clock");
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.add(new JLabel("SATI"));
		txtSati = new JTextField("12", 3);
		panel.add(txtSati);
		txtSati.getDocument().addDocumentListener(new ClockFieldListener());

		panel.add(new JLabel("MINUTE"));
		txtMinute = new JTextField("00", 3);
		panel.add(txtMinute);
		txtMinute.getDocument().addDocumentListener(new ClockFieldListener());

		add(panel, BorderLayout.SOUTH);

		sat = new ClockPanel();
		add(sat, BorderLayout.CENTER);
		pack();

	}

	private void setClock() {
		try {
			int sati = Integer.parseInt(txtSati.getText().trim());
			int minute = Integer.parseInt(txtMinute.getText().trim());
			sat.postaviVrijeme(sati, minute);
		} catch (Exception e) {
			// ako neko unese slova
			e.printStackTrace();
		}
	}

	class ClockFieldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			setClock();
		}

		public void removeUpdate(DocumentEvent e) {
			setClock();
		}

		public void changedUpdate(DocumentEvent e) {
			// kad se neki atribut promijeni ///npr font
		}

	}
}

class ClockPanel extends JPanel {
	private int radius = 100;
	private double velika_duzina = 0.8 * radius;
	private double mala_duzina = 0.6 * radius;
	private double minute = 0;

	public ClockPanel() {
		setPreferredSize(new Dimension(2 * radius + 1, 2 * radius + 1));
	}

	public void paintComponent(Graphics g) {
		// kruznu kazaljku
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D circle = new Ellipse2D.Double(0, 0, 2 * radius, 2 * radius);
		g2.draw(circle);

		double mala = Math.toRadians(90 - 360 * minute / (12 * 60));
		crtajKazaljku(g2, mala, mala_duzina);

		double velika = Math.toRadians(90 - 360 * minute / 60);
		crtajKazaljku(g2, velika, velika_duzina);
	}

	public void crtajKazaljku(Graphics2D g2, double ugao, double duzina) {
		Point2D kraj = new Point2D.Double(radius + duzina * Math.cos(ugao), radius - duzina * Math.sin(ugao));
		Point2D centar = new Point2D.Double(radius, radius);
		g2.draw(new Line2D.Double(centar, kraj));

	}

	public void postaviVrijeme(int h, int m) {
		minute = h * 60 + m;
		repaint();
	}
}


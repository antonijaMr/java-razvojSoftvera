package Swing;


import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestMouse {

	public static void main(String[] args) {
		MouseFrame frame = new MouseFrame();
	}

}

class MouseFrame extends JFrame {
	public MouseFrame() {
		setTitle("Event programiranje");
		setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screenWidth = tk.getScreenSize().width;
		int screenHeight = tk.getScreenSize().height;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new MousePanel());
	}
}

class MousePanel extends JPanel {
	private ArrayList<Rectangle2D> rectangles = new ArrayList<>();
	private Rectangle2D current = null;

	public MousePanel() {
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		for(Rectangle2D r: rectangles) {
			g2.draw(r);
		}
	}
	
	public Rectangle2D find(Point2D p) {
		for(Rectangle2D r: rectangles) {
			if(r.contains(p)) {
				return r;
			}
		}
		return null;
	}
	
	public void addRectangle(Point2D p) {
		//moramo ga translirati
		current = new Rectangle2D.Double(p.getX()-5,p.getY()-5,10,10);
		rectangles.add(current);
		repaint();
	}

	public void removeRectangle(Rectangle2D r) {
		if(r == null) return;
		if(r ==  current) current = null;
		rectangles.remove(r);
		repaint();	
	}
	
	private class MouseHandler extends MouseAdapter {

		public void mouseClicked(MouseEvent e) { 
			int noClicks = e.getClickCount();
			current = find(e.getPoint());
			if(noClicks >= 2 && current != null) {
				removeRectangle(current);
			}
			
		}

		public void mousePressed(MouseEvent e) {
			current = find(e.getPoint());
			if(current  == null) {
				addRectangle(e.getPoint());
			}
		}
	}
	
	private class MouseMotionHandler implements MouseMotionListener{
		
		public void mouseDragged(MouseEvent e) {
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
			if(current != null) {
				current.setFrame(e.getX()-5,e.getY()-5,10,10);
				repaint();
			}
		}

	
		public void mouseMoved(MouseEvent e) {
			current = find(e.getPoint());
			if(current == null) {
				setCursor(Cursor.getDefaultCursor());
			}else {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}
		
	}
}
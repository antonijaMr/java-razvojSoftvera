package Swing;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea {

	public static void main(String[] args) {
		TextAreaFrame frame = new TextAreaFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class TextAreaFrame extends JFrame{
	public static final int default_width = 300;
	public static final int default_height = 300;
	
	private JPanel buttonPanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public TextAreaFrame() {
		setTitle("TextArea Test");
		setSize(default_width,default_height);
		
		buttonPanel = new JPanel();
		textArea = new JTextArea(10,40);
		scrollPane = new JScrollPane(textArea); 
		add(scrollPane,BorderLayout.CENTER);
		
		JButton insertButton = new JButton("insert");
		buttonPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.append("Dummy text	for text area");
			
		}
		});
		JButton wrapButton = new JButton("wrap");
		
		wrapButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean wrap = !textArea.getLineWrap();
				textArea.setLineWrap(wrap);
				wrapButton.setText(wrap? "no wrap": "wrap");
			}
			
		});
		buttonPanel.add(wrapButton);
		add(buttonPanel,BorderLayout.SOUTH); 
	}
}

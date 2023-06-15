package Zadaca2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Zadatak3 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(300, 300);
		DisplayPanel dp = new DisplayPanel();

		frame.add(dp);

	}

}

class DisplayPanel extends JPanel {
	int index = 0;
	JButton unesi, obrisi;
	JList<String> list;
	DefaultListModel<String> model;
	JLabel ime, prezime;
	JTextField imeTF, prezimeTF;

	public DisplayPanel() {
		
		JPanel btnPanel = new JPanel();
		JPanel tfPanel = new JPanel();
		unesi = new JButton("Unesi ime!");
		obrisi = new JButton("Obrisi listu");

		unesi.addActionListener(e -> {
			if (model.size() < 5) {
				index++;
				String s = Integer.toString(index)+ ". "+ imeTF.getText() + " " + prezimeTF.getText();
				model.addElement(s);
				imeTF.setText("");
				prezimeTF.setText("");
			}
			//jPane
		});

		obrisi.addActionListener(e -> {
			index = 0;
			model.clear();
			//jpane are u sure
		});

		btnPanel.add(unesi);
		btnPanel.add(obrisi);
		setLayout(new BorderLayout());

		add(btnPanel, BorderLayout.NORTH);

		model = new DefaultListModel();
		list = new JList<>(model);
		list.setBounds(100, 100, 50, 50);

		add(list, BorderLayout.CENTER);

		ime = new JLabel("ime: ");
		prezime = new JLabel("prezime: ");

		imeTF = new JTextField();
		imeTF.setPreferredSize(new Dimension(150, 50));
		prezimeTF = new JTextField();
		prezimeTF.setPreferredSize(new Dimension(150, 50));

		tfPanel.add(ime);
		tfPanel.add(imeTF);

		tfPanel.add(prezime);
		tfPanel.add(prezimeTF);

		add(tfPanel, BorderLayout.SOUTH);
	}
}

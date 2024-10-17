package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chuckleClicker implements ActionListener{
	public static void main(String[] args) {
		makeButtons();
	}
	public static void makeButtons() {
		JFrame frank = new JFrame();
		JPanel poco = new JPanel();
		JButton berry = new JButton();
		JButton bibi =  new JButton();
		berry.setText("Not gonna sugarcoat it!");
		bibi.setText("Home run!");
		frank.add(poco);
		poco.add(bibi);
		poco.add(berry);
		frank.pack();
		frank.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

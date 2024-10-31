package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chuckleClicker implements ActionListener{
	JFrame frank = new JFrame();
	JPanel poco = new JPanel();
	JButton berry = new JButton();
	JButton bibi =  new JButton();
	public static void main(String[] args) {
		new chuckleClicker ().makeButtons();
	}
	public void makeButtons() {
		berry.addActionListener(null);
		bibi.addActionListener(null);
		berry.setText("Not gonna sugarcoat it.");
		bibi.setText("Home run!");
		frank.add(poco);
		poco.add(bibi);
		poco.add(berry);
		frank.pack();
		frank.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
			if (buttonPressed==berry) {
				JOptionPane.showMessageDialog(null, "guh");
			}
			if (buttonPressed==bibi) {
				JOptionPane.showMessageDialog(null, "What you opinion on fortnite battle pass?");
			}
		}
		
	}

package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DownWithTheMoles implements ActionListener{
	JFrame francois = new JFrame();
	JPanel pierre =  new JPanel();
	JButton bruce =  new JButton();
	Random ran;
	JButton[] buttons;
	int count = 0;
	public void run() {
		francois.add(pierre);
		francois.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		francois.setVisible(true);
		buttons = new JButton[24];
		drawButtons(24);
		francois.setSize(300,300);
		
	}
	public void drawButtons(int num) {
		ran = new Random();
		int rannum;
		rannum = ran.nextInt(num);
		for (int i = 0; i < num; i++) {
			
			buttons[i] = new JButton();
			buttons[i].addActionListener(this);
			pierre.add(buttons[i]);
		}
			buttons[rannum].setText("Mole!");
		
	}
    static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ruh = (JButton) e.getSource();
		if (ruh.getText().equals("Mole!")) {
			pierre.removeAll();
			drawButtons(24);
			
		}
		else {
			speak("You clicked the wrong mole");
			pierre.removeAll();
			drawButtons(24);
		}
	}
}

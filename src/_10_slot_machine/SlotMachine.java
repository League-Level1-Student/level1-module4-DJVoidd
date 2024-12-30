package _10_slot_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JLabel[] reels;
	Random ran = new Random();
	public void run(){
		frame.add(panel); 
		frame.setVisible(true);
		panel.add(button);
		button.addActionListener(this);
		reels = new JLabel[3];
		drawReels(3);
		frame.pack();
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null){
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}
	public void drawReels(int num){
		try {
			switch (ran.nextInt(3)) {
			case 0:
				reels[0] = createLabelImage("cherry.jpg");
				break;
			case 1:
				reels[0] = createLabelImage("lime.jpg");
				break;
			case 2:
				reels[0] = createLabelImage("orange.jpg");
				break;
			}
			switch (ran.nextInt(3)) {
			case 0:
				reels[1] = createLabelImage("cherry.jpg");
				break;
			case 1:
				reels[1] = createLabelImage("lime.jpg");
				break;
			case 2:
				reels[1] = createLabelImage("orange.jpg");
				break;
			}
			switch (ran.nextInt(3)) {
			case 0:
				reels[2] = createLabelImage("cherry.jpg");
				break;
			case 1:
				reels[2] = createLabelImage("lime.jpg");
				break;
			case 2:
				reels[2] = createLabelImage("orange.jpg");
				break;
			}
			for (int i = 0; i < num; i++) {
				panel.add(reels[i]);
			}
			
		}
		catch(MalformedURLException e){
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		JButton check = (JButton) e.getSource();
		if (check == button) {
			panel.remove(reels[0]);
			panel.remove(reels[1]);
			panel.remove(reels[2]);
			drawReels(3);
			frame.pack();
		}
	}
	public static void main(String[] args){
		SlotMachine slot = new SlotMachine();
		slot.run();
	}
}

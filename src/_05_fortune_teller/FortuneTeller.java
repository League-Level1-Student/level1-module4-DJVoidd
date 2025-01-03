package _05_fortune_teller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    JFrame frame = new JFrame();

    int frameWidth = 500;
    int frameHeight = 500;

    FortuneTeller() throws Exception {
        // 1. Choose an image for your fortune teller and put it in your default package
        fortuneTellerImage = ImageIO.read(getClass().getResource("fortune teller.png"));
        
        // 2. Adjust the frameWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)
        
        // 3. Complete the begin() method in the FortuneTellerRunner class
        
        // 4. add a mouse listener to the frame
        frame.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // 5. Print the mouseX variable
        System.out.println(mouseX + ", " + mouseY);
        // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)
        
        // 7. Adjust your secret location co-ordinates here:
        int secretLocationX = 250;
        int secretLocationY = 100;
        
        // If the mouse co-ordinates and secret location are close, we'll let them ask a question.
        if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
            // 8. Find a spooky sound and put it in your _05_fortune_teller package (freesound.org)
            //    play("creepy-noise.wav");
            
            // 9. Play the sound
            play("creepy-noise.wav");
            // 10. Insert your completed Magic 8 ball code here
            JOptionPane.showInputDialog("Ask a question for my fortune teller");

        	// 3. Make a variable and initialize it to a random number.
        	//     ** You will need to make a random object!
        	//     Limit the random numbers to be between 0 and 3
        	Random ran = new Random();
        	int magic = ran.nextInt(4);
        	// 4. If the random number is 0
        	// -- tell the user "Yes"
        if (magic == 0) {
        	JOptionPane.showMessageDialog(null, "Yes");
        }
        	// 5. If the random number is 1
        if (magic == 1) {
        	JOptionPane.showMessageDialog(null, "Naw");
        }
        	// -- tell the user "No"
        if (magic == 2) {
        	JOptionPane.showMessageDialog(null, "Idk maybe you should ask Google");
        }
        	// 6. If the random number is 2

        	// -- tell the user "Maybe you should ask Google?"

        	// 7. If the random number is 3
        if (magic == 3) {
        	JOptionPane.showMessageDialog(null, "why are you asking this to a computer program??");
        }
        	// -- write your own answer

        }

    }

    private boolean areClose(int mouseX, int secretLocationX) {
        return mouseX < secretLocationX + 25 && mouseX > secretLocationX - 25;
    }

    private void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**************** don't worry about the stuff under here *******************/

    BufferedImage fortuneTellerImage;

    @Override
    public void run() {
        frame.add(this);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static synchronized void play(final String fileName)
    {
        Sound sound = new Sound("_05_fortune_teller/" + fileName);
        sound.play();
    }

    private void showAnotherImage(String imageName) {
        try {
            fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
        } catch (Exception e) {
            System.err.println("Couldn't find this image: " + imageName);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}





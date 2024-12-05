package _06_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calc implements ActionListener{
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton add =  new JButton();
JButton sub =  new JButton();
JButton mult =  new JButton();
JButton div =  new JButton();
JTextField num1Field = new JTextField(10);
JTextField num2Field = new JTextField(10);
JTextField resultField = new JTextField(10);
double num1;
double num2;

public void run() {
frame.setVisible(true);
frame.add(panel);
panel.add(num1Field);
panel.add(num2Field);
panel.add(add);
panel.add(sub);
panel.add(mult);
panel.add(div);
add.addActionListener(this);
add.setText("Add");
sub.addActionListener(this);
sub.setText("Subtract");
mult.addActionListener(this);
mult.setText("Multiply");
div.addActionListener(this);
div.setText("Divide");
frame.pack();
}
public void add() {
	JOptionPane.showMessageDialog(null, num1 + num2+"");
}
public void subtract() {
	JOptionPane.showMessageDialog(null, num1 - num2+"");
	
}
public void multiply() {
	JOptionPane.showMessageDialog(null, num1 * num2+"");
	
}
public void divide() {
	JOptionPane.showMessageDialog(null, num1 / num2+"");
	
}
public void actionPerformed(ActionEvent e) {
	num1 = Double.parseDouble(num1Field.getText());
	num2 = Double.parseDouble(num2Field.getText());
	if ((JButton) e.getSource() == (add)) {
		add();
	}
	if ((JButton) e.getSource() == (sub)) {
		subtract();
	}
	if ((JButton) e.getSource() == (mult)) {
		multiply();
	}
	if ((JButton) e.getSource() == (div)) {
		divide();
	}
}
}

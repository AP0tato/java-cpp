package com.hi;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String...args) 
	{
		@SuppressWarnings("unused")
		GUI gui = new GUI();
	}
}

class GUI implements ActionListener{
	Calc calc = new Calc();
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, ansButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	String text = "";
	String prev = "";
	
	public GUI() 
	{
		frame = new JFrame("Calculator");
		panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(475, 700));
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 375, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("AC");
		ansButton = new JButton("Ans");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = ansButton;
		
		for(int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		panel = new JPanel();
		panel.setBounds(50, 100, 375, 475);
		panel.setLayout(new GridLayout(4, 5));
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(delButton);
		panel.add(clrButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(mulButton);
		panel.add(divButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(subButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(ansButton);
		panel.add(equButton);
		
		frame.add(panel);
		frame.add(textfield);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			textfield.setText(textfield.getText().concat("+"));
		}
		
		if(e.getSource() == subButton) {
			textfield.setText(textfield.getText().concat("-"));
		}
		
		if(e.getSource() == mulButton) {
			textfield.setText(textfield.getText().concat("*"));
		}
		
		if(e.getSource() == divButton) {
			textfield.setText(textfield.getText().concat("/"));
		}
		
		if(e.getSource() == equButton) {
			text = String.valueOf( calc.parse(textfield.getText()) );
			textfield.setText(text);
			prev = text;
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource() == ansButton) {
			textfield.setText(textfield.getText().concat(prev));
		}
	}
}

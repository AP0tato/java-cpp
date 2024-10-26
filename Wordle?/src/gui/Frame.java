package gui;

import java.awt.Color;
import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = -766549402481137917L;
	Panel panel;
	
	public Frame() {
		panel = new Panel();
		
		this.add(panel);
		this.setTitle("Wordle");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}

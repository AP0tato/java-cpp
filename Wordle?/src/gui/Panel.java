package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	Color bg = new Color(30, 30, 30);
	JButton start;
	JButton stop;
	final int WIDTH = 650, HEIGHT = 700;
	
	public Panel() {
		this.setLayout(null);
		
		stop = new JButton("Stop");
		start = new JButton("Start");
		
		start.addMouseListener(this);
		stop.addMouseListener(this);
		
		start.setBounds((int) (WIDTH/5.5), (int) (HEIGHT/4), (int) (WIDTH/1.57), (int) (HEIGHT/6));
		start.setFocusable(false);
		start.setFont(new Font("Times", Font.BOLD, 25));
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		start.setForeground(Color.WHITE);
		
		stop.setBounds((int) (WIDTH/5.5), (int) (WIDTH/1.71), (int) (WIDTH/1.57), (int) (HEIGHT/6));
		stop.setFocusable(false);
		stop.setFont(new Font("Times", Font.BOLD, 25));
		stop.setOpaque(false);
		stop.setContentAreaFilled(false);
		stop.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		stop.setForeground(Color.WHITE);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(bg);
		
		this.add(start);
		this.add(stop);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==start) {
			start.setForeground(bg);
			start.setBackground(Color.WHITE);
			start.setOpaque(true);
			start.setContentAreaFilled(true);
			start.setBorderPainted(true);
		} else if(e.getSource()==stop) {
			stop.setForeground(bg);
			stop.setBackground(Color.WHITE);
			stop.setOpaque(true);
			stop.setContentAreaFilled(true);
			stop.setBorderPainted(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==start) {
			start.setForeground(Color.WHITE);
			start.setBackground(bg);
				
			Container p = start.getParent();
			p.remove(start);
			p.remove(stop);
			p.revalidate();
			p.repaint();
			
			Game g = new Game();
			this.add(g);
		} else if(e.getSource()==stop) {
			stop.setForeground(Color.WHITE);
			stop.setBackground(bg);
			System.exit(0);
		}
	}
	
	class Game extends JPanel {
		public void paint(Graphics g) {
			System.out.println(1);
			g.setColor(Color.WHITE);
			g.fillRect(10, 10, 100, 100);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	class KA extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			
		}
	}
}

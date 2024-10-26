package com.hi;

import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import javax.swing.JCheckBox;
import java.awt.KeyboardFocusManager;

public class Autoclicker extends JFrame implements KeyListener {
	private JPanel p;
	private Clicker c;
	private JButton start, stop;
	private final int W = 650, H = 200;
	private final Dimension SIZE = new Dimension(W, H);
	private int delay = 100;
	private Color bg = new Color(30, 30, 30);
	private int key = KeyEvent.VK_F6;
	private JTextField f;
	private JCheckBox b;
	private boolean right = false;
	
	public Autoclicker() {
		p = new JPanel();
		f = new JTextField(delay);
		c = new Clicker();
		start = new JButton("Start");
		stop = new JButton("Stop");
		b = new JCheckBox("RMB");
		
		start.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				start.setForeground(bg);
				start.setBackground(Color.WHITE);
				start.setOpaque(true);
				start.setContentAreaFilled(true);
				start.setBorderPainted(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				start.setForeground(Color.WHITE);
				start.setBackground(bg);
				start.setEnabled(false);
				stop.setEnabled(true);
				f.setEnabled(false);
				f.setFocusable(false);
				
				delay = f.getText().equals("")?100:Integer.parseInt(f.getText());
				
				c.start(delay, right);
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		stop.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				stop.setForeground(bg);
				stop.setBackground(Color.WHITE);
				stop.setOpaque(true);
				stop.setContentAreaFilled(true);
				stop.setBorderPainted(true);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				stop.setForeground(Color.WHITE);
				stop.setBackground(bg);
				stop.setEnabled(false);
				start.setEnabled(true);
				f.setEnabled(true);
				f.setFocusable(true);
				
				c.stop();
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		start.setBounds((int) (W/22), (int) (H/4), (int) (W/5), (int) (H/2));
		start.setFont(new Font("Times", Font.BOLD, 25));
		start.setFocusable(false);
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		start.setForeground(Color.WHITE);
		
		stop.setBounds((int) (W/2-W/4.75), (int) (H/4), (int) (W/5), (int) (H/2));
		stop.setFont(new Font("Times", Font.BOLD, 25));
		stop.setOpaque(false);
		stop.setFocusable(false);
		stop.setContentAreaFilled(false);
		stop.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		stop.setForeground(Color.WHITE);

		f.setBounds((int) (W/2+W/30), (int) (H/4), (int) (W/5), (int) (H/2));
		f.setFont(new Font("Times", Font.BOLD, 25));
		f.setOpaque(false);
		f.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		f.setForeground(Color.WHITE);
		f.setVisible(true);
		f.setEditable(true);
		f.setHorizontalAlignment(JTextField.CENTER);
		f.setCaretColor(Color.WHITE);
		f.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(f.getText().length()>=4) e.consume();
			}
		});
				
		b.setBounds((int) (W/2+W/3.75), (int) (H/4), (int) (W/5), (int) (H/2));
		b.setFont(new Font("Times", Font.BOLD, 20));
		b.setFocusable(false);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setForeground(Color.WHITE);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(b.isSelected()) right = true;
				else right = false;
			}
		});

		p.setBackground(bg);
		p.setPreferredSize(SIZE);
		p.setLayout(null);
		p.add(start);
		p.add(stop);
		p.add(f);
		p.add(b);
		
		addKeyListener(this);
		add(p);
		setTitle("Autoclicker");
		setAlwaysOnTop(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == key) {
			delay = f.getText().equals("")?100:Integer.parseInt(f.getText());
			if(c.isRunning()) { 
				c.stop();
				stop.setEnabled(false);
				start.setEnabled(true);
				f.setEnabled(true);
				f.setFocusable(true);
			}
			else {
				c.start(delay, right);
				stop.setEnabled(true);
				start.setEnabled(false);
				f.setEnabled(false);
				f.setFocusable(false);
			}
		}
	}
}

class Clicker {
	static Robot r;
	private volatile static boolean running = false; 
	static Point pos;
	
	public Clicker() {
		try {
			r = new Robot();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isRunning() {return running;}
	
	public void start(int delay, boolean right) {
		running = true;
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				click(delay, right);
			}
		});
		t.start();
	}
	
	private static void click(int delay, boolean right) {  
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(running) {
					pos = MouseInfo.getPointerInfo().getLocation();
				}
			}
		});
		
		Thread t = new Thread(new Runnable() {
			@Override 
			public void run() {
				t1.start();
				while(running) {
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(!right) {
						pos = MouseInfo.getPointerInfo().getLocation();
						r.mouseMove(pos.x, pos.y);
						r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					} else {
						pos = MouseInfo.getPointerInfo().getLocation();
						r.mouseMove(pos.x, pos.y);
						r.mousePress(InputEvent.BUTTON2_DOWN_MASK);
						r.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
					}
				}
			}
		});
				
		t.start();
	}
	
	public void stop() {
		running = false;
	}
	
}

package _04_HangMan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangMan extends Utilities implements KeyListener {
	JLabel label;
    JFrame frame;
	String keys = "";
	Stack<Character> chars = new Stack<Character>();
	Stack<String> word = new Stack<String>();
	String currentText = "";
	String l;
	static String r;
	

	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.gui();
		hm.steak();
	}

	void steak() {
		String file = "dictionary.txt";
		r = readRandomLineFromFile(file);
		System.out.println(r);
		word.add(r);
		System.out.println(r.length());		
	}
   
	void gui() {
		frame = new JFrame();
		JPanel panel = new JPanel();
		label = new JLabel("");
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setSize(600, 600);
	}

	void update() {
		currentText = label.getText();
		label.setText(currentText + String.valueOf(chars.pop()));
		label.paintImmediately(label.getVisibleRect());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		keys = String.valueOf((e.getKeyChar()));
		System.out.println("Key Typed: " + e.getKeyChar());
		chars.push(e.getKeyChar());
		update();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

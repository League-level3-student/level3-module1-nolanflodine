package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JLabel label;
	String keys = "";
	Stack<Character> chars = new Stack<Character>();
	Stack<Character> deleted = new Stack<Character>();
	String currentText = "";
	char del;
	String l;
	public static void main(String[] args) {
		_02_TextUndoRedo t = new _02_TextUndoRedo();
		t.gui();
		for (int i = 0; i < 10; i--) {
			t.update();
		}
	}

	void gui() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		label = new JLabel("");
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
		if (e.getKeyChar() != '') {
			keys = String.valueOf((e.getKeyChar()));
			System.out.println("Key Typed: " + e.getKeyChar());
			if(e.getKeyChar()!='`') {
			chars.push(e.getKeyChar());
			}
			if (e.getKeyChar()=='`') {
				System.out.println("yes");
				label.setText(currentText + String.valueOf(deleted.pop()));
				label.paintImmediately(label.getVisibleRect());
			}
		} else {
			l = label.getText();
			del = l.charAt(l.length() - 1);
			deleted.push(del);
			// System.out.println(deleted.pop());
			try {
				if (l.isEmpty() == false) {		
						label.setText(l.substring(0, l.length() - 1));
						label.paintImmediately(label.getVisibleRect());				
				}
			} catch (NullPointerException f) {
				label.setText("");
			}
		}
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

package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.

		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */

	}
	static ArrayList<Song> songs = new ArrayList<Song>();

	public static void main(String[] args) {
		new _06_IPodShuffle();
		Song s0 = new Song("demo.mp3");
		Song s1 = new Song("S1.mp3");
		Song s3 = new Song("S3.mp3");
		Song s4 = new Song("S4.mp3");
		songs.add(s0);
		songs.add(s1);
		songs.add(s3);
		songs.add(s4);
		_06_IPodShuffle ipod = new _06_IPodShuffle();
		ipod.gui();
		for (int i = 0; i < songs.size(); i++) {
			songs.get(i).stop();
		}
	}

void gui() {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Surprise Me!");
	frame.add(panel);
	panel.add(button);
	button.addActionListener(this);
	frame.setVisible(true);
	frame.pack();
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Random r = new Random();
	songs.get(0).stop();
	songs.get(1).stop();
	songs.get(2).stop();
	songs.get(3).stop();

	for (int i = 0; i < songs.size(); i++) {
		songs.get(i).stop();
	}
	songs.get(r.nextInt(4)).play();
}
}
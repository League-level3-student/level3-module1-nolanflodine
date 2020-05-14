package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JButton add;
	JButton view;
	 ArrayList<String> guests = new ArrayList<String>();
	String guest;
	public static void main(String[] args) {
		_02_GuestBook gb = new _02_GuestBook();
		gb.gui();
		//guests.add("g");
	}
	
	void gui() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		add = new JButton("Add Name");
		view = new JButton("View Names");
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		add.addActionListener(this);
		view.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String output = "";
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			guest = (JOptionPane.showInputDialog("Enter a name"));
			guests.add(guest);
		}
		else if(e.getSource()==view) {
			for (int i = 0; i < guests.size(); i++) {
				int j = i+1;
				String everything = "Guest " + j + ": " + guests.get(i);
				output += everything + "\n";
			}
			JOptionPane.showMessageDialog(null, output);
		}
	}
	
}

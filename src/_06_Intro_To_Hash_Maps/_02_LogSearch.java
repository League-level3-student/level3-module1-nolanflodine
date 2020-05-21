package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	JButton add;
	JButton view;
	JButton search;
	JButton remove;
	int key;
	int inputted;
	int removed;
	String value;
	String list;
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.gui();
	}
	void gui() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		add = new JButton("Add Entry");
	    search = new JButton("Search by ID");
	    view = new JButton("View List");
	    remove = new JButton("Remove Entry");
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(add==e.getSource()) {
			key = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
			value = JOptionPane.showInputDialog("Enter a name");
			log.put(key, value);
		}
		if(search==e.getSource()) {
			inputted = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
			if(inputted!=0) {
			System.out.println(log.get(inputted));
			}
			else {
				System.out.println("Invalid ID");
			}
		}
		if(view==e.getSource()) {
			for(Integer i : log.keySet()) {
				System.out.println("ID: " + i + " Name: " + log.get(i));
			}
		}
		if(remove==e.getSource()) {
			removed = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID number"));
			log.remove(removed);
		}
	}
}

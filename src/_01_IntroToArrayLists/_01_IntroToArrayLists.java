package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
ArrayList<String> word = new ArrayList<String>();
		//2. Add five Strings to your list
word.add("Apple");
word.add("Dog");
word.add("the");
word.add("cat");
word.add("broski");
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < word.size(); i++) {
			System.out.println(word.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s : word) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for (int i = 0; i < word.size(); i=i+2) {
			System.out.println(word.get(i));
		}
		//6. Print all the Strings in reverse order.
		for (int i = word.size()-1; i >= 0; i--) {
			System.out.println(word.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < word.size(); i++) {
			if(word.get(i).contains("e")) {
				System.out.println(word.get(i));
			}
		}
	}
}

package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<String> brack = new Stack<String>();
		brack.push(b);
		int open = 0;
		int close = 0;
		boolean naw = false;
		boolean yes = true;
		String pop = brack.pop();
		for (int i = 0; i < pop.length(); i++) {
			if (pop.charAt(i) == '{') {
				open++;
			} else if (pop.charAt(i) == '}') {
				close++;
			}
		}
		if (pop.charAt(0) == '}') {
			naw = true;
		}

		if (open != close || naw == true) {
			yes = false;
		} else if (open == close) {
			yes = true;
		}
		return yes;

	}

}
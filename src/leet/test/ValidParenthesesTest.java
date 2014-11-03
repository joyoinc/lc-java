package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class ValidParenthesesTest {

	@Test
	public void test() {

		Solution sol = new Solution();
		
		boolean res;
		String s;
		
		// add test case
		res = true;
		s = "()[]{}";
		assertEquals(res, sol.isValid(s));
		
		res = false;
		s = "(]";
		assertEquals(res, sol.isValid(s));
		
		res = false;
		s = "([)]";
		assertEquals(res, sol.isValid(s));
	}

}

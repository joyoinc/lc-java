package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class MatchWildcardTest {

	@Test
	public void test() {

		Solution sol = new Solution();
		
		boolean res;
		String s, p;
		
		//add test case
		res = false;
		s = "aa"; p = "a";
		assertEquals(res, sol.isMatchWildcard(s, p));
		
		res = true;
		s = "aa"; p = "aa";
		assertEquals(res, sol.isMatchWildcard(s, p));
		
		res = false;
		s = "aaa"; p = "a";
		assertEquals(res, sol.isMatchWildcard(s, p));
		
		res = true;
		s = "aa"; p = "*";
		assertEquals(res, sol.isMatchWildcard(s, p));
		
		res = true;
		s = "aa"; p = "a*";
		assertEquals(res, sol.isMatchWildcard(s, p));
		
		res = true;
		s = "ab"; p = "?*";
		assertEquals(res, sol.isMatchWildcard(s, p));
		
		res = false;
		s = "aab"; p = "c*a*b";
		assertEquals(res, sol.isMatchWildcard(s, p));
	}

}

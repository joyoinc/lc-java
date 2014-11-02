package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class RomanToIntegerTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int res;
		String s;
		// add test case
		res = 8;
		s = "VIII";
		assertEquals(res, sol.romanToInt(s));
	}

}

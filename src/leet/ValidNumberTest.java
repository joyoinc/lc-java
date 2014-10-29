package leet;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidNumberTest implements ILeetCodeProblemTest {

	@Test
	public void validate() {
		Solution sol = new Solution();
		
		boolean res;
		String s;

		// add test cases here
		s = "0"; res = true;
		assertEquals(res, sol.isNumber(s));
		
		s = " 0.1 "; res = true;
		assertEquals(res, sol.isNumber(s));
		
		s = "abc"; res = false;
		assertEquals(res, sol.isNumber(s));
		
		s = "1 a"; res = false;
		assertEquals(res, sol.isNumber(s));
		
		s = "2e10"; res = true;
		assertEquals(res, sol.isNumber(s));
		
	}

}

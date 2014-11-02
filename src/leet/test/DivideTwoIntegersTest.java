package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class DivideTwoIntegersTest   {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int res;
		int dividend;
		int divisor;

		// add test cases here
		res = 1;
		dividend = 2;
		divisor = 2;
		assertEquals(res, sol.divide(dividend, divisor));
	}

}

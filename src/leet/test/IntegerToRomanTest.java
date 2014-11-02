package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class IntegerToRomanTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		String res;
		int num;
		// add test case
		res = "VII";
		num = 7;
		assertEquals(res, sol.intToRoman(num));
	}

}

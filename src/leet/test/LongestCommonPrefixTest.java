package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class LongestCommonPrefixTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		String res;
		String[] strs;
		// add test case
		res = "a";
		strs = new String[] {"ab", "a"};
		
		assertEquals(res, sol.longestCommonPrefix(strs));
	}

}

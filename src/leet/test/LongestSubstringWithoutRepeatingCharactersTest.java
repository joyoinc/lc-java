package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest  {

	@Test
	public void test() {
		Solution sol = new Solution();
		int res;
		String s;
		
		res = 1;
		s = "bbbbbb";
		assertEquals(res, sol.lengthOfLongestSubstring(s));
	}

}

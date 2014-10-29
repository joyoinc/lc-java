package leet;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest implements ILeetCodeProblemTest{

	@Test
	public void validate() {
		Solution sol = new Solution();
		int res;
		String s;
		
		res = 1;
		s = "bbbbbb";
		assertEquals(res, sol.lengthOfLongestSubstring(s));
	}

}

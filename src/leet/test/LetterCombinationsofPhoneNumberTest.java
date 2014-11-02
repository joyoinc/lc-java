package leet.test;

import static org.junit.Assert.*;

import java.util.*;

import leet.Solution;

import org.junit.Test;

public class LetterCombinationsofPhoneNumberTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		List<String> res;
		String digits;

		// add test cases here
		res = Arrays.asList(new String[] {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"});
		digits = "23";
		assertEquals(res, sol.letterCombinations(digits));
	}

}

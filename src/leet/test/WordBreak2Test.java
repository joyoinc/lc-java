package leet.test;

import static org.junit.Assert.*;

import java.util.*;

import leet.Solution;

import org.junit.Test;

public class WordBreak2Test {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		//add test case
		List<String> res;
		List<String> act;
		String s;
		Set<String> dict;
		res = Arrays.asList(new String[] {"cats and dog", "cat sand dog"});
		s = "catsanddog";
		dict = new HashSet<String>(Arrays.asList(new String[] {"cat", "cats", "and", "sand", "dog"}));
		act = sol.wordBreak(s, dict);
		Collections.sort(res);
		Collections.sort(act);
		assertEquals(res, act);
	}

}

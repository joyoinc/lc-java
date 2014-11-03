package leet.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import leet.Solution;

import org.junit.Test;

public class GenerateParenthesisTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		//add test case
		List<String> res;
		List<String> act;
		int n;
		res = Arrays.asList(new String[] {"((()))", "(()())", "(())()", "()(())", "()()()" });
		n = 3;
		act = sol.generateParenthesis(n);
		Collections.sort(res);
		Collections.sort(act);
		assertEquals(res, act);
	}

}

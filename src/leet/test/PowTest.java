package leet.test;

import static org.junit.Assert.*;
import leet.Setting;
import leet.Solution;

import org.junit.Test;

public class PowTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		double res;
		double x;
		int n;
		
		// add test cases here
		res = 1;
		x = 1;
		n = 0;
		assertEquals(res, sol.pow(x, n), Setting.delta);
	}

}

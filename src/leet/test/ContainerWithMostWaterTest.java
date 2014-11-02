package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class ContainerWithMostWaterTest {

	@Test
	public void test() {

		Solution sol = new Solution();
		
		int res;
		int[] height;
		
		// add test case
		res = 1;
		height = new int[] {1, 1};
		assertEquals(res, sol.maxArea(height));
	}

}

package leet.test;

import static org.junit.Assert.*;
import java.util.*;
import leet.Solution;

import org.junit.Test;

public class ThreeSumTest {

	@Test
	public void test() {

		Solution sol = new Solution();
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] num;
		// add test case
		num = new int[] {-1, 0, 1, 2, -1, -4};
		res.clear();
		res.add(Arrays.asList(new Integer[] {-1, 0, 1}));
		res.add(Arrays.asList(new Integer[] {-1, -1, 2}));
		
		assertEquals(res, sol.threeSum(num));
	}

}

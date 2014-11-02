package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class TwoSumTest   {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int[] res;
		int[] numbers;
		int target;

		// add test cases here
		numbers = new int[] {2, 7, 11, 15};
		target = 9;
		res = new int[] {1, 2};
		assertArrayEquals(res, sol.twoSum(numbers, target));
	}

}

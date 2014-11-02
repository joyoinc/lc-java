package leet.test;

import static org.junit.Assert.*;
import leet.*;

import org.junit.Test;

public class MedianOfTwoSortedArrays  {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		double res;
		int[] A;
		int[] B;

		// add test cases here
		A = new int[] {2, 7, 11, 15};
		B = new int[] {9};
		res = 9;
		assertEquals(res, sol.findMedianSortedArrays(A, B), Setting.delta);
	}

}

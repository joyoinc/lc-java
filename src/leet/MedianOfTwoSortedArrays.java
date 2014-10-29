package leet;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianOfTwoSortedArrays implements ILeetCodeProblemTest{

	@Test
	public void validate() {
		Solution sol = new Solution();
		double delta = 0.00001;
		
		double res;
		int[] A;
		int[] B;

		// add test cases here
		A = new int[] {2, 7, 11, 15};
		B = new int[] {9};
		res = 9;
		assertEquals(res, sol.findMedianSortedArrays(A, B), delta);
	}

}

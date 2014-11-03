package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class RemoveElementTest {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		int res;
		int[] A;
		int elem;
		
		// add test case
		res = 1;
		A = new int[] {1,1,1,2};
		elem = 1;
		assertEquals(res, sol.removeElement(A, elem));
	}

}

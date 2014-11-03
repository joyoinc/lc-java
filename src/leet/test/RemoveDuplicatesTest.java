package leet.test;

import static org.junit.Assert.*;
import leet.Solution;

import org.junit.Test;

public class RemoveDuplicatesTest {

	@Test
	public void test() {

		Solution sol = new Solution();
		
		int res;
		int[] A;
		
		//add test case
		res = 2;
		A = new int[] {1,1,2};
		assertEquals(res, sol.removeDuplicates(A));
	}

}

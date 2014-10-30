package leet;

import static org.junit.Assert.*;
import leet.util.ListNode;

import org.junit.Test;

public class ZigZagConversionTest implements ILeetCodeProblemTest{

	@Test
	public void validate() {

		Solution sol = new Solution();
		
		String res;
		String s;
		int nRows;

		// add test cases here
		res = "PAHNAPLSIIGYIR";
		s = "PAYPALISHIRING";
		nRows = 3;
		assertEquals(res, sol.convert(s, nRows));
	}

}

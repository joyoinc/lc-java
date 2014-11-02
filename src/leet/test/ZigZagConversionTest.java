package leet.test;

import static org.junit.Assert.*;
import leet.Solution;
import org.junit.Test;

public class ZigZagConversionTest  {

	@Test
	public void test() {

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

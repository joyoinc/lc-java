package leet.test;

import static org.junit.Assert.*;
import leet.Solution;
import leet.util.ListNode;

import org.junit.Test;

public class AddTwoNumbersTest   {

	@Test
	public void test() {
		Solution sol = new Solution();
		
		ListNode res;
		ListNode l1;
		ListNode l2;

		// add test cases here
		res = ListNode.fromString("7 -> 0 -> 8");
		l1 = ListNode.fromString("2 -> 4 -> 3");
		l2 = ListNode.fromString("5 -> 6 -> 4");
		assertEquals(res.toString(true), sol.addTwoNumbers(l1, l2).toString(true));
	}

}

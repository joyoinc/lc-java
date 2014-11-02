package leet.test;

import static org.junit.Assert.*;

import leet.Solution;
import leet.util.ListNode;

import org.junit.Test;

public class SwapNodesinPairsTest {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		ListNode res;
		ListNode head;

		// add test cases here
		head = ListNode.fromString("1->2->3->4");
		res = ListNode.fromString("2->1->4->3");
		
		assertEquals(res.toString(true), sol.swapPairs(head).toString(true));
	}

}

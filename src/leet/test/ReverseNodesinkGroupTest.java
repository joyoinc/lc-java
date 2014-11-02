package leet.test;

import static org.junit.Assert.*;

import leet.Solution;
import leet.util.ListNode;

import org.junit.Test;

public class ReverseNodesinkGroupTest {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		ListNode res;
		ListNode head;
		int k;

		// add test cases here
		res = ListNode.fromString("2->1->4->3->5");
		head = ListNode.fromString("1->2->3->4->5");
		k = 2;
		assertEquals(res.toString(true), sol.reverseKGroup(head, k).toString(true));
		
		res = ListNode.fromString("3->2->1->4->5");
		head = ListNode.fromString("1->2->3->4->5");
		k = 3;
		assertEquals(res.toString(true), sol.reverseKGroup(head, k).toString(true));
	}

}

package leet.test;

import static org.junit.Assert.*;

import java.util.*;

import leet.Solution;
import leet.util.ListNode;

import org.junit.Test;

public class MergekSortedListsTest {

	@Test
	public void test() {
		
		Solution sol = new Solution();
		
		ListNode res;
		List<ListNode> lists;

		// add test cases here
		res = ListNode.fromString("1->2->3");
		lists = new ArrayList<ListNode>();
		lists.add(new ListNode(3));
		lists.add(new ListNode(1));
		lists.add(new ListNode(2));
		
		assertEquals(res.toString(true), sol.mergeKLists(lists).toString(true));
	}

}

package leet.util;

import java.util.Comparator;

public class NodeKeyComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode o1, ListNode o2) {
		// TODO Auto-generated method stub
		return o1.val - o2.val;
	}
	
}

package leet;

import java.util.*;


public class Class22 {
	
	class NodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			// TODO Auto-generated method stub
			return o1.val - o2.val;
		}
		
	}
		
    public ListNode mergeKLists(List<ListNode> lists) {

    	ListNode head = new ListNode(0);
    	ListNode tail = head;
    	
    	Comparator<ListNode> comparator = new NodeComparator();
    	
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size()+1, comparator);
    	for(ListNode node : lists) {
    		if(node != null)
    			queue.add(node);
    	}
    	
    	while(!queue.isEmpty()) {
    		ListNode node = queue.poll();
    		tail.next = node;
    		tail = node;
    		
    		if(node.next != null)
    			queue.add(node.next);
    	}
    	
    	return head.next;
    }
}

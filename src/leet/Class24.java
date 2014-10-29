package leet;

public class Class24 {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode tail = sen;
        ListNode groupStart = head;
        ListNode groupEnd, originStart;
        while(groupStart != null) {
            int cnt = 0;
        	for(groupEnd=groupStart; cnt < k && groupEnd != null; cnt++, groupEnd = groupEnd.next);
        	if(cnt == k) {
        		originStart = groupStart;
        		while(groupStart != groupEnd) {
        			head = groupStart;
        			groupStart = groupStart.next;
        			head.next = tail.next;
        			tail.next = head;
        		}
        		tail = originStart;
        		tail.next = groupStart;
        	} else {
        	    break;
        	}
        }
        
        return sen.next;
    }
}

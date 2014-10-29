package leet;

public class Class23 {
	public ListNode swapPairs(ListNode head) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode tail = sen;
        ListNode n, nn;
        n = head == null ? null : head.next;
        while(n != null) {
        	nn = n.next;
        	tail.next = n;
        	n.next = head;
        	head.next = nn;
        	tail = head;
        	head = nn;
        	n = head == null ? null : head.next;
        }
        
        return sen.next;
    }
}

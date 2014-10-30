package leet.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
    
    public String toString(boolean includeTail) {
    	String res = String.format("%d", val);
    	if(includeTail) {
    		ListNode nxt = next;
    		while(nxt!=null) {
    			res += String.format("->%d", nxt.val);
    			nxt = nxt.next;
    		}
    	}
    	return res;
    }
    
    public static ListNode fromString(String s) {
    	String[] strs = s.split("->");
    	ListNode sen = new ListNode(0);
    	ListNode tail = sen;
    	for(String str : strs) {
    		tail.next = new ListNode(Integer.parseInt(str.trim()));
    		tail = tail.next;
    	}
    	return sen.next;
    }
    
}
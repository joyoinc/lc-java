package leet;

/**
 * Definition for singly-linked list.
 */
  
public class Class4 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	return helper(l1, l2, 0);
    }
    
    private ListNode helper(ListNode l1, ListNode l2, int carry) {
    	if(l1==null && l2==null && carry==0)
    		return null;
    	int v1 = l1 == null ? 0 : l1.val;
    	int v2 = l2 == null ? 0 : l2.val;
    	ListNode sum = new ListNode(v1+v2+carry);
    	carry = sum.val / 10;
    	sum.val %= 10 ;
    	
    	sum.next = helper(l1 == null ? null : l1.next , l2 == null ? null : l2.next, carry);

    	return sum;
    }
}

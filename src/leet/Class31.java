package leet;

import java.util.Stack;

public class Class31 {
	
	char[] chs;
	Stack<Integer> stack = new Stack<Integer>();
	public int longestValidParentheses(String s) {
		stack.clear();
		chs = s.toCharArray();
		int leftMost = 0;
		int maxLength = 0;
		for(int i=0; i<chs.length; i++) {
			if(chs[i]=='(') {
				stack.push(i);
			} else {
				if(stack.isEmpty()) {
					maxLength = Math.max(maxLength, i - leftMost);
					leftMost = i + 1;
				} else {
					stack.pop();
				}
			}
		}
		
		int rightMost = chs.length;
		while(!stack.isEmpty()) {
			int pos = stack.pop();
			maxLength = Math.max(maxLength, rightMost - pos - 1);
			rightMost = pos;
		}
		maxLength = Math.max(maxLength, rightMost - leftMost);
		return maxLength;
    }
}

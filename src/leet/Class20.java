package leet;

import java.util.*;

public class Class20 {
	char [] chs;
	
	HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
	
	public boolean isValid(String s) {
		chs = s.toCharArray();
		return helper(0, s.length());
    }
	
	private boolean match(char left, char right) {
		if(left=='(')
			return right == ')';
		if(left=='[')
			return right == ']';
		if(left=='{')
			return right == '}';
		return false;
	}
	
	private boolean helper(int start, int end) {
		int len = end - start;
		if(len % 2 == 1)
			return false;
		if(len == 0)
			return true;
		String lookupKey = String.format("%d,%d", start, end);
		if(memo.containsKey(lookupKey))
			return memo.get(lookupKey);
		
		for(int offset=2; start+offset < end; offset+=2) {
			if(helper(start, start+offset) && helper(start+offset, end)) {
				memo.put(lookupKey, true);
				return true;
			}
		}

		Boolean result;
		if(match(chs[start], chs[end-1])) 
			result = helper(start+1, end-1);
		else
			result = false;
		
		memo.put(lookupKey, result);
		return result;
	}
}

package leet;

import java.util.*;

public class Class21 {
	
	private List<String> result;

	public List<String> generateParenthesis(int n) {
		result = new ArrayList<String>();
        helper(n, n, "");
        return result;
    }
	
	private void helper(int leftRemain, int rightRemain, String current) {
		if(rightRemain == 0) {
			result.add(current);
			return;
		}
		
		if(leftRemain == 0) {
			helper(0, rightRemain-1, current + ")");
		} else {
			helper(leftRemain-1, rightRemain, current + "(");
			
			if(leftRemain < rightRemain)
				helper(leftRemain, rightRemain-1, current + ")");
		}
	}
}

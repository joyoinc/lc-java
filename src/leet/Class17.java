package leet;

import java.util.ArrayList;
import java.util.List;

public class Class17 {

	static String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" , "wxyz" };
	List<String> result = new ArrayList<String>();
	char[] work;
	char[] input;
	int n;
	public List<String> letterCombinations(String digits) {
        result.clear();
        n = digits.length();
        if(n>0) {
        	input = digits.toCharArray();
        	work = new char[n];
        	helper(0);
        } else {
        	result.add("");
        }
        return result;
    }
	
	private void helper(int currentPos) {
		if(currentPos == n) {
			result.add(String.copyValueOf(work));
			return;
		}
		int digit = getDigit(input[currentPos]);
		String str = dict[digit];
		char[] chs = str.toCharArray();
		for(char ch : chs) {
			work[currentPos] = ch;
			helper(currentPos+1);
		}
	}
	
	private int getDigit(char digit) {
		return digit - '0';
	}
}

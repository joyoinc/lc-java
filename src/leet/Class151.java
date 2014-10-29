package leet;

import java.util.ArrayList;

public class Class151 {
	
	char[] chs;
	public String reverseWords(String s) {
		String result = "";
		chs = (" "+s).toCharArray();
		reverse(0, chs.length); 
		int first = 0;
		int last = 0;
		for(int i=0; i<chs.length; i++) {
			if(chs[i] != ' ') {
				chs[last++] = chs[i];
			} else {
				reverse(first, last);
				String str = String.copyValueOf(chs, first, last-first);
				if(result.length() > 0 && str.length() > 0)
					result += " ";
				result += str;
				first = last;
			}
		}
		return result;
    }
	
	private void reverse(int start, int end) {
		char t;
		for(; start < end; start++, end--) {
			t = chs[start]; chs[start] = chs[end-1]; chs[end-1] = t;
		}
	}
}

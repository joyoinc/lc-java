package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Class29 {
    
	HashMap<String, Integer> hash;
	List<Integer> result =  new ArrayList<Integer>();
	char[] chs;
	int words; 
	int wordLen;
	public List<Integer> findSubstring(String S, String[] L) {
		result.clear();
		words = L.length;
		wordLen = words>0 ? L[0].length() : 0;
		if(wordLen == 0)
			return result;
		
        hash = new HashMap<String, Integer>();
        for(String str : L) {
        	Integer value = hash.get(str);
        	if(value == null)
        		value = 0;
        	hash.put(str, value+1);
        }
        chs = S.toCharArray();
        int n = chs.length;
        for(int pos=0; pos + words*wordLen <= n; pos++) {
        	if(helper(pos, words)) {
        		result.add(pos);
        	}
        }
        
        return result;
    }
	
	private boolean helper(int start, int wordRemain) {
		if(wordRemain == 0) {
			return true;
		}
		String str = String.copyValueOf(chs, start, wordLen);
		Integer value = hash.get(str);
		if(value == null || value == 0)
			return false;
		
		hash.put(str, value-1);
		boolean subMatch = helper(start + wordLen, wordRemain-1);
		hash.put(str, value);
		return subMatch;
	}
}

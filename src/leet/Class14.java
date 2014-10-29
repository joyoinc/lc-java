package leet;

public class Class14 {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        	return "";
        char[] chs = strs[0].toCharArray();
        int end = chs.length;
        for(int i=1; i<strs.length; i++) {
        	int j = 0;
        	for(; j<end && j<strs[i].length() && chs[j] == strs[i].charAt(j); j++);
        	end = Math.min(j, end);
        }
        StringBuffer buf = new StringBuffer();
        buf.append(chs, 0, end);
        return buf.toString();
    }
}

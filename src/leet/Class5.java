package leet;

public class Class5 {
	public String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) 
        	return s;
        char[] chs = new char[2*n+1];
        for(int i=0; i<n; i++) {
        	chs[2*i+1] = s.charAt(i);
        }
        
        int posCenter =0;
        int maxRadius = 0;
        for(int pos=0; pos<chs.length; pos++) {
        	int step = 0;
        	for(; pos-step >=0 && pos+step < chs.length 
        			&& chs[pos-step] == chs[pos+step]; step++ );
        	
        	if(step-1 > maxRadius) {
        		maxRadius = step-1;
        		posCenter = pos;
        	}
        }
        
        StringBuffer buf = new StringBuffer();
        for(int i=posCenter-maxRadius; i<=posCenter+maxRadius; i++) {
        	if(chs[i] != 0)
        		buf.append(chs[i]);
        }
        return buf.toString();
    }
}

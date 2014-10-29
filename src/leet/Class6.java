package leet;

public class Class6 {
	public String convert(String s, int nRows) {
		char[] chs = s.toCharArray();
        int n = s.length();
        if(n < 3 || nRows <2)
            return s;
        
        int colSize = (2*nRows-2);
        int nCols = n / colSize;
        if( n - nCols *colSize > 0 )
        	nCols++;
        StringBuffer[] bufs = new StringBuffer[nRows];
        for(int i=0; i<nRows; i++)
        	bufs[i] = new StringBuffer(2*nCols);

        for(int col=0; col< nCols; col++) {
        	int base = col * colSize;
        	for(int i=0; i<nRows; i++) {
        		if(base+i < n) {
        			bufs[i].append(chs[base+i]);
        		}
        	}
        	
        	for(int i=nRows-2; i>0; i--) {
        		if(base+colSize-i < n) {
        			bufs[i].append(chs[base+colSize-i]);
        		}
        	}
        }
        for(int i=1; i<nRows; i++)
        	bufs[0].append(bufs[i]);
        
        return bufs[0].toString();
    }
}

package leet;

public class Class26 {
	public int removeDuplicates(int[] A) {
		if(A.length < 2)
			return A.length;
		
		int last = 0;
		for(int i=1; i<A.length; i++) 
			if(A[i] != A[last])
				A[++last] = A[i];
			
		return last+1;
    }
}

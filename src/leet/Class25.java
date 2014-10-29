package leet;

public class Class25 {
	public int removeElement(int[] A, int elem) {

		int last = -1;
		for(int i=0; i<A.length; i++) {
			if(A[i] != elem) {
				A[++last] = A[i];
			}
		}
		
		return last+1;
    }
}

package leet;

public class Class32 {
    
	int[] input;
	int n;
	public int search(int[] A, int target) {
        input = A;
        n = A.length;
        return rsearch(0, n, target);
    }
	
	private int rsearch(int start, int end, int target) {
		if(start >= end)
    		return -1;
    	if(start + 1 == end)
    		return input[start] == target ? start : -1;
    	int mid = start + (end - start)/2;
    	if(target == input[mid])
    		return mid;
    	boolean isRotated = input[start] > input[end-1];
    	if(! isRotated)
    		return bsearch(start, end, target);
    	int pos;
    	if( (pos = rsearch(start, mid, target)) >= 0)
    		return pos;
    	if( (pos = rsearch(mid+1, end, target)) >= 0)
    		return pos;
    	return -1;
	}
    
    private int bsearch(int start, int end, int target) {
    	if(start >= end)
    		return -1;
    	if(start + 1 == end)
    		return input[start] == target ? start : -1;
    	int mid = start + (end - start)/2 ;
    	if (input[mid] > target)
    		return bsearch(start, mid, target);
    	else if(input[mid] < target)
    		return bsearch(mid+1, end, target);
    	else
    		return mid;
    }
}

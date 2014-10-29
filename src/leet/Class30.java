package leet;

public class Class30 {
	
	int[] input;
	int n;
	public void nextPermutation(int[] num) {
        input = num;
        n = input.length;
        int j, k;
        for(j=n-1; j-1>=0 && input[j-1] >= input[j]; j--);
        if(j==0) {
        	reverse(0, n-1);
        	return;
        }
        
        reverse(j, n-1);
        for(k=j; input[j-1] >= input[k]; k++);
        swap(j-1, k);
    }
	
	private void swap(int i, int j) {
		int t = input[i];input[i] = input[j]; input[j] = t;
	}
	
	private void reverse(int start, int end) {
		int s, e;
		for(s=start, e=end; s<e; s++, e--)
			swap(s,e);
	}

}

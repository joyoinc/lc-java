package leet;

public class Class11 {
	public int maxArea(int[] height) {
        int n = height.length;
        if(n < 2) 
        	return 0;
        int max = 0;
        for(int l=0, r=n-1; l<r; ) {
        	int h, w = r-l;
        	if(height[l] < height[r]) {
        		h = height[l];
        		l++;
        	} else {
        		h = height[r];
        		r--;
        	}
        	
        	int area = h*w;
        	if(area > max)
        		max = area;
        }
        return max;
    }
}

package leet;

import java.util.*;

public class Class15 {
	
	class Tuple {
		Integer [] ary;
		Tuple(int i1, int i2, int i3) {
			ary = new Integer[] {i1, i2, i3};
			Arrays.sort(ary);
		}
		
		List<Integer> toList() {
			return Arrays.asList(ary);
		}

		public int hashCode() {
			return ary[0] + ary[1] + ary[2];
		}
		
		public boolean equals(Object o) {
			Tuple other = (Tuple)o;
			return other.ary[0] == ary[0] && other.ary[1] == ary[1] && other.ary[2] == ary[2];
		}
	}
	
	public List<List<Integer>> threeSum(int[] num) {
		HashSet<Integer> doneSet = new HashSet<Integer>();
		HashSet<Tuple> tuples = new HashSet<Tuple>();
        
		Arrays.sort(num);
		for(int idx=0; idx<num.length; ++idx) {
			if(!doneSet.contains(num[idx])) {
				int target = 0 - num[idx];
				int small = 0;
				int large = num.length-1;
				while(small < large) {
					if(small == idx) {
						++small;
						continue;
					}
					if(large == idx) {
						--large;
						continue;
					}
					
					if(num[small] + num[large] < target) {
						++small;
						continue;
					} else if (num[small] + num[large] > target) {
						--large;
						continue;
					} else {
						tuples.add(new Tuple(num[small], num[large], num[idx]));
						++small;
						--large;
						continue;
					}
				}
				doneSet.add(num[idx]);
			}
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(Tuple tup : tuples)
			result.add(tup.toList());
        
        return result;
    }
}

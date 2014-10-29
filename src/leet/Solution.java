package leet;

import java.util.*;

import leet.util.ArrayIndexComparator;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Solution {
	
    int[][][] tbl; 
    public boolean isScramble(String s1, String s2) {
        n = s1.length();
        if(n==0 || s2.length()!=n) return false;
        tbl = new int[n][n][n+1];
        // init
        
        // for(int k=1; k<=n; k++) {
        //     for(int i=0; i<n; i++) {
        //         for(int j=0; j<n; j++) {
        //             if(s1.charAt(i)==s2.charAt(j)) {
        //                 tbl[i][j] = 1;
        //             }
        //         }
        //     }
        // }
        
        return dp(s1, s2, 0, 0, n) > 0;
    }
    
    private int dp(String s1, String s2, int idx1, int idx2, int len) {
        if(tbl[idx1][idx2][len] != 0) return tbl[idx1][idx2][len];
        
        int res;
        if(len==1) {
            res = s1.charAt(idx1) == s2.charAt(idx2) ? 1 : -1;
        } else if(idx1 < 0 || idx2 < 0 || idx1+len > n || idx2+len > n) {
            res = -1;
        } else {
            boolean found = false;
            for(int l = 1; l <= len-1; l++) {
                found = dp(s1, s2, idx1, idx2, l) > 0 && dp(s1, s2, idx1+l, idx2+l, len-l) > 0;
                if(found) break;
                found = dp(s1, s2, idx1, idx2+len-l, l) > 0 && dp(s1, s2, idx1+l, idx2, len-l) > 0;
                if(found) break;
            }
            res = found ? 1 : -1;
        }
        
        tbl[idx1][idx2][len] =  res;
        return res;
    }
	
	public boolean isMatch(String s, String p) {
        char [] str, pat;
        int m, n, i, j;
        str = s.toCharArray();
        pat = p.toCharArray();
        m = str.length;
        n = pat.length;
        
        int starIdx, sIdx; // to save the * pos and string's pos
        starIdx = sIdx = -1;
        i = j = 0;
        while(i<m) {
            if(j<n && (pat[j]=='?' || str[i]==pat[j])) { i++; j++; continue; }
            if(j<n && pat[j]=='*') {
                sIdx = i;
                starIdx = j;
                j++;
                continue;
            }
            if(starIdx>=0) {
                i = ++sIdx;
                j = starIdx + 1;
                continue;
            }
            return false;
        }
        
        while(j<n && pat[j]=='*') j++;
        return j==n;
        
    }
    
	
	public int divide(int dividend, int divisor) {
        if(divisor==0) return 0; // math error
        if(dividend==0) return 0;
        
        long up = dividend;
        long down = divisor;
        boolean neg = false;
        if(up < 0) { neg = ! neg; up = - up; }
        if(down < 0) { neg = ! neg; down = - down; }
        // now up,down is +
        long res = 0;
        int shift = 0;
        while(up >= (down << shift)) {
            shift++;
        }
        shift--;
        //  up in [down<<sh, down<<sh+1)
        while(up >= down) {
            res += 0x1 << shift;
            up -= down << shift;
            shift--;
        }
        
        if(neg) res = -res;
        // check overflow
        return (int) res;
    }
	
	public String multiply(String num1, String num2) {
        if(num1.length() > num2.length())
            return multiply(num2, num1);
        if(num1.length()==0)
            return "0";
        char ch = num1.charAt(0);
        if(ch=='0')
            return multiply(num1.substring(1), num2);
    
        String res = multiply(ch, num2);
        int len = num1.length()-1;
        while(len!=0) {
            res += "0"; len--;
        }
        String remain = multiply(num1.substring(1), num2);
        return add(res, remain);
    }
    
    public String multiply(char digit, String num) {
        char[] chs = new char[num.length() + 1];
        int i;
        int carry = 0;
        int m1 = digit - '0';
        for(i=num.length()-1; i>=0; i--) {
            int m2 = num.charAt(i) - '0';
            int prod = m1 * m2 + carry;
            carry = prod / 10;
            chs[i+1] = (char) (prod % 10 + '0');
        }
        chs[0] = (char)(carry + '0');
        return carry == 0 ? String.valueOf(chs, 1, chs.length-1) : String.valueOf(chs);
    }
    
    public String add(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(n1>n2)
            return add(num2, num1);
        if(n2==0)
            return "0";
        if(n1==0)
            return num2;
        char[] chs = new char[n2 + 1];
        int carry = 0;
        int i;
        for(i=n2-1; i>=0; i--) {
            int a2 = num2.charAt(i) - '0';
            int a1 = i+n1-n2 >= 0 ? num1.charAt(i+n1-n2) - '0' : 0;
            int sum = a1 + a2 + carry;
            carry = sum / 10;
            chs[i+1] = (char)(sum % 10 + '0');
        }
        chs[0] = (char) (carry + '0');
        return carry == 0 ? String.valueOf(chs, 1, chs.length-1) : String.valueOf(chs);
    }
	
	
	public int ladderLength(String start, String end, Set<String> dict) {
        int n = start.length();
        HashMap<String, Integer> stat = new HashMap<String, Integer>();
        Queue<String> todo = new LinkedList<String>();
        Queue<Integer> dep = new LinkedList<Integer>();
        todo.offer(start); dep.offer(1); stat.put(start, 1);
        
        while(!todo.isEmpty()) {
            String key = todo.poll(); int d = dep.poll();
            if(key.equals(end)) return d;
            char [] chs = key.toCharArray();
            for(int i=0; i<n; i++) {
                for(char ch='a'; ch<='z'; ch++) {
                    chs[i] = ch;
                    String nei = String.valueOf(chs);
                    if(dict.contains(nei) && !stat.containsKey(nei)) {
                        todo.offer(nei); dep.offer(d+1); stat.put(nei, d+1);
                    }
                }
            }
        }
        return 0;
    }
	
	public boolean isPalindrome(int x) {
        if(x<0) return false;
        int p10 = 1;
        while(x/p10 >= 10) p10 *= 10;
        while(x>0) {
            int first = x / p10;
            int last = x % 10;
            if(last != first)
                return false;
            x = x - first * p10 - last;
            x /= 10;
            p10 /= 100;
        }
        return true;
    }
	
	
	public List<List<Integer>> permuteUnique(int[] num) {
		results.clear();
		result.clear();
		Arrays.sort(num);
		input = num;
		n = num.length;
		
		return results;
    }
	
	private void swap(int i, int j) {
		swap(i,j,input);
	}
	
	private void reverse(int start, int end) {
		reverse(start, end, input);
	}
	
	private void swap(int i, int j, int[] array) {
		if(i==j) return;
		int t = array[i];array[i] = array[j]; array[j] = t;
	}
	
	private void reverse(int start, int end, int[] array) {
		int s, e;
		for(s=start, e=end; s<e; s++, e--)
			swap(s,e-1,array);
	}
	
	public int trap(int[] A) {
        input = A;
		n = A.length;
        if(n<3) return 0;
        int first, last;
        first = 0;
        last = n-1;
        //for(first=0; first+1<n && A[first]<=A[first+1] ; first++);
        //for(last=n-1; last-1>=0 && A[last]<=A[last-1] ; last--);
        //if(first >= last) return 0;
       	return A[first] < A[last] ?
       		trapHelperForward(first, last) :
       		trapHelperBackward(first, last);
    }
	
	private int trapHelperForward(int first, int last) {
		if(first >= last) return 0;
		int trap = 0;
		int i;
		for(i=first+1; i<last && input[i] < input[first]; i++) {
			trap += input[first] - input[i];
		}
		int remain = input[i] < input[last] ?
				trapHelperForward(i, last) :
				trapHelperBackward(i, last);
		return trap + remain;
	}
	
	private int trapHelperBackward(int first, int last) {
		if(first >= last) return 0;
		int trap = 0;
		int i;
		for(i=last-1; i>first && input[i] < input[last]; i--) {
			trap += input[last] - input[i];
		}
		int remain = input[i] > input[first] ?
				trapHelperForward(first, i) :
				trapHelperBackward(first, i);
		return trap + remain;
	}
	
	
    public ListNode insertionSortList(ListNode head) {
        ListNode sen = new ListNode(0);
    	while(head != null) {
    		ListNode next = head.next;
    		ListNode prev;
    		for(prev=sen; prev.next!=null && head.val > prev.next.val; prev = prev.next);
    		head.next = prev.next;
    		prev.next = head;
    		head = next;
    	}
    	return sen.next;
    }
	
    public void merge(int A[], int m, int B[], int n) {
    	int lastPos = m+n-1;
    	while(m>0 && n>0) {
    		if(A[m-1] < B[n-1]) {
    			A[lastPos--] = B[n-1]; n--;
    		} else {
    			A[lastPos--] = A[m-1]; m--;
    		}
    	}
    	while(n>0) {
    		A[lastPos--] = B[n-1]; n--;
    	}
    }

	public int lengthOfLastWord(String s) {
		char[] chs = s.toCharArray();
		int i,j;
		for(i=chs.length-1; i>=0 && chs[i]==' '; i--);
		for(j=i; j>=0 && chs[j]!=' '; j--);
		return i-j;
	}
	
	private boolean isValidIp(String s) {
		int n = s.length();
		if(n>3 || n>1 && s.charAt(0)=='0') return false;
		return Integer.parseInt(s) < 256;
	}
	
	private void parseIp(String s, int numExpect, String workIp) {
		if(numExpect == 0) {
			if(s.equals(""))
				validIps.add(workIp.substring(0, workIp.length()-1));
			return;
		}
		int maxLength = Math.min(s.length(), 3);
		for(int i=1; i<=maxLength; i++) {
			String str = s.substring(0, i);
			if(isValidIp(str)) {
				parseIp(s.substring(i), numExpect-1, workIp + str + ".");
			}
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		validIps = new ArrayList<String>();
		parseIp(s, 4, "");
		return validIps;
    }
	
	private int gcd(int a, int b) {
		if(0==a) return b;
		return gcd(a % b, a);
	}
	
	private boolean isValidNQ(int last) {
		int i, j;
		for(i=0; i<=last; i++) {
			for(j=i+1; j<=last; j++) {
				if(input[i] == input[j] 
					|| input[i] - input[j] == i - j
					|| input[i] - input[j] == j - i)
					return false;
			}
		}
		return true;
	}
	
	private void printNQ() {
		char[] chs = new char[input.length];
		String[] result = new String[input.length];
		for(int i=0; i<input.length; i++) {
			//System.out.print(input[i]);
			Arrays.fill(chs, '.');
			chs[input[i]] = 'Q';
			result[i] = String.copyValueOf(chs);
		}
		nQueens.add(result);
		//System.out.println("");
	}
	
	public List<String[]> solveNQueens(int n) {
		nQueens = new ArrayList<String[]>();
		input = new int[n];
		boolean tryThis = true;
		int current = 0;
		while(current >= 0) {
			if(tryThis) {
				for(;input[current]<n && !isValidNQ(current);input[current]++);
				if(input[current] == n) {
					input[current] = 0;
					tryThis = false;
					current--;
				} else {
					current++;
				}
			} else {
				input[current] += 1;
				tryThis = true;
			}

			if(current == n) {
				printNQ();
				current--;
				tryThis = false;
			}
		}
		return nQueens;
    }
	
    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
    	if(newInterval == null)
    		return intervals;
    	List<Interval> result = new ArrayList<Interval>();
    	int i;
    	for(i=0; i<intervals.size() && newInterval.start > intervals.get(i).end; i++)
    		result.add(intervals.get(i));
    	if(i == intervals.size()) {
    		result.add(newInterval);
    		return result;
    	}
    	
    	if(newInterval.end < intervals.get(i).start) {
    		result.add(newInterval);
    	} else {
    		newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
    		newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
    		result.add(newInterval);
    		for(i=i+1; i<intervals.size() && newInterval.end >= intervals.get(i).start; i++) 
    			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
    	}
    	for(; i<intervals.size(); i++) 
    		result.add(intervals.get(i));
        return result;
    }
	
    public boolean canJump(int[] A) {
    	input = A;
    	n = input.length;
    	if(n==0)
    		return true;
    	int startPos = 0;
    	int maxPos = A[0];
    	while(maxPos < n-1) {
    		int nextPos;
    		boolean jumped = false;
    		for(int currentPos = maxPos; currentPos > startPos; currentPos--) {
    			nextPos = currentPos + A[currentPos]; 
    			if(nextPos > maxPos) {
    				maxPos = nextPos;
    				jumped = true;
    				break;
    			}
    		}
    		if(!jumped)
    			break;
    	}
    	return maxPos >= n-1;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	return helper(l1, l2, 0);
    }
    
    private ListNode helper(ListNode l1, ListNode l2, int carry) {
    	if(l1==null && l2==null && carry==0)
    		return null;
    	int v1 = l1 == null ? 0 : l1.val;
    	int v2 = l2 == null ? 0 : l2.val;
    	ListNode sum = new ListNode(v1+v2+carry);
    	carry = sum.val / 10;
    	sum.val %= 10 ;
    	
    	sum.next = helper(l1 == null ? null : l1.next , l2 == null ? null : l2.next, carry);

    	return sum;
    }

    
    List<String> validIps;
    List<String[]> nQueens;
    
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    List<Integer> result = new ArrayList<Integer>();
    
	int[] input;
	int n;
	
	public boolean isNumber(String s) {
		return false;
	}
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = {0, 0};
        
        ArrayIndexComparator comparator = new ArrayIndexComparator(numbers); 
        Integer[] idx = comparator.buildIndex();
        // cannot sort the origin array, because it will change the index. here we need the origin index.
        // create a sorted index array. 
        // the index array is sorted by the value of origin array.
        Arrays.sort(idx, comparator);
        
        int s = 0;
        int e = numbers.length - 1;
        while(s < e) {
        	if(numbers[idx[s]] + numbers[idx[e]] == target) {
        		result[0] = idx[s]+1;
        		result[1] = idx[e]+1;
        		// the index array is sorted by value of origin array
        		// so idx1 < idx2 not hold. here we want that holds
        		if(result[0] > result[1]) {
        		    s = result[0];
        		    result[0] = result[1];
        		    result[1] = s;
        		}
        		
        		break;
        	} else if (numbers[idx[s]] + numbers[idx[e]] > target) {
        		e--;
        	} else {
        		s++;
        	}
        }
        return result;
    }
	
	public double findMedianSortedArrays(int A[], int B[]) {
		// convert to findKth problem
		// compare A[k/2] and B[k/2]
		int n = A.length + B.length; 
		
        if( n % 2 == 1) {
        	return findKth(A, 0, A.length, B, 0, B.length, n/2+1);
        } else {
        	return (double) ( findKth(A, 0, A.length, B, 0, B.length, n/2)
        		+ findKth(A, 0, A.length, B, 0, B.length, n/2+1) ) / 2;
        }
    }
	
	private int findKth(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
		if(aEnd - aStart > bEnd - bStart)
			return findKth(B, bStart, bEnd, A, aStart, aEnd, k);
		
		if(aStart == aEnd)
			return B[bStart + k - 1]; 

		if(k == 1)
			return Math.min(A[aStart], B[bStart]);
		
		// if A,B both contains more than k/2, try to discard k/2
		// otherwise try to discard whole A.
		int lengthA = Math.min(k/2, aEnd - aStart);
		int lengthB = k - lengthA;
		
		if(A[aStart + lengthA - 1] < B[bStart + lengthB - 1]) {
			return findKth(A, aStart + lengthA, aEnd, B, bStart, bEnd, k - lengthA); 
		} else if(A[aStart + lengthA - 1] > B[bStart + lengthB - 1]) {
			return findKth(A, aStart, aEnd, B, bStart + lengthB, bEnd, k - lengthB);
		} else {
			return A[aStart + lengthA - 1];
		}
	}
	
	public int lengthOfLongestSubstring(String s) {
		int[] lastPos = new int[256];
		char[] chs = s.toCharArray();
		int start = 0;
		int max = 0;
		for(int nth = 1; nth <= s.length(); nth++) {
			if(lastPos[chs[nth-1]] > start) {
				max = Math.max(max, nth - 1 - start);
				start = lastPos[chs[nth-1]] ;
			} 
			lastPos[chs[nth-1]] = nth;
		}
		max = Math.max(max, s.length() - start);
		
		return max;
    }
 }

package leet;

import java.util.*;

import leet.util.*;

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
    
    public double pow(double x, int n) {
        if(n==0) return 1;
    	long ln = (long) n;
        boolean neg = false;
        if(n<0) {
        	neg = true; 
        	ln = -ln; 
        }
        
        double res = 1.0;
        for (double f = x; ln > 0; ln = ln >> 1) {
            if (ln % 2 == 1) {
                res *= f;
            }
            f = f * f;
        }
        return neg ? 1 / res : res;
    }
    
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
    
    String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    String[] thousands = {"", "M", "MM", "MMM" };
    String roman;
    public String intToRoman(int num) {

		StringBuffer buf = new StringBuffer();
		
		buf.append(thousands[(num / 1000)]);
		num %= 1000;
		
		buf.append(hundreds[(num / 100)]);
		num %= 100;
		
		buf.append(tens[(num / 10)]);
		num %= 10;
		
		buf.append(ones[(num)]);
		
		return buf.toString();
    }
    
    public int romanToInt(String s) {
    	roman = s;
        return 1000 * parseThousands(roman) + 100 * parseHundreds(roman) + 10 * parseTens(roman) + parseOnes(roman);
    }

	private int parseOnes(String s) {
		if(s.startsWith("I") || s.startsWith("V")) {
			int i=0;
			String patten = "IVX";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			String str = s.substring(0, i);
			roman = s.substring(i);
			for(int j=1; j<10; j++)
				if(ones[j].equals(str))
					return j;
					
		}
		return 0;
	}

	private int parseTens(String s) {
		if(s.startsWith("X") || s.startsWith("L")) {
			int i=0;
			String patten = "XLC";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			String str = s.substring(0, i);
			roman = s.substring(i);
			for(int j=1; j<10; j++)
				if(tens[j].equals(str))
					return j;
					
		}
		return 0;
	}

	private int parseHundreds(String s) {
		if(s.startsWith("C") || s.startsWith("D")) {
			int i=0;
			String patten = "CDM";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			String str = s.substring(0, i);
			roman = s.substring(i);
			for(int j=1; j<10; j++)
				if(hundreds[j].equals(str))
					return j;
					
		}
		return 0;
	}

	private int parseThousands(String s) {
		if(s.startsWith("M")) {
			int i=0;
			String patten = "M";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			roman = s.substring(i);
			return i;
		}
		return 0;
	}
	
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
	
	public List<List<Integer>> threeSum(int[] num) {
		 List<Integer> re;
		 Arrays.sort(num);
		 HashSet<List<Integer>> nodup = new HashSet<List<Integer>>();
		 for(int i=0; i<num.length; i++) {
			 int target = 0 - num[i];
			 int s, e;
			 for(s=i+1, e=num.length-1; s<e; ) {
				 if(num[s] + num[e] < target) s++;
				 else if(num[s] + num[e] > target) e--;
				 else {
					 re = Arrays.asList(new Integer[] { num[i], num[s], num[e] });
					 nodup.add(re);
					 s++; e--;
				 }
			 }
		 }
		 
		 List<List<Integer>> res = new ArrayList<List<Integer>>(nodup);
		 
		 return res;
    }
	

    public boolean isMatchRegex(String s, String p) {
    	if(p.length()==0) return s.length()==0;
    	
    	if(p.length()>1 && p.charAt(1)=='*') {
    		if(isMatchRegex(s, p.substring(2))) return true;
    		for(int i=0; i<s.length() && isMatchSingle(s.substring(i), p); i++) {
    			if(isMatchRegex(s.substring(i+1), p.substring(2)))
    				return true;
    		}
    	} else {
    		return isMatchSingle(s, p) ? isMatchRegex(s.substring(1), p.substring(1)) : false;
    	}
    	return false;
    }
    
    private boolean isMatchSingle(String s, String p) {
    	return s.length()>0 && p.length()>0 
    		? p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)
    		: s.length() == p.length();
    }
    

	public boolean isMatchWildcard(String s, String p) {
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
	

	private int gcd(int a, int b) {
		if(0==a) return b;
		return gcd(b % a, a);
	}
	
	public int maxPoints(Point[] points) {
		
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		int i,j;
		int kx, ky, max, dup, cnt;
		max = 0;
		for(i=0; i<points.length; i++) {
			dup = cnt = 0;
			map.clear();
			
			for(j=i+1; j<points.length; j++) {
				if(points[i].x == points[j].x && points[i].y == points[j].y ) {
					dup++;
					continue;
				}
				if(points[i].x == points[j].x) {
					kx = points[i].x;
					ky = 0;
				}
				else if(points[i].y == points[j].y) {
					ky = points[i].y;
					kx = 0;
				} else {
					int a = points[i].x - points[j].x;
					int b = points[i].y - points[j].y;
					int c = gcd(a, b);
					kx = a/c;
					ky = b/c;
				}
				
				HashMap<Integer, Integer> v1;
				Integer v2;
				if((v1 = map.get(kx)) == null ) {
					v1 = new HashMap<Integer, Integer>();
					map.put(kx, v1);
					v2 = 1;
				} else if((v2 = v1.get(ky)) == null) {
					v2 = 1;
				} else {
					v2 += 1;
				}
				v1.put(ky, v2);
				cnt = Math.max(cnt, v2);
			}
			
			max = Math.max(max, cnt+dup+1);
		}
		
		return max;
    }
    
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        int n = L.length;
        if(n==0) return res;
        int m = L[0].length();
        if(m==0) return res;
        
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for(String str: L) {
        	Integer cnt = hash.get(str);
        	if(null == cnt) cnt = 0;
        	hash.put(str, cnt+1);
        }
        
        int i;
        for(i=0; i+m*n <= S.length(); i++) {
        	if(findSubstringHelper(S, i, m, n, hash)) {
        		res.add(i);
        	}
        }
        
        return res;
    }
	
	private boolean findSubstringHelper(String S, int start, int wordLen, int wordRemain, HashMap<String, Integer> hash) {
		if(wordRemain==0)
			return true;
		
		String str = S.substring(start, start + wordLen);
		Integer cnt = hash.get(str);
		if(cnt==null || cnt==0) {
			return false;
		} else {
			hash.put(str, cnt-1);
			boolean res = findSubstringHelper(S, start+wordLen, wordLen, wordRemain-1, hash);
			hash.put(str, cnt);
			return res;
		}
	}
	
	public void nextPermutation(int[] num) {
        int i, j, n;
        n = num.length;
        if(n<2) return;
        for(i=n-1; i-1>=0 && num[i-1]>=num[i]; i--);
        if(i==0) {
        	reverse(num, 0, n-1);
        } else {
        	reverse(num, i, n-1);
        	j = i-1;
        	for(; i<n && num[i] <= num[j]; i++);
        	swap(num, i, j);
        }
    }
	
	private void swap(int[] array, int i, int j) {
		if(i==j) return;
		array[i] = array[i] ^ array[j];
		array[j] = array[j] ^ array[i];
		array[i] = array[i] ^ array[j];
	}
	
	private void reverse(int[] array, int i, int j) {
		if(i>j) reverse(array, j, i);
		while(i<j) {
			swap(array, i, j);
			i++; j--;
		}
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
        long remain = 0;
        for(int i=31; i>=0; i--) {
        	res <<= 1;
        	remain <<= 1;
        	remain += (up >> i) & 0x1;
        	if(remain >= down) {
        		res += 1;
        		remain -= down;
        	}
        }
        
        if(neg) res = -res;
        // check overflow
        return (int) res;
    }
	
	public ListNode mergeKLists(List<ListNode> lists) {

    	ListNode head = new ListNode(0);
    	ListNode tail = head;
    	
    	Comparator<ListNode> comparator = new NodeKeyComparator();
    	
    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size()+1, comparator);
    	for(ListNode node : lists) {
    		if(node != null)
    			queue.add(node);
    	}
    	
    	while(!queue.isEmpty()) {
    		ListNode node = queue.poll();
    		tail.next = node;
    		tail = node;
    		
    		if(node.next != null)
    			queue.add(node.next);
    	}
    	
    	return head.next;
    }
	
	public ListNode swapPairs(ListNode head) {
        ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode tail = sen;
        ListNode n, nn;
        n = head == null ? null : head.next;
        while(n != null) {
        	nn = n.next;
        	tail.next = n;
        	n.next = head;
        	head.next = nn;
        	tail = head;
        	head = nn;
        	n = head == null ? null : head.next;
        }
        
        return sen.next;
    }
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode sen = new ListNode(0);
        sen.next = head;
        ListNode tail = sen;
        ListNode groupStart = head;
        ListNode groupEnd, originStart;
        while(groupStart != null) {
            int cnt = 0;
        	for(groupEnd=groupStart; cnt < k && groupEnd != null; cnt++, groupEnd = groupEnd.next);
        	if(cnt == k) {
        		originStart = groupStart;
        		while(groupStart != groupEnd) {
        			head = groupStart;
        			groupStart = groupStart.next;
        			head.next = tail.next;
        			tail.next = head;
        		}
        		tail = originStart;
        		tail.next = groupStart;
        	} else {
        	    break;
        	}
        }
        
        return sen.next;
    }
	
	public List<String> letterCombinations(String digits) {
		String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv" , "wxyz" };
		List<String> result = new ArrayList<String>();
        int n = digits.length();
        if(n>0) {
        	char[] work = new char[n];
        	letterCombinationsHelper(digits, 0, work, result, dict);
        } else {
        	result.add("");
        }
        return result;
    }
	
	private void letterCombinationsHelper(String digits, int currentPos, char[] work, List<String> result, String[] dict) {
		if(currentPos == digits.length()) {
			result.add(String.copyValueOf(work));
			return;
		}
		int digit = digit2int(digits.charAt(currentPos));
		String str = dict[digit];
		for(char ch : str.toCharArray()) {
			work[currentPos] = ch;
			letterCombinationsHelper(digits, currentPos+1, work, result, dict);
		}
	}
	
	private int digit2int(char digit) {
		return digit - '0';
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
    
    public boolean isValid(String s) {
        int n = s.length();
        char[] chs = new char[n+1];
        chs[0] = '#'; n = 1;
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if( chs[n-1]=='(' &&ch==')' 
   			||  chs[n-1]=='[' &&ch==']'
   			|| 	chs[n-1]=='{' &&ch=='}'
   			)  	n--;
        	else {
        		chs[n++] = ch;
        	}
        }
        return n==1;
    }
    
    public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generateParenthesisHelper(n, n, "", result);
        return result;
    }
	
	private void generateParenthesisHelper(int leftRemain, int rightRemain, String current, List<String> result) {
		if(rightRemain == 0) {
			result.add(current);
			return;
		}
		
		if(leftRemain == 0) {
			generateParenthesisHelper(0, rightRemain-1, current + ")", result);
		} else {
			generateParenthesisHelper(leftRemain-1, rightRemain, current + "(", result);
			
			if(leftRemain < rightRemain)
				generateParenthesisHelper(leftRemain, rightRemain-1, current + ")", result);
		}
	}
	
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> results = new ArrayList<String>();
        HashMap<String, List<String>> tbl = new HashMap<String, List<String>>();
        results = wordBreakDP(s, dict, tbl);
        List<String> results2 = new ArrayList<String>();
        for(String str : results) {
        	results2.add(str.substring(0, str.length()-2));
        }
        return results2;
    }
	
	private List<String> wordBreakDP(String s, Set<String> dict, HashMap<String, List<String>> tbl) {
		if(tbl.containsKey(s)) {
			return tbl.get(s);
		}
		
		List<String> results = new ArrayList<String>(); 
		tbl.put(s, results);
		if(0!=s.length()) {
			for(int i=s.length(); i>0; i--) {
				String first = s.substring(0, i);
				String rest = s.substring(i);
				if(dict.contains(first)) {
					List<String> others = wordBreakDP(rest, dict, tbl);
					for(int j=0; j<others.size(); j++) {
						String result = first;
						result += " " + others.get(j);
						results.add(result);
					}
				}
			}
		}
		else {
			results.add("$");
		}
		
		return results;
	}
	
	public int removeElement(int[] A, int elem) {
        int i, j;
        for(i=j=0; i<A.length; i++) {
        	if(A[i]!=elem) A[j++] = A[i];
        }
        return j;
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
    
    
    public int removeDuplicates(int[] A) {
    	if(A.length<2) return A.length;
    	int i,j;
    	for(i=j=1; i<A.length; i++) {
    		if(A[i] != A[j-1]) A[j++] = A[i];
    	}
    	return j;
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
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	return addTwoNumbersHelper(l1, l2, 0);
    }
    
    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
    	if(l1==null && l2==null && carry==0)
    		return null;
    	int v1 = l1 == null ? 0 : l1.val;
    	int v2 = l2 == null ? 0 : l2.val;
    	ListNode sum = new ListNode(v1+v2+carry);
    	carry = sum.val / 10;
    	sum.val %= 10 ;
    	
    	sum.next = addTwoNumbersHelper(l1 == null ? null : l1.next , l2 == null ? null : l2.next, carry);

    	return sum;
    }
    
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

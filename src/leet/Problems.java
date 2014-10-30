package leet;

import java.util.*;
import java.util.Map.Entry;

public class Problems {
	
	HashMap<String, ILeetCodeProblemTest> m_Problems;
	
	public Problems() {
		m_Problems = new HashMap<String, ILeetCodeProblemTest>();
		
		m_Problems.put("Two Sum", new TwoSumTest());
		m_Problems.put("Median of Two Sorted Arrays", new MedianOfTwoSortedArrays());
		m_Problems.put("Longest Substring Without Repeating Characters", new LongestSubstringWithoutRepeatingCharactersTest());
		m_Problems.put("Add Two Numbers ", new AddTwoNumbersTest ());
		//m_Problems.put("Longest Palindromic Substring ", new LongestPalindromicSubstringTest());
		m_Problems.put("ZigZag Conversion ", new ZigZagConversionTest());
		
		
		
		//m_Problems.put("Valid Number", new ValidNumberTest());
	}
	
	public void validateAll() {
		// TODO Auto-generated method stub
		for(Entry<String, ILeetCodeProblemTest> entry : m_Problems.entrySet()) {
			System.out.println(String.format("[%s] : ", entry.getKey()));
			entry.getValue().validate();
		}
	}
}



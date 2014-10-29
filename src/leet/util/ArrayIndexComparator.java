package leet.util;

import java.util.Comparator;

public class ArrayIndexComparator implements Comparator<Integer> {
	
	private Integer[] m_array;
	
	public ArrayIndexComparator(Integer[] array) { m_array = array; }
	
	public ArrayIndexComparator(int[] array) { 
		m_array = new Integer[array.length];
		int idx = 0;
		for(int i : array)
			m_array[idx++] = i;
			
	}
	
	@Override
	public int compare(Integer index1, Integer index2) {
		// TODO Auto-generated method stub
		return ((Integer)m_array[index1]).compareTo(m_array[index2]);
	}
	
	public Integer[] buildIndex() {
		Integer[] indexes = new Integer[m_array.length];
		for(int i=0; i<indexes.length; i++)
			indexes[i] = i;
		return indexes;
	}

}

package leet;

public class Class12 {
	
	private static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	private static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	private static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	private static String[] thousands = {"", "M", "MM", "MMM" };
	
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
}

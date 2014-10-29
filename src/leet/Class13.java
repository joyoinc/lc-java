package leet;

public class Class13 {
	
	private static String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	private static String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	private static String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	private static String[] thousands = {"", "M", "MM", "MMM" };
	
	private String input;
	
	public int romanToInt(String s) {
		input = s;
        return 1000 * parseThousands(input) + 100 * parseHundreds(input) + 10 * parseTens(input) + parseOnes(input);
    }

	private int parseOnes(String s) {
		// TODO Auto-generated method stub
		if(s.startsWith("I") || s.startsWith("V")) {
			int i=0;
			String patten = "IVX";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			String str = s.substring(0, i);
			input = s.substring(i);
			for(int j=1; j<10; j++)
				if(ones[j].equals(str))
					return j;
					
		}
		return 0;
	}

	private int parseTens(String s) {
		// TODO Auto-generated method stub
		if(s.startsWith("X") || s.startsWith("L")) {
			int i=0;
			String patten = "XLC";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			String str = s.substring(0, i);
			input = s.substring(i);
			for(int j=1; j<10; j++)
				if(tens[j].equals(str))
					return j;
					
		}
		return 0;
	}

	private int parseHundreds(String s) {
		// TODO Auto-generated method stub
		if(s.startsWith("C") || s.startsWith("D")) {
			int i=0;
			String patten = "CDM";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			String str = s.substring(0, i);
			input = s.substring(i);
			for(int j=1; j<10; j++)
				if(hundreds[j].equals(str))
					return j;
					
		}
		return 0;
	}

	private int parseThousands(String s) {
		// TODO Auto-generated method stub
		if(s.startsWith("M")) {
			int i=0;
			String patten = "M";
			for(;i<s.length() && patten.indexOf(s.charAt(i))>=0; i++);
			input = s.substring(i);
			return i;
		}
		return 0;
	}
	
}

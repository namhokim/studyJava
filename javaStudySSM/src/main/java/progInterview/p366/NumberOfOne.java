package progInterview.p366;

public class NumberOfOne {
	
	public static int countBit0(int value) {
		String strValue = Integer.toBinaryString(value);
		int count = 0;
		for (int i=0; i<strValue.length(); i++) {
			if (strValue.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
	
	public static int countBit(int value) {
		int count = 0;
		while (value != 0) {
			count += (value & 1);
			value = value >>> 1;
		}
		return count;
	}
	
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s).replace(' ', '0');  
	}
	
	public static int countBit2(int value) {
		int count = 0;
		while (value != 0) {
			System.out.print("original: " + padLeft(Integer.toBinaryString(value), 32));
			System.out.print(" & " + padLeft(Integer.toBinaryString(value-1), 32));
			System.out.println(" => " + padLeft(Integer.toBinaryString(value & (value-1)), 32));
			value = value & (value - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int i = 30000;
		/* System.out.println(Integer.bitCount(i)); */
		System.out.println(countBit2(i));

	}
	
	protected static void test() {
		for (int i=Integer.MIN_VALUE; i<Integer.MAX_VALUE; i++) {
			if (Integer.bitCount(i) != countBit(i)) {
				throw new ArithmeticException();
			}
		}
		System.out.println("Success");
	}

}

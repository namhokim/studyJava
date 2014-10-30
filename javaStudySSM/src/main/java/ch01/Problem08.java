package ch01;

public class Problem08 {

	public static boolean isSubstring1(String s1, String s2)
	{
		String longer, shorter;
		if (s1.length() > s2.length())
		{
			longer = s1;
			shorter = s2;
		}
		else
		{
			longer = s2;
			shorter = s1;
		}
		return (longer.indexOf(shorter) != -1);
	}
	
	// s1이 s2보다 길거나 크다고 생각한다.
	public static boolean isSubstring(String s1, String s2)
	{
		int s2len = s2.length();
		if (s1.length() < s2len)
		{
			return isSubstring(s2, s1);
		}
		else
		{
			return (s2len > 0 && s1.indexOf(s2) != -1);
		}
	}
	
	public static boolean isRotate(String s1, String s2)
	{
		if (s1.length() != s2.length()) return false;	// assertFalse(Problem8.isRotate("waterbottle", "waterbottle2"));
		return isSubstring(s1, s2 + s2);
	}
	
}

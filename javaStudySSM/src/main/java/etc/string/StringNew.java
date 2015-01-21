package etc.string;

public class StringNew {

	public static void main(String[] args) {
		String str1 = "test";
		String str2 = "test";
		String str3 = new String("test");
		
		System.out.println("1: " + (str1 == str2));
		System.out.println("2: " + (str1 == str3));
		System.out.println("3: " + (str1.equals(str2)));
		System.out.println("4: " + (str1.equals(str3)));
	}
	
}

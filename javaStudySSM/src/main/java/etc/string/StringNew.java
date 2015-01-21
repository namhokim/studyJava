package etc.string;

public class StringNew {

	public static void main(String[] args) {
		String str1 = "test";
		String str2 = "test";
		String str3 = new String("test");
		String str4 = "test2";
		String str5 = new String("test2");
		
		System.out.println("1: " + (str1 == str2));
		System.out.println("2: " + (str1 == str3));
		System.out.println("3: " + (str1 == str4));
		System.out.println("4: " + (str1 == str5));
		System.out.println("5: " + (str1.equals(str2)));
		System.out.println("6: " + (str1.equals(str3)));
		System.out.println("7: " + (str1.equals(str4)));
		System.out.println("8: " + (str1.equals(str5)));
		
	}
	
}

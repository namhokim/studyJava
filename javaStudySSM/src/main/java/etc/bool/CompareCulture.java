package etc.bool;

public class CompareCulture {
	
	public static void procedure1() {}
	public static void procedure2() {}

	public static void main(String[] args) {
		int i = 1;
		
		// culture (only C language)
		if (i == 1) {
			System.out.println("Same 1");
		}
		
		if (1 == i) {
			System.out.println("Same 2");
		}
		
		
		// culture positive or negative
		if (i != 2) {
			procedure2();
		} else {
			procedure1();
		}
		
		if (i == 1) {
			procedure1();
		} else {
			procedure2();
		}
		

	}

}

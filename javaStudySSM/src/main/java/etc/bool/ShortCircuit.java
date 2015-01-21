package etc.bool;

public class ShortCircuit {

	public static void main(String[] args) {
		boolean a;
        boolean c;
        a = c = true;
        
		if ((a = true) || (c = false)) {
			System.out.println("1: " + a + " " + c);
		}

		if ((a = false) && (c = false)) {
			System.out.println("2: " + a + " " + c);
		}

		System.out.println("3: " + a + " " + c);
	}

}

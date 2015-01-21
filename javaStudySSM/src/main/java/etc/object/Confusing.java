package etc.object;

public class Confusing {
	
	public Confusing(Object o) {
		System.out.println("Object");
	}

	public Confusing(double[] dArray) {
		System.out.println("double array");
	}

	public static void main(String args[]) {
		new Confusing(null);
	}
	/*
	 * Output
	 * 1. Object
	 * 2. double array
	 * 3. Neither
	 */
	
}

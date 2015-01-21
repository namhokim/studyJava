package etc.string;

public class Trivial {

	public static void main(String[] args) {
		System.out.print("H" + "a");
		System.out.print('H' + 'a');
	}
	/* Output?
	 * 1. Ha
	 * 2. HaHa
	 * 3. Neither
	 */
}

package etc.string;

public class StringEquals {
	
	public void show(String parameter) {
		if (parameter.equals("Test")) {
			System.out.println("1: parameter is Test");
		} else {
			System.out.println("2: parameter is Not Test");
		}
	}

	public void show2(String parameter) {
		if ("Test".equals(parameter)) {
			System.out.println("1: parameter is Test");
		} else {
			System.out.println("2: parameter is Not Test");
		}
	}

	public static void main(String[] args) {
		StringEquals test = new StringEquals();
		test.show("Test");
		test.show2("Test");
		test.show("Test2");
		test.show2("Test2");
		test.show2(null);
		test.show(null);

	}

}

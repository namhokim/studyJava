package ch11.no3.jvmTest;

public class ArrayTest {
	
	static final int FIVE_HUNDRED_MILLIION = 500000000;	// 5억
	
	public static void main(String[] args) {
		char[] flag1 = new char[FIVE_HUNDRED_MILLIION];
		int postion = FIVE_HUNDRED_MILLIION - 1; 
		flag1[postion] = 'y';
		System.out.println("Hello Array! " + flag1[postion]);
	}

}

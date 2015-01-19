package ch11.no3.jvmTest;

import java.util.BitSet;

public class BitSetTest {

	static final int FIVE_HUNDRED_MILLIION = 500000000;	// 5억
	
	public static void main(String[] args) {
		BitSet bs = new BitSet(FIVE_HUNDRED_MILLIION);
		System.out.println("BitSet[0]" + bs.get(0));
		bs.set(0);
		System.out.println("BitSet[0]" + bs.get(0));
	}
	
}

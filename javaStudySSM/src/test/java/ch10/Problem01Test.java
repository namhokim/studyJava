package ch10;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem01Test {

	public static final int DataStartValue = 1;
	
	private int [] a;
	private int [] b;
	
	@Test
	public void testMerge() {
		testMerge(5, 5);
		testMerge(15, 5);
		testMerge(5, 15);
		testMerge(0, 5);
		testMerge(5, 0);
		testMerge(0, 0);
	}
	
	@Test
	public void testMerge2() {
		testMerge2(5, 5);
		testMerge2(15, 5);
		testMerge2(5, 15);
		testMerge2(0, 5);
		testMerge2(5, 0);
		testMerge2(0, 0);
	}
	
	public void testMerge(int sizeA, int sizeB) {
		
		// Arrange
		int totalSize = allocate(sizeA, sizeB);
		
		// Act
		Problem01.merge(a, sizeA, b);
		
		// Assert
		checkResult(a, totalSize);
	}
	
	public void testMerge2(int sizeA, int sizeB) {
		
		// Arrange
		int totalSize = allocate(sizeA, sizeB);
		
		// Act
		Problem01.merge2(a, sizeA, b);
		
		// Assert
		checkResult(a, totalSize);
	}
	
	private int allocate(int sizeOfA, int sizeOfB) {
		this.a = new int[sizeOfA + sizeOfB];
		this.b = new int[sizeOfB];
		initialize(a, sizeOfA, b);
		return this.a.length;
	}

	private void initialize(int[] a, int sizeOfA, int[] b) {
		int gen = DataStartValue;
		for (int i = 0; i < sizeOfA; i++) {
			a[i] = gen++;
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = gen++;
		}
	}
	
	private void checkResult(int[] a, int sizeOfAandB) {
		for (int i = 0; i < sizeOfAandB; i++) {
			assertEquals(i + DataStartValue, a[i]);
		}
	}
	
	@Test
	public void testShiftRight() {
		int [] a = new int[2];
		a[0] = 1;
		assertEquals(1, a[0]);
		assertEquals(0, a[1]);	// 배열은 값이 0으로 초기화 됨을 알 수 있다
		Problem01.shiftRight(a, 1, 1);
		assertEquals(0, a[0]);
		assertEquals(1, a[1]);
		
		int [] b = new int[3];
		b[0] = 1;
		assertEquals(1, b[0]);
		assertEquals(0, b[1]);
		assertEquals(0, b[2]);
		Problem01.shiftRight(b, 1, 2);
		assertEquals(0, b[0]);
		assertEquals(0, b[1]);
		assertEquals(1, b[2]);
	}

}


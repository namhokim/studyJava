package etc.list.arrayList;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testAddE() {
		ArrayList<Integer> al = new ArrayList<Integer>(10);
		assertNotNull(al);
		assertEquals(0, al.size());
		al.add(100);
		assertEquals(1, al.size());
		assertEquals(100, al.get(0).intValue());
	}
	
	@Test
	public void test() {
		assertTrue(ArrayListTest.isOdd(1));
		assertFalse(ArrayListTest.isOdd(2));
		
	}
	
	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}

}

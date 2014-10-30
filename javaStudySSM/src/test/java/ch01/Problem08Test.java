package ch01;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem08Test {

	@Test
	public void testIndexOf() {
		assertEquals(0, "1".indexOf(""));
		assertEquals(0, "123".indexOf("12"));
		assertEquals(-1, "12".indexOf("123"));
	}
	
	@Test
	public void testIsSubstring() {
		assertTrue(Problem08.isSubstring("a", "a"));
		assertTrue(Problem08.isSubstring("a", "ab"));
		assertTrue(Problem08.isSubstring("ab", "a"));
		
		assertFalse(Problem08.isSubstring("a", ""));
		assertFalse(Problem08.isSubstring("a", "b"));
	}

	
	@Test
	public void testIsRotate() {
		assertTrue(Problem08.isRotate("waterbottle", "erbottlewat"));
		assertFalse(Problem08.isRotate("waterbottle", "waterbottle2"));
		assertFalse(Problem08.isRotate("xyz", "waterbottle2"));	// xyzx
		assertFalse(Problem08.isRotate("", "xyz"));	// xyzx
	}

}

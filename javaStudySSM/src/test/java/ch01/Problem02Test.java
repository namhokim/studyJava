package ch01;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem02Test {
	
	private Problem02 ad;

	@Test
	public void testSame() {
		
		ad = new Problem02("a", "a");
		assertTrue(ad.determine());
		
		ad = new Problem02("b", "b");
		assertTrue(ad.determine());
		
		ad = new Problem02("ab", "ab");
		assertTrue(ad.determine());
		
		ad = new Problem02("abc", "abc");
		assertTrue(ad.determine());
	}
	
	@Test
	public void testAnagram() {
		
		ad = new Problem02("ab", "ba");
		assertTrue(ad.determine());
		
		ad = new Problem02("bc", "cb");
		assertTrue(ad.determine());
		
		ad = new Problem02("abc", "cab");
		assertTrue(ad.determine());
		
		ad = new Problem02("aabc", "abca");
		assertTrue(ad.determine());
	}
	
	@Test
	public void testNotAnagram() {
		
		ad = new Problem02("ab", "bc");
		assertFalse(ad.determine());
		
		ad = new Problem02("abc", "abd");
		assertFalse(ad.determine());
	}

}

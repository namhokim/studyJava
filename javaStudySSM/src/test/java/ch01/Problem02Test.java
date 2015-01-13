package ch01;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem02Test {
	
	private Problem02 ad;
	
	private void assertAnagram(boolean isTrue, String a, String b) {
		Problem02 ad = new Problem02(a, b);
		assertEquals(isTrue, ad.determine());
	}

	@Test
	public void testSameAnagram() {
		assertAnagram(true, "a", "a");
		assertAnagram(true, "b", "b");
		assertAnagram(true, "ab", "ab");
		assertAnagram(true, "abc", "abc");
	}
	
	@Test
	public void testRotatedAnagram() {
		assertAnagram(true, "ab", "ba");
		assertAnagram(true, "bc", "cb");
		assertAnagram(true, "abc", "cab");
		assertAnagram(true, "bca", "abc");
		assertAnagram(true, "cab", "bca");
		assertAnagram(true, "aabc", "abca");
	}
	
	@Test
	public void testNotAnagramInDictionary() {
		assertAnagram(true, "words", "sword");
		assertAnagram(true, "finder", "friend");
	}
	
	@Test
	public void testNotAnagram() {
		assertAnagram(false, "ab", "bc");
		assertAnagram(false, "abc", "abd");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIncludeUppercaseException() {
		assertAnagram(false, "abC", "bcD");
	}
	

}

package etc.count;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class HangulMorphemeCounterTest {
	
	HangulMorphemeCounter counter;

	@Before
	public void setUp() throws Exception {
		counter = new HangulMorphemeCounter();
	}
	
	@Test
	public final void test가() {
		assertEquals("It was " + "가".codePointAt(0), 0xac00, '가');
	}
	
	@Test
	public final void test핳() {
		assertEquals("It was " + "힣".codePointAt(0), 0xd7a3, '힣');
	}
	
	@Test
	public final void testGetMinSet() {
		String something = "아버지가방에들어가신다";
		counter.setString(something);
        Set<Character> set = counter.getMinSet();
        System.out.printf("Min Hangul is %s\n", set);
        assertTrue(set.contains('아'));
	}
	
	@Test
	public final void testJamo() {
		String something = "ㅋㅋㅎ";
		counter.setString(something);
        Set<Character> set = counter.getMinSet();
        System.out.printf("Min Hangul is %s\n", set);
        assertTrue(set.contains('ㅎ'));
	}

}

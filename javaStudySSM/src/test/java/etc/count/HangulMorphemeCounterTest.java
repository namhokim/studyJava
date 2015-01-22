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
	public final void testGetMinSet() {
		String something = "아버지가방에들어가신다";
		counter.setString(something);
        Set<Character> set = counter.getMinSet();
        assertTrue(set.contains('아'));
        System.out.printf("Min Hangul is %s\n", set);
	}

}

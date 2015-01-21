package etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringAppendTest {
	
	public static final int REPEAT = 100000;

	@Test
	public final void testAppendByPlus() {
		String a = "";
		for (int i = 0; i < REPEAT; i++) {
			a = a + "a";
		}
		assertEquals(REPEAT, a.length());
	}
	
	@Test
	public final void testAppendByStringBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < REPEAT; i++) {
			sb.append("a");
		}
		String a = sb.toString();
		assertEquals(REPEAT, a.length());
	}
	
	@Test
	public final void testAppendByStringBuffer() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < REPEAT; i++) {
			sb.append("a");
		}
		String a = sb.toString();
		assertEquals(REPEAT, a.length());
	}

}

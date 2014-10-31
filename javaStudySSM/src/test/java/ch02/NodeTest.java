package ch02;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testToString() {
		assertEquals("d", (new Node<Character>('d')).toString());
		assertEquals("a", (new Node<Character>('a')).toString());
	}

}

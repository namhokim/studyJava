package ch02;

import static org.junit.Assert.*;

import org.junit.Test;

public class Node5Test {

	@Test
	public void testReverse() {
		Node5 head = new Node5(1);
		head.append(2);
		head.append(3);
		
		assertEquals("123", head.toString());
		Node5 n = head.reverse();
		assertEquals("321", n.toString());
	}

}

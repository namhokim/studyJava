package ch02;

import static org.junit.Assert.*;

import org.junit.Test;

public class Node1Test {
	
	public static Node1 getInstance(String s) {
		int len = s.length();
		Node1 head = null;
		for (int i=0; i<len; i++) {
			char c = s.charAt(i);
			if (head == null) {
				head = new Node1(c);
			} else {
				head.appendToTail(c);
			}
		}
		return head;
	}

	@Test
	public void testRemoveDuplication_2회중복() {
		Node1 n = getInstance("daat");
		assertEquals("dat", n.removeDuplication().toString());
	}
	
	@Test
	public void testRemoveDuplication_3회중복() {
		Node1 n = getInstance("daaat");
		assertEquals("dat", n.removeDuplication().toString());
	}
	
	@Test
	public void testRemoveDuplication_건너띄고중복() {
		Node1 n = getInstance("datat");
		assertEquals("dat", n.removeDuplication().toString());
	}
	
	
	@Test
	public void testRemoveDuplicationNoBuffer_2회중복() {
		Node1 n = getInstance("daat");
		assertEquals("dat", n.removeDuplicationNoBuffer().toString());
	}
	
	@Test
	public void testRemoveDuplicationNoBuffer_3회중복() {
		Node1 n = getInstance("daaat");
		assertEquals("dat", n.removeDuplicationNoBuffer().toString());
	}
	
	@Test
	public void testRemoveDuplicationNoBuffer_건너띄고중복() {
		Node1 n = getInstance("datat");
		assertEquals("dat", n.removeDuplicationNoBuffer().toString());
	}

}

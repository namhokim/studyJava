package ch02;

import static org.junit.Assert.*;

import org.junit.Test;


public class Node6Test {

	@Test
	public void testGetList() {
		Node6 head = getList();
		assertEquals("C", head.next.next.data.toString());
		assertEquals("D", head.next.next.next.data.toString());
		assertEquals("E", head.next.next.next.next.data.toString());
		assertEquals("C", head.next.next.next.next.next.data.toString());
	}
	@Test
	public void testGetCircularNode_비순환1() {
		Node6 notCircular = new Node6('A');
		assertEquals(null, notCircular.getCircularNode());
	}
	@Test
	public void testGetCircularNode_비순환2() {
		Node6 notCircular = new Node6('A');
		notCircular.appendToTail('B');
		assertEquals(null, notCircular.getCircularNode());
	}
	
	@Test
	public void testGetCircularNode_순환1() {
		Node6 head = getList();
		assertEquals("C", head.getCircularNode());
	}
	
	@Test
	public void testGetCircularNode_순환5() {
		Node6 a = new Node6('A');
		Node6 b = new Node6('B');
		a.next = b;
		b.next = a;
		assertEquals("A", a.getCircularNode());
	}
	
	private Node6 getList() {
		Node6 a = new Node6('A');
		Node6 b = new Node6('B');
		Node6 c = new Node6('C');
		Node6 d = new Node6('D');
		Node6 e = new Node6('E');
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;
		
		return a;
	}
}

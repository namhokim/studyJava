package ch02;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testToString() {
		assertEquals("d", (new Node('d')).toString());
		assertEquals("a", (new Node('a')).toString());

		assertEquals("da", get_da().toString());
		assertEquals("dat", get_dat().toString());
		assertEquals("daat", get_daat().toString());
	}
	
	@Test
	public void testRemoveDuplication_2회중복() {
		Node n = get_daat();
		assertEquals("dat", n.removeDuplication().toString());
	}
	
	@Test
	public void testRemoveDuplication_3회중복() {
		Node n = get_daaat();
		assertEquals("dat", n.removeDuplication().toString());
	}
	
	@Test
	public void testRemoveDuplication_건너띄고중복() {
		Node n = get_datat();
		assertEquals("dat", n.removeDuplication().toString());
	}
	
	
	@Test
	public void testRemoveDuplicationNoBuffer_2회중복() {
		Node n = get_daat();
		assertEquals("dat", n.removeDuplicationNoBuffer().toString());
	}
	
	@Test
	public void testRemoveDuplicationNoBuffer_3회중복() {
		Node n = get_daaat();
		assertEquals("dat", n.removeDuplicationNoBuffer().toString());
	}
	
	@Test
	public void testRemoveDuplicationNoBuffer_건너띄고중복() {
		Node n = get_datat();
		assertEquals("dat", n.removeDuplicationNoBuffer().toString());
	}

	
	@Test
	public void testRemoveOne_2회중복() {
		Node n = get_daat();
		assertEquals("dat", n.removeOne('a').toString());
	}
	
	@Test
	public void testRemoveOne_앞원소제거() {
		Node n = get_daaat();
		assertEquals("aaat", n.removeOne('d').toString());
	}
	
	@Test
	public void testRemoveOne_두번째원소제거() {
		Node n = get_daaat();
		assertEquals("daat", n.removeOne('a').toString());
	}
	
	@Test
	public void testRemoveOne_마지막원소제거() {
		Node n = get_daaat();
		assertEquals("daaa", n.removeOne('t').toString());
	}
	
	private Node get_da() {
		return (new Node('d')).appendToTail('a');
	}
	
	private Node get_dat() {
		return (new Node('d')).appendToTail('a').appendToTail('t');
	}
	
	private Node get_daat() {
		return (new Node('d')).appendToTail('a').appendToTail('a').appendToTail('t');
	}
	
	private Node get_daaat() {
		return (new Node('d')).appendToTail('a').appendToTail('a').appendToTail('a').appendToTail('t');
	}
	
	private Node get_datat() {
		return (new Node('d')).appendToTail('a').appendToTail('t').appendToTail('a').appendToTail('t');
	}

}

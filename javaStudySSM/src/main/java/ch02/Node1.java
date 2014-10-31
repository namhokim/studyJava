package ch02;

public class Node1 extends Node<Character> {
	
	public Node1(Character c) {
		super(c);
	}
	
	public Node<Character> removeDuplication() {
		boolean[] has = new boolean[Character.MAX_VALUE];
		has[(int)this.data] = true;
		
		Node<Character> c = this;	// current
		Node<Character> p = c;		// previous
		
		while (c.next != null) {			
			c = c.next;
			
			int offset = (int)c.data;
			if (has[offset]) {
				p.next = c.next;
			} else {
				has[offset] = true;
				p = c;
			}
		}
		return this;
	}

	public Node<Character> removeDuplicationNoBuffer() {
		Node<Character> c = this;	// current
		while (c.next != null) {
			c.next = c.next.removeAll(c.data);
			c = c.next;
			if (c == null) break;
		}
		return this;
	}

}

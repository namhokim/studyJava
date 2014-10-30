package ch02;

public class Node {

	char data;
	Node next = null;
	
	public Node(char c) {
		this.data = c;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.data);
		Node n = this;
		while (n.next != null) {
			n = n.next;
			sb.append(n.data);
		}
		return sb.toString();
	}

	public Node appendToTail(char c) {
		Node end = new Node(c);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		return this;
	}
	
	public Node removeOne(char c) {
		Node n = this;
		if (n.data == c) {
			return n.next;	// head 갱신
		}
		
		while (n.next != null) {
			if (n.next.data == c) {
				n.next = n.next.next;
				return this;
			}
			n = n.next;
		}
		return this;
	}

	public Node removeDuplication() {
		boolean[] has = new boolean[Character.MAX_VALUE];
		has[(int)this.data] = true;
		
		Node c = this;	// current
		Node p = c;		// previous
		//System.out.println(c.data + ":" + this.toString());
		while (c.next != null) {			
			c = c.next;
			
			int offset = (int)c.data;
			if (has[offset]) {
				p.next = c.next;
			} else {
				has[offset] = true;
				p = c;
			}
			//System.out.println(c.data + ":" + this.toString());
		}
		return this;
	}

	// 미구현
	public Node removeDuplicationNoBuffer() {
		Node c = this;	// current
		//Node p = c;		// previous
		System.out.println(this.toString());
		while (c.next != null) {
			System.out.print(c.data + ":");
			Node t = c.next;
			while (t.next != null) {
				System.out.print(t.data);
				t = t.next;
			}
			c = c.next;
			System.out.println();
		}
		return this;
	}

}

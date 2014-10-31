package ch02;

public class Node5 {
	
	int data;
	Node5 next = null;
	
	public Node5(int i) {
		data = i;
	}
	
	public Node5 append(int i) {
		Node5 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new Node5(i);
		
		return this;
	}

	public Node5 reverse() {

		if (this.next == null) {
			return this;
		} else {
			return this.next.reverse().append(this.data);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.data);
		Node5 n = this;
		while (n.next != null) {
			n = n.next;
			sb.append(n.data);
		}
		return sb.toString();
	}
	
}

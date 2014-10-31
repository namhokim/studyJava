package ch02;

public class Node<T> {

	T data;
	Node<T> next = null;
	
	public Node(T c) {
		this.data = c;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.data);
		Node<T> n = this;
		while (n.next != null) {
			n = n.next;
			sb.append(n.data);
		}
		return sb.toString();
	}

	public Node<T> appendToTail(T c) {
		Node<T> end = new Node<T>(c);
		Node<T> n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		return this;
	}
	
	public Node<T> removeOne(T c) {
		Node<T> n = this;
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
	
	public Node<T> removeAll(T c) {
		Node<T> n = this;
		if (n.data == c) {
			if (n.next == null) {
				return null;
			} else {
				return n.next.removeAll(c);
			}
		}
		
		while (n.next != null) {
			if (n.next.data == c) {
				n.next = n.next.next;
			}
			n = n.next;
		}
		return this;
	}

}

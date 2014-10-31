package ch02;

// 순환 연결 리스트
public class Node6 extends Node<Character> {
	public Node6(Character c) {
		super(c);
	}
	
	public static final int MAX_NODES = 100;
	
	public Node<Character> getCircularNode() {
		Node6[] travers = new Node6[MAX_NODES];
		int current = 0;
		travers[current++] = this;
		
		Node<Character> n = this;
		
		while (n.next != null) {
			Node<Character> s = n.next;
			System.out.println(s.data);
			for (int i=0; i<current; i++) {
				if (travers[i] == s.next) {
					return s.next;
				}
				travers[current++] = (Node6) s.next;
				s = s.next;
			}
			n = n.next;
		}
		return null;
	}
	
	
}

package ch03;

import java.util.Stack;

public class Problem04_Hanoi {
	int numsOfPlate;
	Stack<Integer>[] t;
	
	public Problem04_Hanoi(int n) {
		numsOfPlate = n;
		t = new Stack[3];
		t[0] = new Stack<Integer>();
		t[1] = new Stack<Integer>();
		t[2] = new Stack<Integer>();
		fillInitialPlate(t[0]);
	}

	private void fillInitialPlate(Stack<Integer> s) {
		for (int i=numsOfPlate; i>0; i--) {
			s.push(i);
		}
	}
	
	public void play() {
		moveTo(0, 2, 1, numsOfPlate);
	}

	private void moveTo(int start, int target, int temp, int how) {
		if (how==0) {
			return;
		}
		moveTo(start, temp, target, how - 1);
		t[target].push(t[start].pop());
		moveTo(temp, target, start, how - 1);
	}
	
}

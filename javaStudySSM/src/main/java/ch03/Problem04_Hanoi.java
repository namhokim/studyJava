package ch03;

import java.util.ArrayList;
import java.util.Stack;

public class Problem04_Hanoi {
	int numsOfPlate;
	ArrayList<Stack<Integer>> t;
	
	public Problem04_Hanoi(int n) {
		numsOfPlate = n;
		t = new ArrayList<Stack<Integer>>();
		t.add(new Stack<Integer>());
		t.add(new Stack<Integer>());
		t.add(new Stack<Integer>());
		
		fillInitialPlate(t.get(0));
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
		t.get(target).push(t.get(start).pop());
		moveTo(temp, target, start, how - 1);
	}
	
}

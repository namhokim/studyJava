package ch11.no3.tdd;

import java.util.*;

public class MemoryNumberDataSource implements NumberDataSource {
	
	private int postion;
	private List<Long> data = new ArrayList<Long>();
	
	public void add(long value) {
		data.add(value);
	}
	
	public int size() {
		return data.size();
	}

	public long getNext() {
		if (postion >= data.size()) {
			return NumberDataSource.EOD;
		} else {
			return data.get(postion++);
		}
	}

	public void rewind() {
		postion = 0;
	}

}

package ch11.no3;

public class NotExistNumberFinder {
	
	public static final int NUMBER_SIZE = 100;
	public static final int EOF = -1;
	
	public int find() {
		boolean checkFlag[] = new boolean[NUMBER_SIZE - 1];
		int offset;
		int first, second;
		first = readOneNumber();
		if (first == EOF) {
			throw new Exception("Empty data");
		}
		second = getNextNumber(first);
		offset = Math.min(first, second) + 1;
		setFlag(checkFlag, offset, second);
		int nextNumber;
		while ( (nextNumber = readOneNumber) != EOF) {
			setFlag(checkFlag, offset, nextNumber);
		}
		for (int i=0; i<(NUMBER_SIZE-1); i++) {
			if (checkFlag[i] == false) {
				return (i + offset -1);
			}
		}
		return EOF;
	}

	private int readOneNumber() {
		String token = System.in.readLine();
		return Integer.parseInt(token, 10);
	}

	private void setFlag(boolean[] check, int offset, int value) {
		int position = value - offset;
		if (position >=0 && position < NUMBER_SIZE) {
			check[position] = true;
		}
	}
}

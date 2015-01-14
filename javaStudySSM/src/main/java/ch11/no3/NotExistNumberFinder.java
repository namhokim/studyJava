package ch11.no3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotExistNumberFinder {
	
	public static final int NUMBER_SIZE = 100;
	public static final int EOF = -1;
	
	private boolean checkFlag[] = new boolean[NUMBER_SIZE - 1];
	private BufferedReader reader;
	private int offset;
	
	public int find() throws IOException {
		int first, second;
		if (reader != null) {
			reader.close();
		}
		reader = new BufferedReader(new InputStreamReader(System.in));
		first = readOneNumber();
		if (first == EOF) {
			throw new IllegalArgumentException("Empty data");
		}
		second = getNextNumber(first);
		offset = Math.min(first, second) + 1;
		second = Math.max(first, second);
		setFlag(second);
		int nextNumber;
		while ( (nextNumber = readOneNumber()) != EOF) {
			setFlag(nextNumber);
		}

		for (int i=0; i<(NUMBER_SIZE-1); i++) {
			if (checkFlag[i] == false) {
				return (i + offset);
			}
		}
		return EOF;
	}

	private int readOneNumber() throws IOException {
		String token = reader.readLine();
		if (token == null) {
			return EOF;
		} else {
			return Integer.parseInt(token, 10);
		}
	}

	private int getNextNumber(int first) throws IOException {
		int candidate;
		while ( (candidate = readOneNumber()) != EOF) {
			if (candidate != first) {
				return candidate;
			}
		}
		return first;
	}

	private void setFlag(int value) {
		int position = value - offset;
		if (position >= 0 && position < NUMBER_SIZE) {
			checkFlag[position] = true;
		}
	}
	
	/**
	 * using by stdin redirection
	 * eg. > java ch11/no3/NotExistNumberFinder < gen.txt
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		NotExistNumberFinder finder = new NotExistNumberFinder();
		System.out.println("Not exist number: " + finder.find());
	}
}

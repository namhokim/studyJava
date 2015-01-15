package ch11.no3.tdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputStreamNumberDataSource implements NumberDataSource {
	
	private String filename;
	private Scanner sc;
	private FileInputStream inputStream;
	
	public InputStreamNumberDataSource(String filename) throws FileNotFoundException {
		this.filename = filename;
		init();
	}
	
	private void init() throws FileNotFoundException {
		inputStream = new FileInputStream(filename);
		sc = new Scanner(inputStream);
	}

	public long getNext() {
		if (sc.hasNextLong()) {
			return sc.nextLong();
		} else {
			return NumberDataSource.EOF;
		}
	}

	public void rewind() {
		close();
		try {
			init();	// 도중에 파일이 지워지지 않는다면, 생성자에서 이미 예외발생
		} catch (FileNotFoundException e) {
		}
	}
	
	public void close() {
		if (sc != null) {
			sc.close();
			sc = null;
		}
	}

}

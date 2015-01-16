package ch11.no3.tdd;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileNumberDataSource implements NumberDataSource, Closeable {
	
	private String filename;
	private Scanner sc;
	private FileInputStream inputStream;
	
	public FileNumberDataSource(String filename) throws FileNotFoundException {
		this.filename = filename;
		init();
	}
	
	private void init() throws FileNotFoundException {
		close();
		inputStream = new FileInputStream(filename);
		sc = new Scanner(inputStream);
	}

	public long getNext() {
		if (sc.hasNextLong()) {
			return sc.nextLong();
		} else {
			return NumberDataSource.EOD;
		}
	}

	public void rewind() {
		try {
			init();	// 도중에 파일이 지워지지 않는다면, 생성자에서 이미 예외발생
		} catch (FileNotFoundException e) {
		}
	}
	
	public void close() {
		if (sc == null) {
			return;
		}
		sc.close();
		sc = null;
	}
	
	/**
     * 이 데이터 소스에서 발생했던 <code>java.io.IOException</code> 를 반환한다.
     * 이 메서드는 예외가 없었을 경우에는 <code>null</code>을 반환한다.
     *
     * @return 이 데이터 소스에서 발생했던 마지막 예외
     */
	public IOException ioException() {
        return sc.ioException();
    }


}

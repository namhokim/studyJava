package ch11.no3.tdd;

public interface NumberDataSource {

	public static long EOF = -1;
	
	public long getNext();
	public void rewind();
	
}

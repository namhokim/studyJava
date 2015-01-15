package ch11.no3.tdd;

public interface NumberDataSource {

	/**
	 * End of data (or stream, file, etc.)
	 */
	public static long EOD = -1;
	
	/**
	 * Get the next number
	 * @return next number
	 */
	public long getNext();
	
	/**
	 * Rewind the position of data
	 */
	public void rewind();
	
}

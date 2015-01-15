package ch11.no3.tdd;

public class VacantNumberFinder {
	
	private NumberDataSource dataSource;
	private long count, min, max, range;
	private boolean[] flag;

	public VacantNumberFinder(NumberDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * If no vacant number or illegal file format,
	 * throws {@link IllegalArgumentException}
	 * @return vacant number
	 */
	public long find() {
		initialize();
		mark();
		return getFirstVacantNumber();
	}

	private long getFirstVacantNumber() {
		for (int i=0; i<flag.length; i++) {
			if (flag[i]==false) {
				return (i + min); 
			}
		}
		throw new IllegalArgumentException("No vacant number");
	}

	private void mark() {
		dataSource.rewind();
		long data;
		while( (data = dataSource.getNext()) != NumberDataSource.EOD) {
			int position = (int) (data - min);
			flag[position] = true;
		}
	}

	private void initialize() {
		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		count = 0;

		long data;
		while( (data = dataSource.getNext()) != NumberDataSource.EOD) {
			if (data < min) {
				min = data;
			}
			if (data > max) {
				max = data;
			}
			count++;
		}
		
		if (count <= 1) {
			throw new IllegalArgumentException("Data was insufficient. (" + count + ")");
		} else if (min == max) {
			throw new IllegalArgumentException("Only unique data. (" + min + ")");
		}
		
		range = (max - min + 1);
		flag = new boolean[(int) range];
		
		System.out.printf("Range: %d ~ %d (%d), Count: %d\n", min, max, range, count);
	}
	
}

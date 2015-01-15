package ch11.no3.tdd;

public class VacantNumberFinder {
	
	private NumberDataSource dataSource;
	private long count, min, max, offset;
	private boolean[] flag;

	public VacantNumberFinder(NumberDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public long find() {
		
		initialize();
		mark();
		return getFirstVacantNumber();
	}

	private long getFirstVacantNumber() {
		for (int i=0; i<flag.length; i++) {
			if (flag[i]==false) {
				return (i + offset); 
			}
		}
		return NumberDataSource.EOF;
	}

	private void mark() {
		dataSource.rewind();
		long data;
		while( (data = dataSource.getNext()) != NumberDataSource.EOF) {
			int position = (int) (data-offset);
			if (position >= 0 && position < count) {
				flag[position] = true;
			}
		}
	}

	private void initialize() {
		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		count = 0;

		long data;
		while( (data = dataSource.getNext()) != NumberDataSource.EOF) {
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
		flag = new boolean[(int) count];
		offset = min;
		//System.out.println("Range: " + min + " ~ " + max + "(count:" + count + ")");
	}
	
}

package ch11.no3.tdd;

import java.util.BitSet;

/**
 * 비어있는 숫자를 찾아준다.
 * @author namo
 *
 */
public class VacantNumberFinder {
	
	static final int FIVE_HUNDRED_MILLIION = 500000000;	// 5억
	static final long FOUR_BILLION = 4000000000L;			// 40억
	
	private NumberDataSource dataSource;
	private long count, min, max, range;
	private BitSet bitFlag;

	public VacantNumberFinder(NumberDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * 비어있는 숫자가 없거나 데이터가 잘못되었을 경우에는
	 *  {@link IllegalArgumentException}를 던진다.
	 * @return 비어있는 숫자
	 */
	public long find() {
		System.out.println("Count/Mark/Search");
		long start = System.currentTimeMillis();
		initialize();
		long end = System.currentTimeMillis();
		System.out.printf("%d ms / ", (end - start));
		start = System.currentTimeMillis();
		mark();
		end = System.currentTimeMillis();
		System.out.printf("%d ms / ", (end - start));
		start = System.currentTimeMillis();
		long vacantNumber = getFirstVacantNumber();
		end = System.currentTimeMillis();
		System.out.printf("%d ms\n", (end - start));
		return vacantNumber;
	}

	private long getFirstVacantNumber() {
		for (int i=0; i<range; i++) {
			if (bitFlag.get(i)==false) {
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
			if (position < range) {
				bitFlag.set(position);
			}
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
		} else if (count > FOUR_BILLION) {
			throw new IllegalArgumentException("Data was over 4 billion. (" + count + ")");
		} else if (min == max) {
			throw new IllegalArgumentException("Only unique data. (" + min + ")");
		}
		
		long minMaxRange = (max - min + 1);
		range = Math.min(minMaxRange, count);
		bitFlag = new BitSet((int)range);
		
		//System.out.printf("Range: %d ~ %d (%d), Count: %d\n", min, max, range, count);
	}
	
}

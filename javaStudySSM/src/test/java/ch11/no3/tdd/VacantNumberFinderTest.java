package ch11.no3.tdd;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.core.StringStartsWith.startsWith;

import ch11.no3.tdd.MemoryNumberDataSource;
import ch11.no3.tdd.VacantNumberFinder;

public class VacantNumberFinderTest {
	
	private VacantNumberFinder getFinderInstance(long[] data) {
		MemoryNumberDataSource mmds = new MemoryNumberDataSource();
		for (long l : data) {
			mmds.add(l);
		}
		assertEquals("MemoryNumberDataSource initialize was wrong", data.length, mmds.size());
		VacantNumberFinder finder =
				new VacantNumberFinder(mmds);
		return finder;
	}
	
	@Test
	public final void testVacantNumberFinder() {
		assertNotNull(getFinderInstance(new long[] {}));
	}

	@Test
	public final void testFind_3Set() {
		VacantNumberFinder finder = getFinderInstance(new long[] {
			1, 3	
		});
		assertEquals(2, finder.find());
	}
	
	@Test
	public final void testFind_4Set() {
		VacantNumberFinder finder = getFinderInstance(new long[] {
			1, 2, 4	
		});
		assertEquals(3, finder.find());
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public final void testFind_NoData_expectException() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Data was insufficient. (0)");
		
		VacantNumberFinder finder = getFinderInstance(new long[] {
		});
		finder.find();
	}
	
	@Test
	public final void testFind_OneData_expectException() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Data was insufficient. (1)");
		
		VacantNumberFinder finder = getFinderInstance(new long[] {
			1,	
		});
		finder.find();
	}
	
	@Test
	public final void testFind_TwoButSame_expectException() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(startsWith("Only unique data"));
		
		VacantNumberFinder finder = getFinderInstance(new long[] {
			1, 1	
		});
		finder.find();
	}

}

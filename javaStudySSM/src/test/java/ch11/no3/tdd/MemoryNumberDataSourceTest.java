package ch11.no3.tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch11.no3.tdd.MemoryNumberDataSource;
import ch11.no3.tdd.NumberDataSource;

public class MemoryNumberDataSourceTest {

	MemoryNumberDataSource source;
	
	@Before
	public void setUp() throws Exception {
		source = new MemoryNumberDataSource();
	}

	@Test
	public final void testSize() {
		assertEquals(0, source.size());
	}
	
	@Test
	public final void testAdd() {
		source.add(1);
		assertEquals(1, source.size());
	}

	@Test
	public final void testGetNext() {
		assertEquals(NumberDataSource.EOD, source.getNext());
		source.add(2);
		assertEquals(2, source.getNext());
		assertEquals(NumberDataSource.EOD, source.getNext());
	}

	@Test
	public final void testRewind() {
		source.add(3);
		assertEquals(3, source.getNext());
		source.rewind();
		assertEquals(3, source.getNext());
	}

}

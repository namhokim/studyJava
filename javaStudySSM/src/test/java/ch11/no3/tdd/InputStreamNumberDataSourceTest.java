package ch11.no3.tdd;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch11.no3.tdd.InputStreamNumberDataSource;
import ch11.no3.tdd.NumberDataSource;

public class InputStreamNumberDataSourceTest {
	
	private static File file;
	private static String filename;
	private InputStreamNumberDataSource source;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		file = File.createTempFile("randomNumber_", "_tempfile");
		filename = file.getAbsolutePath();
		PrintStream ps = new PrintStream(file);
		ps.println(11);
		ps.println(12);
		ps.println(13);
		ps.println(14);
		ps.print(15);
		ps.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		file.delete();
	}

	@Before
	public void setUp() throws Exception {
		source = new InputStreamNumberDataSource(
				InputStreamNumberDataSourceTest.filename);
	}
	
	@After
	public void tearDown() {
		source.close();
	}


	@Test
	public final void testInputStreamNumberDataSource() throws FileNotFoundException {
		assertNotNull(source);
	}

	@Test
	public final void testGetNext() {
		assertEquals(11, source.getNext());
		assertEquals(12, source.getNext());
		assertEquals(13, source.getNext());
		assertEquals(14, source.getNext());
		assertEquals(15, source.getNext());
		assertEquals(NumberDataSource.EOD, source.getNext());
	}

	@Test
	public final void testRewind() {
		source.getNext();
		source.getNext();
		source.getNext();
		source.rewind();
		assertEquals(11, source.getNext());
	}

}

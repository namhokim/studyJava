package ch03;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem04_HanoiTest {

	@Test
	public void testFillInitialPlate() {
		Problem04_Hanoi h = new Problem04_Hanoi(3);
		assertNotNull(h);
		assertEquals(1, h.t[0].pop().intValue());
		assertEquals(2, h.t[0].pop().intValue());
		assertEquals(3, h.t[0].pop().intValue());
	}
	
	@Test
	public void testPlay1() {
		Problem04_Hanoi h = new Problem04_Hanoi(1);
		h.play();
		assertEquals(1, h.t[2].pop().intValue());
	}
	
	@Test
	public void testPlay2() {
		Problem04_Hanoi h = new Problem04_Hanoi(2);
		h.play();
		assertEquals(1, h.t[2].pop().intValue());
		assertEquals(2, h.t[2].pop().intValue());
	}
	
	@Test
	public void testPlay3() {
		Problem04_Hanoi h = new Problem04_Hanoi(3);
		h.play();
		assertEquals(1, h.t[2].pop().intValue());
		assertEquals(2, h.t[2].pop().intValue());
		assertEquals(3, h.t[2].pop().intValue());
	}
	
	@Test
	public void testPlay4() {
		Problem04_Hanoi h = new Problem04_Hanoi(4);
		h.play();
		assertEquals(1, h.t[2].pop().intValue());
		assertEquals(2, h.t[2].pop().intValue());
		assertEquals(3, h.t[2].pop().intValue());
		assertEquals(4, h.t[2].pop().intValue());
	}

}

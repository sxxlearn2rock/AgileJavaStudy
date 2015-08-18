package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class PerformanceTest
{
	private static final double TOLERANCE = 0.005;

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testAverage()
	{
		Performance performance = new Performance();
		performance.setNumberOfTests(4);
		performance.set(0, 98);
		performance.set(1, 92);
		performance.set(2, 81);
		performance.set(3, 72);
		
		assertEquals(92, performance.get(1));
		assertEquals(85.75, performance.average(), TOLERANCE);
	}
	
	@Test
	public void testVaraibleParms()
	{
		Performance performance = new Performance();
		performance.setScore(75, 72, 90, 60);		
		assertEquals(74.25, performance.average(), TOLERANCE);
		
		performance.setScore(100, 90);		
		assertEquals(95, performance.average(), TOLERANCE);
		
		int[] a = {1, 2, 3};
		int[] b = {1, 2, 3,};
		assertFalse(a == b);
		assertFalse(a.equals(b));
		assertTrue(Arrays.equals(a, b));
	}
	


}

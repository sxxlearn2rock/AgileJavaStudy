package cn.sxx.agilejava.courseinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CourseTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testCreate()
	{
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC"	, course.getDepartment());
		assertEquals("120", course.getNumber());
	}
	
	@Test
	public void testEquality()
	{
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");
		Course courseB = new Course("ARTH", "330");
		
		assertEquals(courseA, courseAPrime);
		assertFalse(courseA.equals(courseB));
		assertFalse(courseA.equals("NURS 201"));
	}
	
	@Test
	public void testHashCode()
	{
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");
		
		Map<Course, String> map = new HashMap<Course, String>();
		
		map.put(courseA, "");
		assertTrue(map.containsKey(courseAPrime));
		
		assertEquals(courseA.hashCode(), courseAPrime.hashCode());
		assertEquals(courseA.hashCode(), courseA.hashCode());
	}
	
	@Test(timeout = 200L)
	public void testHashCodePerformance()
	{
		final int count = 100000;
		long start = System.currentTimeMillis();
		Map<Course, String> map = new HashMap<Course, String>();
		for (int i = 0; i <count; ++i)
		{
			Course course = new Course("C" + i, "" + i);
			map.put(course	, "");
		}
//		long stop = System.currentTimeMillis();
//		long elapsed = stop - start;
//		final long th = 200;
//		assertTrue("Eclapsed time = " + elapsed, elapsed < th);
	}

}

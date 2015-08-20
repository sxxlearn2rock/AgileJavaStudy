package cn.sxx.agilejava.courseinfo;

import static org.junit.Assert.*;

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

}

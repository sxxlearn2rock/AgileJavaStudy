package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest
{
	//浮点数之差小于此即认为相等，误差范围一般为最小精度的一半
	private static final double FLOAT_TOLERANCE = 0.05;	
	
	private Student student;
	
	@Before
	public void setUp() throws Exception
	{
		student = new Student("a");		
	}

	@Test
	public void testFullTime()
	{
		assertFalse(student.isFullTime());
	}
	
	@Test
	public void testCredits()
	{
		assertEquals(0,  student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3,  student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(4);
		assertEquals(7,  student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(5);
		assertEquals(12,  student.getCredits());
		assertTrue(student.isFullTime());
	}
	
	@Test
	public void testInState()
	{
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
	
	@Test
	public void testCalculateGpa()
	{
		assertEquals(0.0,  student.getGpa(), FLOAT_TOLERANCE);
		student.addGpa("A");
		assertEquals(4.0,  student.getGpa(), FLOAT_TOLERANCE);
		student.addGpa("B");
		assertEquals(3.5,  student.getGpa(), FLOAT_TOLERANCE);
		student.addGpa("C");
		assertEquals(3.0,  student.getGpa(), FLOAT_TOLERANCE);
		student.addGpa("D");
		assertEquals(2.5,  student.getGpa(), FLOAT_TOLERANCE);
		student.addGpa("F");
		assertEquals(2.0,  student.getGpa(), FLOAT_TOLERANCE);
	}

}





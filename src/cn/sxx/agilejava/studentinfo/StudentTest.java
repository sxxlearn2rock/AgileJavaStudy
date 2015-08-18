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
	public void testCreate()
	{
		final String firstStuName = "Mad Max";
		Student firstStudent = new Student(firstStuName);
		assertEquals("Mad",  firstStudent.getFirstName());
		assertEquals("Max", firstStudent.getLastName());
		assertEquals("",  firstStudent.getMidName());		
		
		final String secondStuName = "Furiosa";
		Student secondStudent = new Student(secondStuName);
		assertEquals("Furiosa", secondStudent.getLastName());
		
		final String thirdStuName = "Immune Old Joe";
		Student thirdStudent = new Student(thirdStuName);
		assertEquals("Immune",  thirdStudent.getFirstName());
		assertEquals("Old", thirdStudent.getMidName());
		assertEquals("Joe",  thirdStudent.getLastName());	
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
		student.addGpa(Student.Grade.A);
		assertGpa(student, 4.0);
		student.addGpa(Student.Grade.B);
		assertGpa(student, 3.5);
		student.addGpa(Student.Grade.C);
		assertGpa(student, 3.0);
		student.addGpa(Student.Grade.D);
		assertGpa(student, 2.5);
		student.addGpa(Student.Grade.F);
		assertGpa(student, 2.0);
	}

	private void assertGpa(Student stu, double expectedGpa)
	{
		assertEquals(expectedGpa, stu.getGpa(), FLOAT_TOLERANCE);
	}
	

	
}





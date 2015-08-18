package cn.sxx.agilejava.courseinfo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.studentinfo.Student;
import cn.sxx.agilejava.util.DateUtil;

abstract public class SessionTest
{
	Session session;
	private static final int CREDITS = 3;	
	
	@Before
	public void setUp() throws Exception
	{
		session =createSession("ENGL","101", DateUtil.createDate(2003, 1, 6));		
		session.setNumberOfCredits(CREDITS);
	}
	
	abstract protected Session createSession(String department, String number, Date startDate);
	
	@Test
	public void testCreate()
	{	
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
	}
	
	@Test
	public void testEnrollStudents()
	{		
		final Student student1 = new Student("Cain Divoe");
		session.enroll(student1);
		assertEquals(CREDITS,  student1.getCredits());
		assertEquals(1, session.getNumOfStudents());
		
		assertEquals(student1, session.getStudent(0));
		
		final Student student2 = new Student("Tracy Mc");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2,  session.getNumOfStudents());
		assertEquals(student1,  session.getStudent(0));
		assertEquals(student2,  session.getStudent(1));
	}
}

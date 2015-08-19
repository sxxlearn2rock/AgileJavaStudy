package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class StudentDirectoryTest
{
	private StudentDirectory dir;

	@Before
	public void setUp() throws Exception
	{
		dir = new StudentDirectory();
	}

	@Test
	public void testStoreAndRetrieve() throws IOException
	{
		final int numOfStudents = 10;
		
		for (int i = 0; i < numOfStudents; ++i)
		{
			addStudent(dir, i);
		}
		
		for (int i = 0; i < numOfStudents; ++i)
		{
			vertifyStudentLookUp(dir, i);
		}
	}
	
	private void addStudent(StudentDirectory dir, int i) throws IOException
	{
		String id = "" + i;
		Student stu = new Student(id);
		stu.setId(id);
		stu.addCredits(i);
		dir.add(stu);
	}

	private void vertifyStudentLookUp(StudentDirectory dir, int i) throws IOException
	{
		String id = "" + i;
		Student stu = dir.findById(id);
		assertEquals(id, stu.getLastName());
		assertEquals(id, stu.getId());
		assertEquals(i, stu.getCredits());
	}
}





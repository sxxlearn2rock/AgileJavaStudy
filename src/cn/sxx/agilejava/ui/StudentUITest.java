package cn.sxx.agilejava.ui;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.studentinfo.Student;

public class StudentUITest
{
	private static final String name = "Leo Xerces Schmoo";

//	@Before
//	public void setUp() throws Exception
//	{
//	}

	@Test
	public void testCreateStudent() throws IOException
	{
		StringBuilder expectedOutput = new StringBuilder();
		StringBuilder input = new StringBuilder();
		setup(expectedOutput, input);
		byte[] buffer = input.toString().getBytes();
		
		InputStream inputStream = new ByteArrayInputStream(buffer);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		OutputStream outputStream = new ByteArrayOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		
		StudentUI ui = new StudentUI(reader, writer);
		ui.run();
		 
		assertEquals(expectedOutput.toString(), outputStream.toString());
//		assertStudents(ui.getAddedStudents());
	}
	
	private void assertStudents(List<Student> students)
	{
		assertEquals(1, students.size());
		Student student = students.get(0);
		assertEquals(name, student.getName());
	}

	private void setup(StringBuilder expectedOutput, StringBuilder input)
	{
		// TODO Auto-generated method stub
		
	}

	private String line(String input)
	{
		return String.format("%s%n", input);
	}

}

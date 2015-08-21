package cn.sxx.agilejava.report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.studentinfo.Student;

public class ReportCardTest
{
	private ReportCard card;
	
	@Before
	public void setUp() throws Exception
	{
		card = new ReportCard();
	}

	@Test
	public void testMessage()
	{
		assertEquals(ReportCard.A_MESSAGE,  card.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE,  card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE,  card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE,  card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE,  card.getMessage(Student.Grade.F));
	}

	@Test
	public void testKeys()
	{
		Set<Student.Grade> expectedGrades = new HashSet<Student.Grade>();
		expectedGrades.add(Student.Grade.A);
		expectedGrades.add(Student.Grade.B);
		expectedGrades.add(Student.Grade.C);
		expectedGrades.add(Student.Grade.D);
		expectedGrades.add(Student.Grade.F);
		
		Set<Student.Grade> grades = new HashSet<Student.Grade>();
		for (Student.Grade grade : card.getMessages().keySet())
		{
			grades.add(grade);
//System.out.println(grade);			
		}
		
		assertEquals(expectedGrades, grades);
	}
	
	@Test
	public void testValue()
	{
		List<String> expectedMessages = new ArrayList<String>();
		expectedMessages.add(ReportCard.A_MESSAGE);
		expectedMessages.add(ReportCard.B_MESSAGE);
		expectedMessages.add(ReportCard.C_MESSAGE);
		expectedMessages.add(ReportCard.D_MESSAGE);
		expectedMessages.add(ReportCard.F_MESSAGE);
		
		Collection<String> messages = card.getMessages().values();
		for (String string : messages)
		{
			assertTrue(expectedMessages.contains(string));
		}
		assertEquals(expectedMessages.size(), messages.size());
	}
	
	@Test
	public void testString()
	{
		String a = "aglie java";
		String b = "aglie java";
		assertTrue(a.equals(b));
	}
}

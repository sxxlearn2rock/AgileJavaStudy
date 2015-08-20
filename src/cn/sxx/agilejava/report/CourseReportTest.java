package cn.sxx.agilejava.report;

import static org.junit.Assert.*;
import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.sxx.agilejava.courseinfo.Course;
import cn.sxx.agilejava.courseinfo.CourseSession;
import cn.sxx.agilejava.courseinfo.Session;

public class CourseReportTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testReport()
	{
		final Date date = new Date();
		CourseReport report = new CourseReport();		
		report.add(create("ITAL",  "330",  date));
		report.add(create("ENGL",  "101",  date));
		report.add(create("ITAL",  "410",  date));
		report.add(create("CZEC",  "220",  date));		
		report.add(create("CZEC",  "200",  date));
//System.out.println(report);		
		assertEquals("CZEC 200" + NEWLINE + 
							"CZEC 220" + NEWLINE + 
							"ENGL 101" + NEWLINE +
							"ITAL 330" + NEWLINE +
							"ITAL 410" + NEWLINE, 
							report.toString());
	}

	@Test
	public void testComparable()
	{
		final Date date = new Date();
		Session sessionA = create("CMSC",  "101",  date);
		Session sessionB = create("ENGL",  "101",  date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		
		Session sessionC = create("CMSC",  "101",  date);
		assertEquals(0,  sessionA.compareTo(sessionC));
	}
	
	private Session create(String department, String number, Date startDate)
	{
		return CourseSession.create(new Course(department, number), startDate);
	}
	
}

package cn.sxx.agilejava.report;

import static org.junit.Assert.*;
import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.sxx.agilejava.courseinfo.CourseSession;

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
		report.add(CourseSession.create("ITAL",  "330",  date));
		report.add(CourseSession.create("ENGL",  "101",  date));
		report.add(CourseSession.create("ITAL",  "410",  date));
		report.add(CourseSession.create("CZEC",  "220",  date));		
		report.add(CourseSession.create("CZEC",  "200",  date));
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
		CourseSession sessionA = CourseSession.create("CMSC",  "101",  date);
		CourseSession sessionB = CourseSession.create("ENGL",  "101",  date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		
		CourseSession sessionC = CourseSession.create("CMSC",  "101",  date);
		assertEquals(0,  sessionA.compareTo(sessionC));
	}
	
}

package cn.sxx.agilejava.report;

import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;
import static cn.sxx.agilejava.report.ReportConstant.ROSTER_REPORT_FOOTER;
import static cn.sxx.agilejava.report.ReportConstant.ROSTER_REPORT_HEADER;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.sxx.agilejava.courseinfo.Course;
import cn.sxx.agilejava.courseinfo.CourseSession;
import cn.sxx.agilejava.courseinfo.Session;
import cn.sxx.agilejava.studentinfo.Student;
import cn.sxx.agilejava.util.DateUtil;

public class RosterReportTest
{
	private Session session;	
	
	@Before
	public void setUp() throws Exception
	{		
		session = CourseSession.create(new Course("ENGL","101"), DateUtil.createDate(2003, 1, 6));	
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}

	@Ignore
	@Test
	public void testRosterReport() throws IOException
	{
//		String rosterReportStr = new RosterReport(session).getReport();		
//System.out.println(rosterReportStr);		
		Writer writer = new StringWriter();
		new RosterReport(session).writeReport(writer);
		String rosterReport = writer.toString();
System.out.println(rosterReport);	

	}

	@Test
	public void testRosterReport2() throws IOException
	{
		Writer writer = new StringWriter();
		new RosterReport(session).writeReport(writer);
		assertReportContents(writer.toString());
	}
	
	private void assertReportContents(String rosterReport)
	{
		assertEquals(
				String.format(ROSTER_REPORT_HEADER + 
				"A%n" + 
				"B%n"  +
				ROSTER_REPORT_FOOTER , 2),
				rosterReport);
	}
	
	@Test
	public void reastFiledReport() throws IOException
	{
		final String filename = "testFiledReport.txt";
		
		try
		{
			delete(filename);
			
			new RosterReport(session).writeReport(filename);
			StringBuilder sb= new StringBuilder();
			String line;
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null)
				sb.append(String.format(line + "%n"));
			reader.close();
			assertReportContents(sb.toString());
		} finally
		{
			delete(filename);
		}
		
	}

	private void delete(String filename)
	{
		File file = new File(filename);
		if (file.exists())
		{
			assertTrue("unable to delete" + filename, file.delete());
		}		
	}
}

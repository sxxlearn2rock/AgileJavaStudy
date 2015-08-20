package cn.sxx.agilejava.report;

import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;
import static cn.sxx.agilejava.report.ReportConstant.ROSTER_REPORT_FOOTER;
import static cn.sxx.agilejava.report.ReportConstant.ROSTER_REPORT_HEADER;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
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

	@Test
	public void testRosterReport()
	{
		String rosterReportStr = new RosterReport(session).getReport();
System.out.println(rosterReportStr);
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		assertEquals(ROSTER_REPORT_HEADER + 
				"A" + NEWLINE + 
				"B" + NEWLINE +
				ROSTER_REPORT_FOOTER + "2" + NEWLINE, 
				rosterReportStr);
	}

}

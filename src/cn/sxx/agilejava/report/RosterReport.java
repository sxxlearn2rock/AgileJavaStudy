package cn.sxx.agilejava.report;

import static cn.sxx.agilejava.report.ReportConstant.*;

import cn.sxx.agilejava.courseinfo.CourseSession;
import cn.sxx.agilejava.studentinfo.Student;

public class RosterReport
{	
	private CourseSession session;
	
	public RosterReport(CourseSession session)
	{
		this.session = session;
	}

	public String getReport()
	{
		StringBuilder buffer = new StringBuilder();
		
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
	}
	
	private void writeHeader(StringBuilder buffer)
	{
		buffer.append(ROSTER_REPORT_HEADER);
	}
	
	private void writeBody(StringBuilder buffer)
	{
		for (Student student : session.getAllStudents())
		{
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}
	
	private void writeFooter(StringBuilder buffer)
	{
		buffer.append(ROSTER_REPORT_FOOTER + session.getNumOfStudents() + NEWLINE);
	}
}

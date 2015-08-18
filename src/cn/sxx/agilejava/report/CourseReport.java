package cn.sxx.agilejava.report;

import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;
import java.util.ArrayList;
import java.util.Collections;

import cn.sxx.agilejava.courseinfo.CourseSession;

public class CourseReport
{
	private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();
	
	public String toString()
	{
		Collections.sort(sessions);
		
		StringBuilder buffer = new StringBuilder();
		for (CourseSession session : sessions)
		{
			buffer.append(session.getDepartment() + " " +session.getNumber());
			buffer.append(NEWLINE);
		}
		return buffer.toString();
	}
	
	public void add(CourseSession session)
	{
		sessions.add(session);
	}
	
	

}

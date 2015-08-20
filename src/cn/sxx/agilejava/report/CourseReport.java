package cn.sxx.agilejava.report;

import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.sxx.agilejava.courseinfo.CourseSession;
import cn.sxx.agilejava.courseinfo.Session;

public class CourseReport
{
	private List<Session> sessions = new ArrayList<Session>();
	
	public String toString()
	{
		Collections.sort(sessions);
		
		StringBuilder buffer = new StringBuilder();
		for (Session session : sessions)
		{
			buffer.append(session.getDepartment() + " " +session.getNumber());
			buffer.append(NEWLINE);
		}
		return buffer.toString();
	}
	
	public void add(Session session)
	{
		sessions.add(session);
	}
	
	

}

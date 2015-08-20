package cn.sxx.agilejava.courseinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.sxx.agilejava.report.CourseReport;
import cn.sxx.agilejava.studentinfo.Student;

public class CourseSession extends Session
{		
	protected CourseSession(Course course, Date startDate)
	{
		super(course, startDate);
	}
	
	public static Session create(Course course, Date startDate)
	{
		return new CourseSession(course, startDate);
	}
	
	@Override
	protected int getSessionLength()
	{
		return 16;
	}
}

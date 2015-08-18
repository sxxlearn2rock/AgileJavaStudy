package cn.sxx.agilejava.courseinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.sxx.agilejava.studentinfo.Student;

public class CourseSession extends Session
{		
	protected CourseSession(String department, String number, Date startDate)
	{
		super(department, number, startDate);
	}
	
	public static CourseSession create(String department, String number, Date startDate)
	{
		return new CourseSession(department, number, startDate);
	}
	
	@Override
	protected int getSessionLength()
	{
		return 16;
	}
}

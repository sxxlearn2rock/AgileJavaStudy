package cn.sxx.agilejava.courseinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SummerCourseSession extends CourseSession
{

	public SummerCourseSession(String department, String number, Date startDate)
	{
		super(department, number, startDate);
	}
	
	public static SummerCourseSession create(String department, String number, Date startDate)
	{
		return new SummerCourseSession(department, number, startDate);
	}
	
	@Override
	protected int getSessionLength()
	{
		return 8;
	}
	
}

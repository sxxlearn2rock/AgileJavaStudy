package cn.sxx.agilejava.courseinfo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.util.DateUtil;

public class SummerCourseSessionTest extends SessionTest
{
	
	@Override
	protected Session createSession(Course course, Date startDate)
	{
		return SummerCourseSession.create(course, startDate);
	}

	@Test
	public void testEndDate()
	{
		Date startDate = DateUtil.createDate(2003,  6,  9);
		Session session = createSession(createCourse(),  startDate);
		Date eightWeeksOut = DateUtil.createDate(2003,  8,  1);
		assertEquals(eightWeeksOut,  session.getEndDate());		
	}

	private Course createCourse()
	{
		return 	new Course("ENLG", "200");
	}
	


}

package cn.sxx.agilejava.courseinfo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.util.DateUtil;

public class SummerCourseSessionTest extends SessionTest
{
	
	@Override
	protected Session createSession(String department, String number, Date startDate)
	{
		return SummerCourseSession.create(department, number, startDate);
	}

	@Test
	public void testEndDate()
	{
		Date startDate = DateUtil.createDate(2003,  6,  9);
		Session session = createSession("ENLG", "200",  startDate);
		Date eightWeeksOut = DateUtil.createDate(2003,  8,  1);
		assertEquals(eightWeeksOut,  session.getEndDate());
		
	}

}

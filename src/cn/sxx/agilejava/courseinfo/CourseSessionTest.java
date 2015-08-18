package cn.sxx.agilejava.courseinfo;

import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.studentinfo.Student;
import cn.sxx.agilejava.util.DateUtil;

public class CourseSessionTest extends SessionTest
{
	@Override
	protected Session createSession(String department, String number, Date startDate)
	{
		return CourseSession.create(department, number, startDate);
	}

	@Test
	public void testCourseDates()
	{
		Session session = createSession("ENGL","101", DateUtil.createDate(2003, 1, 6));
		assertEquals(DateUtil.createDate(2003, 4, 25),  session.getEndDate());
	}

}

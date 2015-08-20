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
	protected Session createSession(Course course, Date startDate)
	{
		return CourseSession.create(course, startDate);
	}

	@Test
	public void testCourseDates()
	{
		Session session = createSession(createCourse(), DateUtil.createDate(2003, 1, 6));
		assertEquals(DateUtil.createDate(2003, 4, 25),  session.getEndDate());
	}

	private Course createCourse()
	{
		return new Course("ENGL", "101");
	}

}

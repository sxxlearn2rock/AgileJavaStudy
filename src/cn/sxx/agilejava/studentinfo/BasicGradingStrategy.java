package cn.sxx.agilejava.studentinfo;

import cn.sxx.agilejava.studentinfo.Student.Grade;

public class BasicGradingStrategy implements GradingStrategy
{
	public int getGradePointsFor(Student.Grade grade)
	{
		return grade.getPoints();
	}
	
}

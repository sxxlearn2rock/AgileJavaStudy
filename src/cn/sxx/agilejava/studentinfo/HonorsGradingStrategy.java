package cn.sxx.agilejava.studentinfo;

import cn.sxx.agilejava.studentinfo.Student.Grade;

public class HonorsGradingStrategy extends BasicGradingStrategy
{
	@Override
	public int getGradePointsFor(Grade grade)
	{
		//int retPoints = basicGradePointsFor(grade);
		int retPoints = super.getGradePointsFor(grade);
		if (retPoints > 0)
		{
			retPoints += 1;
		}		
		return retPoints;
	}

}

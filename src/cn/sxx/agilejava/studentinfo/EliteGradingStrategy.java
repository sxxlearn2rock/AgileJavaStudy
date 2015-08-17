package cn.sxx.agilejava.studentinfo;

import cn.sxx.agilejava.studentinfo.Student.Grade;

public class EliteGradingStrategy extends BasicGradingStrategy
{

	@Override
	public int getGradePointsFor(Grade grade)
	{
		switch (grade)
		{
		case A:	return 4;
		case B: return 4;
		case C: return 4;
		case D: return 4;
		default: return 0;
		}
	}

}

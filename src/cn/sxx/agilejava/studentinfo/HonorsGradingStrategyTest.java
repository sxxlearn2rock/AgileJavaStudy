package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HonorsGradingStrategyTest
{
	private HonorsGradingStrategy strategy;
	
	@Before
	public void setUp() throws Exception
	{
		strategy = new HonorsGradingStrategy();
	}

	@Test
	public void test()
	{
		assertEquals(5,  strategy.getGradePointsFor(Student.Grade.A));
		assertEquals(4,  strategy.getGradePointsFor(Student.Grade.B));
		assertEquals(3,  strategy.getGradePointsFor(Student.Grade.C));
		assertEquals(2,  strategy.getGradePointsFor(Student.Grade.D));
		assertEquals(0,  strategy.getGradePointsFor(Student.Grade.F));
	}

}

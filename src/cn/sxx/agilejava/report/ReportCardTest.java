package cn.sxx.agilejava.report;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cn.sxx.agilejava.studentinfo.Student;

public class ReportCardTest
{
	private ReportCard card;
	
	@Before
	public void setUp() throws Exception
	{
		card = new ReportCard();
	}

	@Test
	public void testMessage()
	{
		assertEquals(ReportCard.A_MESSAGE,  card.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE,  card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE,  card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE,  card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE,  card.getMessage(Student.Grade.F));
	}

}

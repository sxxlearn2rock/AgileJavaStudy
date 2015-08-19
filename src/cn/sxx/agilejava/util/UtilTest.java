package cn.sxx.agilejava.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UtilTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testLabeledBreak()
	{
		List<List<String>> table = new ArrayList<List<String>>();
		
		List<String> row0 = new ArrayList<String>();
		row0.add("00");
		row0.add("01");
		List<String> row1 = new ArrayList<String>();
		row1.add("10");
		row1.add("11");	
		
		table.add(row0);
		table.add(row1);
		
		assertTrue(found(table, "10"));
		assertFalse(found(table, "22"));
	}
	
	public static boolean found(List<List<String>> table, String target)
	{
		boolean retBool = false;
		search:
			for (List<String> row : table)
			{
				for (String string : row)
				{
					if (string.equals(target))
					{
						retBool = true;
						break search;
					}
				}
			}
		return retBool;
	}
	
	@Test
	public void testCaptureScore()
	{
		assertEquals(75, Util.score("75"));
//		assertEquals(75, Util.score("g5"));
	}
	
	@Test
	public void testBadScoreEntered()
	{
		try
		{
			Util.score("adsf");
			fail("Expected NumberFormatException on bad input!");
		} catch (NumberFormatException e)
		{
			// TODO: handle exception
		}
	}
}

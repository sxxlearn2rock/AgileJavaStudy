package cn.sxx.agilejava.util;

import static org.junit.Assert.*;

import javax.xml.soap.Text;

import org.junit.Before;
import org.junit.Test;

public class StringUtilTest
{
	private static final String TEXT = "this is it, isn't it";
	
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testOccurrences()
	{
		assertEquals(0, StringUtil.occurrences(TEXT, "fuck"));
		assertEquals(1, StringUtil.occurrences(TEXT, "his"));
		assertEquals(2, StringUtil.occurrences(TEXT, "it"));
		assertEquals(3, StringUtil.occurrences(TEXT, "is"));
	}

}

package cn.sxx.agilejava.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void testConcatenateList()
	{
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		String output = StringUtil.concatenate(list);
		assertEquals(String.format("a%nb%n"), output);
	}
	
	@Test
	public void testConcatenatedDecimals()
	{
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		list.add(new BigDecimal("3.1416"));
		list.add(new BigDecimal("-1.4142"));
		
		String output = StringUtil.concatenateNumbers(list, 3);
		assertEquals(String.format("3.142%n-1.414%n"), output);
	}
	
}

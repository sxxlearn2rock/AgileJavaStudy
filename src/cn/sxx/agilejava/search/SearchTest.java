package cn.sxx.agilejava.search;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SearchTest
{
	private static final String URL = "http://jd.com";

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testCreate() throws IOException
	{
		Search search = new Search(URL, "x");
		assertEquals(URL, search.getUrl());
		assertEquals("x", search.getText());
	}

	@Test
	public void testPositiveSearch() throws IOException
	{
		Search search = new Search(URL, "运动户外");
		search.execute();
		assertTrue(search.matches() >= 1);
		assertFalse(search.errored());
	}
	
	@Test
	public void testNegativeSearch() throws IOException
	{
		Search search = new Search(URL, "京东是傻逼");
		search.execute();
		assertTrue(search.matches() == 0);
		assertFalse(search.errored());
	}
	
	@Test
	public void testErroredSearch() throws IOException
	{
		final String badUrl = URL + "\ndafdkafjkjh";
		Search search = new Search(badUrl, "whatever");
		search.execute();
		assertTrue(search.errored());
//		assertEquals(FileNotFoundException.class	, search.getError().getClass());
	}
	
}

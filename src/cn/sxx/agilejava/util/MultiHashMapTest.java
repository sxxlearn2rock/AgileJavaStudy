package cn.sxx.agilejava.util;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.print.attribute.standard.Sides;

import org.junit.Before;
import org.junit.Test;

public class MultiHashMapTest
{
	private static final Date today = new Date();
	private static final Date tomorrow = new Date(today.getTime() + 86400000);
	private static final String eventA = "wake up";
	private static final String eventB = "eat";
	
	private MultiHashMap<Date, String> events;

	@Before
	public void setUp() throws Exception
	{
		events = new MultiHashMap<Date, String>();
	}

	@Test
	public void testCreate()
	{
		assertEquals(0, events.size());
	}
	
	@Test
	public void testSingleEntry()
	{
		events.put(today, eventA);
		assertEquals(1, events.size());
		assertEquals(eventA, getSoleEvent(today));
	}
	
	@Test
	public void testMultipleEntriesDifferentKey()
	{
		events.put(today, eventA);
		events.put(tomorrow, eventB);
		assertEquals(2,  events.size());
		assertEquals(eventA, getSoleEvent(today));
		assertEquals(eventB, getSoleEvent(tomorrow));
	}
	
	@Test
	public void testMultipleEntriesSameKey()
	{
		events.put(today, eventA);
		events.put(today, eventB);
		assertEquals(1,  events.size());
		Collection<String> retrievedEvents = events.get(today);
		assertEquals(2, retrievedEvents.size());
		assertTrue(retrievedEvents.contains(eventA));
		assertTrue(retrievedEvents.contains(eventB));
	}
	
	private String getSoleEvent(Date date)
	{
		Collection<String> retrievedEvents = events.get(date);
		assertEquals(1, retrievedEvents.size());
		Iterator<String> itr = retrievedEvents.iterator();
		return itr.next();
	}
}

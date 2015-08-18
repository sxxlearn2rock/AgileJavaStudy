package cn.sxx.agilejava.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTest
{
	//浮点数之差小于此即认为相等，误差范围一般为最小精度的一半
	private static final double FLOAT_TOLERANCE = 0.05;	
	
	
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void test()
	{
		//SuperClass superClass = new SuperClass();
		SuperClass cls = new SubClass(123);
		assertTrue(cls.constructorWasCalled);
	}

}

package cn.sxx.agilejava.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTest
{
	//������֮��С�ڴ˼���Ϊ��ȣ���Χһ��Ϊ��С���ȵ�һ��
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

package cn.sxx.agilejava;

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
		//System.out.println(3 * 0.3);
		assertEquals(0.9,  3 * 0.3, FLOAT_TOLERANCE);
	}

}

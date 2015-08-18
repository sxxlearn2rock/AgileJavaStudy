package cn.sxx.agilejava.util;

public class SuperClass
{
	static boolean constructorWasCalled = false;
	
	public SuperClass(int parm)
	{
		constructorWasCalled = true;
	}
}

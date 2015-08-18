package cn.sxx.agilejava.studentinfo;

public class Performance
{
	private int[] tests;
	public void  setNumberOfTests(final int numberOfTests)
	{
		tests = new int[numberOfTests];
	}
	
	public void set(int testNum, int score)
	{
		tests[testNum] = score;
	}
	
	public void setScore(int... tests)
	{
		this.tests = tests;
	}
	
	public int get(int testNum)
	{
		return tests[testNum];
	}
	
	public double average()
	{
		double total = 0.0;
		for (int i : tests)
		{
			total += i;
		}
		return total / tests.length;
	}
}

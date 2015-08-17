package cn.sxx.agilejava.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student
{	
	public enum Grade {A, B, C, D, F};
	private static final int CREDITS_REQUIRED_FOR_FULLTIME = 12;
	public static final String IN_STATE = "CO";
	
	private String name;
	private int credits;
	private List<Grade> grades = new ArrayList<Grade>();
	private String state = "";
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	public Student(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isFullTime()
	{		
		return credits >= CREDITS_REQUIRED_FOR_FULLTIME; 
	}

	public int getCredits()
	{		
		return credits;
	}

	public void addCredits(int credies2Add)
	{
		credits += credies2Add;
	}

	public boolean isInState()
	{
		return state.equals(IN_STATE) ;
	}

	public void setState(String state)
	{
		this.state = state.toUpperCase();	//将所有输入转化为大写，避免"CO"与"Co"判断为不同		
	}

	public double getGpa()
	{
		double total = 0.0;
		if (grades.isEmpty())
			return 0.0;
		
		for (Grade grade : grades)
		{
			total += gradingStrategy.getGradePointsFor(grade);
		}
		
		return total / grades.size();
	}


	public void addGpa(Grade grade)
	{
		grades.add(grade);
	}

	public void setGradingStrategy(GradingStrategy gradingStrategy)
	{
		this.gradingStrategy = gradingStrategy;
	}
	
	
}

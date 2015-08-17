package cn.sxx.agilejava.studentinfo;

import java.util.ArrayList;

public class Student
{	
	private static final int CREDITS_REQUIRED_FOR_FULLTIME = 12;
	public static final String IN_STATE = "CO";
	
	private String name;
	private int credits;
	private ArrayList<String> grades = new ArrayList<String>();
	private String state = "";
	
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
		
		for (String grade : grades)
		{

			total += gradePointsFor(grade);
		}
		
		return total / grades.size();
	}

	private int gradePointsFor(String grade)
	{
		int ret = 0;
		switch (grade)
		{
		case "A":
			ret = 4;
			break;
		case "B":
			ret = 3;
			break;
		case "C":
			ret = 2;
			break;
		case "D":
			ret = 1;
			break;
		default:
			ret = 0;
			break;
		}
		return ret;
//	if (grade.equals("A"))
//		return  4;
//	else if (grade.equals("B"))
//		return 3;
//	else if (grade.equals("C"))
//		return 2;
//	else if (grade.equals("D"))
//		return 1;
//	else	
//		return 0;
	}

	public void addGpa(String grade)
	{
		grades.add(grade);
	}
	
	
}

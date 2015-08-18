package cn.sxx.agilejava.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student
{	
	public enum Grade
	{
		A(4), B(3), C(2), D(1), F(0);
		private int points;
		Grade(int points)
		{
			this.points = points;
		}
		
		int getPoints()
		{
			return points;
		}
	}
	
	private static final int CREDITS_REQUIRED_FOR_FULLTIME = 12;
	public static final String IN_STATE = "CO";
	
	private String name;
	private String firstName = "";
	private String lastName = "";
	private String midName = "";
	
	private int credits;
	private List<Grade> grades = new ArrayList<Grade>();
	private String state = "";
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	public Student(String fullName)
	{
		this.name = fullName;
		credits = 0;
		List<String> nameParts = split(fullName);
		setName(nameParts);
	}

	private List<String> split(String fullName)
	{
		List<String> ret = new ArrayList<String>();
		for (String string : fullName.split(" "))
		{
			ret.add(string);
		}
		return ret;
//		List<String> ret = new ArrayList<String>();
//		
//		StringBuilder word = new StringBuilder();
//		int index = 0;
//		while ( index < fullName.length() )
//		{
//			if (fullName.charAt(index) != ' ')
//			{
//				word.append(fullName.charAt(index));
//			}else if (word.length() > 0)
//			{
//				ret.add(word.toString());
//				word = new StringBuilder();
//			}
//			index++;
//		}
//		if (word.length() > 0)
//		{
//			ret.add(word.toString());
//		}
//		
//		return ret;
	}

	private void setName(List<String> nameParts)
	{
		lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if (nameParts.isEmpty())
		{
			firstName = name;
		}else
		{
			midName = name;
			firstName = removeLast(nameParts);
		}		
	}
	
	private String removeLast(List<String> list)
	{
		if (list.isEmpty())
		{
			return "";
		}
		return list.remove(list.size() - 1);
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

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getMidName()
	{
		return midName;
	}
	
	
}

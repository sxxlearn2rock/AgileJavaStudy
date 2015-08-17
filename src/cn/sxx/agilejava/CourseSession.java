package cn.sxx.agilejava;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.sxx.agilejava.studentinfo.Student;

public class CourseSession implements Comparable<CourseSession>
{	
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;
	
	public CourseSession(String department, String number)
	{
		this.department = department;
		this.number = number;
	}

	private CourseSession(String department, String number, Date startDate)
	{
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	public void enroll(Student stu)
	{
		stu.addCredits(numberOfCredits);
		students.add(stu);
	}
	
	public Date getEndDate()
	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numOfDays = 16 * 7 -3;
		calendar.add(Calendar.DAY_OF_YEAR, numOfDays);
		return calendar.getTime();
		
	}
	
	public Student getStudent(int index)
	{
		return students.get(index);
	}
	
	public ArrayList<Student> getAllStudents()
	{
		return students;
	}
	
	public String getDepartment()
	{
		return department;
	}

	public String getNumber()
	{
		return number;
	}	
	
	public int getNumOfStudents()
	{
		return students.size();
	}
	
	public Date getStartDate()
	{
		return startDate;
	}

	public static CourseSession create(String department, String number, Date startDate)
	{
		return new CourseSession(department, number, startDate);
	}

	public void setNumberOfCredits(int numberOfCredits)
	{
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public int compareTo(CourseSession that)
	{
		int departCompare =  this.getDepartment().compareTo(that.getDepartment());
		return (departCompare != 0)  ? departCompare : this.getNumber().compareTo(that.getNumber()) ;
	}
}

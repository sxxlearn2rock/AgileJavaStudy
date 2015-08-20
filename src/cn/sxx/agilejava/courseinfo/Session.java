package cn.sxx.agilejava.courseinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.sxx.agilejava.studentinfo.Student;

abstract public class Session implements Comparable<Session>
{
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;
	private URL url;
	
	public Session(String department, String number)
	{
		this.department = department;
		this.number = number;
	}

	protected Session(Course course, Date startDate)
	{
		this.department = course.getDepartment();
		this.number = course.getNumber();
		this.startDate = startDate;
	}
	
	abstract protected int getSessionLength();
	
	public void enroll(Student stu)
	{
		stu.addCredits(numberOfCredits);
		students.add(stu);
	}
	
	public Date getEndDate()
	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		final int daysInWeek = 7;
		final int daysFromFridayToMonday = 3;
		int numOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
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
	
	protected Date getStartDate()
	{
		return startDate;
	}


	public void setNumberOfCredits(int numberOfCredits)
	{
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public int compareTo(Session that)
	{
		int departCompare =  this.getDepartment().compareTo(that.getDepartment());
		return (departCompare != 0)  ? departCompare : this.getNumber().compareTo(that.getNumber()) ;
	}
	
	public void setUrl(String url) throws MalformedURLException
	{
		this.url = new URL(url);
	}

	public URL getUrl()
	{
		return url;
	}
}

package cn.sxx.agilejava.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.sxx.agilejava.studentinfo.Student;

public class StudentUI
{
	public static final String MENU = "(A)dd or (Q)uit?";
	public static final String ADD_OPTION = "A";
	public static final String QUIT_OPTION = "Q";
	public static final String NAME_PROMPT = "Name:";
	public static final String ADDED_MESSAGE = "Added";
	
	private BufferedReader reader;
	private BufferedWriter writer;
	private List<Student> students = new ArrayList<Student>();
	
	public StudentUI(BufferedReader reader, BufferedWriter writer)
	{
		this.reader = reader;
		this.writer = writer;
	}
	
	public void run() throws IOException
	{
		String line;
		do
		{
			write(MENU);
			line = reader.readLine();
			if (line.equals(ADD_OPTION))
			{
				addStudent();
			}
		} while (! line.equals(QUIT_OPTION));
	}
	
	private void addStudent() throws IOException
	{
		write(NAME_PROMPT);
		String name = reader.readLine();
		students.add(new Student(name));				
	}

	private void write(String line) throws IOException
	{
		writer.write(line, 0, line.length());
		writer.flush();
	}
	
	private void writeln(String line) throws IOException
	{
		write(line);
		writer.newLine();
		writer.flush();
	}
	
	public Object getAddedStudents()
	{
		// TODO Auto-generated method stub
		return null;
	}

}

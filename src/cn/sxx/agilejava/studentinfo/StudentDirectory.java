package cn.sxx.agilejava.studentinfo;

import java.util.HashMap;
import java.util.Map;

public class StudentDirectory
{
	private Map<String, Student> stuDir = new HashMap<String, Student>();
	public void add(Student stu)
	{
		stuDir.put(stu.getId(), stu);
	}
	
	public Student findById(String id)
	{
		return stuDir.get(id);
	}
	
}

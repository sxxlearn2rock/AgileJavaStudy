package cn.sxx.agilejava.report;

import java.util.EnumMap;
import java.util.Map;

import cn.sxx.agilejava.studentinfo.Student;
import cn.sxx.agilejava.studentinfo.Student.Grade;

public class ReportCard
{
	public static final String A_MESSAGE = "Excellent!";
	public static final String B_MESSAGE = "Itis OK. ";
	public static final String C_MESSAGE = "Hmmm...";
	public static final String D_MESSAGE = "Are u shitting me?";
	public static final String F_MESSAGE = "Just fuck off!";
	
	private Map<Student.Grade, String> message = null;
	
	public String getMessage(Grade grade)
	{
		return getMessage().get(grade);
	}

	public Map<Student.Grade, String> getMessage()
	{
		//这里使用了延迟初始化技术，是为了避免某些类生成的高开销，所以只在必须要生成该类的时候才生成它
		if (message == null)
		{
			loadMessage();
		}
		return message;
	}

	private void loadMessage()
	{
		message = new EnumMap<Student.Grade, String>(Student.Grade.class);
		message.put(Student.Grade.A, A_MESSAGE);
		message.put(Student.Grade.B, B_MESSAGE);
		message.put(Student.Grade.C, C_MESSAGE);
		message.put(Student.Grade.D, D_MESSAGE);
		message.put(Student.Grade.F, F_MESSAGE);
	}

}

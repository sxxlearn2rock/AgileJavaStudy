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
	
	private Map<Student.Grade, String> messages = null;
	
	public String getMessage(Grade grade)
	{
		return getMessages().get(grade);
	}

	public Map<Student.Grade, String> getMessages()
	{
		//这里使用了延迟初始化技术，是为了避免某些类生成的高开销，所以只在必须要生成该类的时候才生成它
		if (messages == null)
		{
			loadMessage();
		}
		return messages;
	}

	private void loadMessage()
	{
		messages = new EnumMap<Student.Grade, String>(Student.Grade.class);
		messages.put(Student.Grade.A, A_MESSAGE);
		messages.put(Student.Grade.B, B_MESSAGE);
		messages.put(Student.Grade.C, C_MESSAGE);
		messages.put(Student.Grade.D, D_MESSAGE);
		messages.put(Student.Grade.F, F_MESSAGE);
	}

}

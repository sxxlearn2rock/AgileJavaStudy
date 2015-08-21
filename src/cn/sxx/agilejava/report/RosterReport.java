package cn.sxx.agilejava.report;

import static cn.sxx.agilejava.report.ReportConstant.NEWLINE;
import static cn.sxx.agilejava.report.ReportConstant.ROSTER_REPORT_FOOTER;
import static cn.sxx.agilejava.report.ReportConstant.ROSTER_REPORT_HEADER;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import cn.sxx.agilejava.courseinfo.Session;
import cn.sxx.agilejava.studentinfo.Student;

public class RosterReport
{	
	private Session session;
	private Writer writer;
	
	public RosterReport(Session session)
	{
		this.session = session;
	}

	public String getReport()
	{
		StringBuilder buffer = new StringBuilder();
		
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
	}
	
	private void writeHeader(StringBuilder buffer)
	{
		buffer.append(ROSTER_REPORT_HEADER);
	}
	
	private void writeBody(StringBuilder buffer)
	{
		for (Student student : session.getAllStudents())
		{
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}
	
	private void writeFooter(StringBuilder buffer)
	{
		buffer.append(ROSTER_REPORT_FOOTER + session.getNumOfStudents() + NEWLINE);
	}

	public void writeReport(Writer writer) throws IOException
	{
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();		
	}
	
	private void writeHeader() throws IOException
	{
		writer.write(String.format(ROSTER_REPORT_HEADER));
	}
	
	private void writeBody() throws IOException
	{
		for (Student student : session.getAllStudents())
		{
			writer.write(String.format(student.getName() + "%n"));
		}
	}
	
	private void writeFooter() throws IOException
	{
		writer.write(String.format(ROSTER_REPORT_FOOTER ,session.getAllStudents().size()));
	}

	public void writeReport(String filename) throws IOException
	{
		Writer bufferdWriter = new BufferedWriter(new FileWriter(filename));
		try
		{
			writeReport(bufferdWriter);
		} finally
		{
			bufferdWriter.close();
		}
	}
}

package cn.sxx.agilejava.report;

public class ReportConstant
{
	public static final String NEWLINE = System.getProperty("line.separator");
//	public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE  +
//			"<----------------------->" + NEWLINE ;
//	public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	static final String ROSTER_REPORT_HEADER = "Student%n-%n";
	static final String ROSTER_REPORT_FOOTER = "%n# students = %d%n";
}

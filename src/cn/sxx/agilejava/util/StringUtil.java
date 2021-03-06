package cn.sxx.agilejava.util;

import java.math.BigDecimal;
import java.util.List;


public class StringUtil
{
	public static int occurrences(String string, String substring)
	{
		int occurrences = 0;
		int length = substring.length();
		final boolean ignoreCase = true;
		for (int i = 0; i < string.length() - substring.length()+1; ++i)
		{
			if (string.regionMatches(ignoreCase, i, substring, 0, length))
			{
				occurrences++;
			}
		}
		return occurrences;
	}
	
	public static String concatenate(List<?> list)
	{
		StringBuilder sb = new StringBuilder();
		for (Object object : list)
		{
			sb.append(String.format("%s%n", object));
		}
		return sb.toString();
	}

	public static String concatenateNumbers(List<? extends Number> list, int decimalPlaces)
	{
		String decimalFormat = "%." + decimalPlaces +"f";
		StringBuilder sb = new StringBuilder();
		for (Number number : list)
		{
			double value = number.doubleValue();
			sb.append(String.format(decimalFormat+"%n", value));
		}
		return sb.toString();
	}
}

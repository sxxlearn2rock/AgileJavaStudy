package com.jimbob.ach;

import java.sql.Date;
import java.util.List;

public class AchResponse
{
	public Date timestamp;
	public String tracetamp;
	public AchStatus status;
	public List<String> errorMessages;
}

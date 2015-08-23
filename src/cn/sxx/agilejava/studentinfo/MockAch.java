package cn.sxx.agilejava.studentinfo;



import java.util.Date;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransanctionData;

import junit.framework.Assert;

public class MockAch implements Ach
{

	@Override
	public AchResponse issueDebit(AchCredentials credentials, AchTransanctionData data)
	{
		return null;
	}

	@Override
	public AchResponse issueCredit(AchCredentials credentials, AchTransanctionData data)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AchResponse markTransanction(AchCredentials credentials, AchTransanctionData data, String traceCode)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AchResponse refundTransanction(AchCredentials credentials, AchTransanctionData data, String traceCode)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AchResponse voidSameDayTransanction(AchCredentials credentials, AchTransanctionData data, String traceCode)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AchResponse queryTransanction(AchCredentials credentials, AchTransanctionData data, String traceCode)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}

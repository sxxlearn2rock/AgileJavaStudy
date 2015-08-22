package com.jimbob.ach;

public interface Ach
{
	public AchResponse issueDebit(AchCredentials credentials, AchTransanctionData data);
	
	public AchResponse issueCredit(AchCredentials credentials, AchTransanctionData data);
	
	public AchResponse markTransanction(AchCredentials credentials, 
			AchTransanctionData data, String traceCode);
	
	public AchResponse refundTransanction(AchCredentials credentials, 
			AchTransanctionData data, String traceCode);
	
	public AchResponse voidSameDayTransanction(AchCredentials credentials, 
			AchTransanctionData data, String traceCode);
	
	public AchResponse queryTransanction(AchCredentials credentials, 
			AchTransanctionData data, String traceCode);
}

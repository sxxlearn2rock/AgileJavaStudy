package cn.sxx.agilejava.studentinfo;

import java.math.BigDecimal;

public class Account
{
	private BigDecimal balance = new BigDecimal("0.00");
	private int transanctionCount = 0;

	public void credit(BigDecimal amount)
	{
		balance = balance.add(amount);
		++transanctionCount;
	}

	public BigDecimal getBalance()
	{
		return balance;
	}

	public BigDecimal transanctionAverage()
	{
		return balance.divide(new BigDecimal(transanctionCount), BigDecimal.ROUND_HALF_UP);
	}

	
}

package cn.sxx.agilejava.studentinfo;

import java.math.BigDecimal;

public class Account
{
	private BigDecimal balance = new BigDecimal("0.00");
	private int transanctionCount = 0;
	private String bankAba;
	private String bankAccountNumber;
	private BankAccountType bankAccountType;	
//	private Ach ach;
	
	public enum BankAccountType
	{
		CHECKING("ck"), SAVINGS("sv");
		private String value;
		
		private BankAccountType(String value)
		{
			this.value = value;
		}
		
		@Override
		public String toString()
		{
			return value;
		}
	}

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

	public void transferFromBank(BigDecimal amount)
	{
		
	}
	
	public void setBankAba(String bankAba)
	{
		this.bankAba = bankAba;
	}

	public void setBankAccountNumber(String bankAccountNumber)
	{
		this.bankAccountNumber = bankAccountNumber;
	}

	public void setBankAccountType(BankAccountType bankAccountType)
	{
		this.bankAccountType = bankAccountType;
	}
	
}

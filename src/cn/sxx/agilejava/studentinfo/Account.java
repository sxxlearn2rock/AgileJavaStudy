package cn.sxx.agilejava.studentinfo;

import java.math.BigDecimal;

import javax.xml.crypto.Data;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchTransanctionData;

public class Account
{
	private BigDecimal balance = new BigDecimal("0.00");
	private int transanctionCount = 0;
	private String bankAba;
	private String bankAccountNumber;
	private BankAccountType bankAccountType;	
	private Ach ach;
	
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
		AchCredentials credentials = createCredentials();
		AchTransanctionData data = createDate(amount);
		Ach ach = getAch();
		AchResponse achResponse = ach.issueDebit(credentials, data);
		credit(amount);
	}

	private AchCredentials createCredentials()
	{
		AchCredentials credentials = new AchCredentials();
		credentials.merchantId = "12355";
		credentials.userName = "sismerc1920";
		credentials.password = "pitseleh411";
		
		return credentials;
	}
	
	private AchTransanctionData createDate(BigDecimal amount)
	{
		AchTransanctionData data = new AchTransanctionData();
		
		data.description = "transfer from bank";
		data.amount = amount;
		data.aba = bankAba;
		data.account = bankAccountNumber;
		data.accountType = bankAccountType.toString();
		
		return data;
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

	public Ach getAch()
	{
		return ach;
	}

	public void setAch(Ach ach)
	{
		this.ach = ach;
	}


}

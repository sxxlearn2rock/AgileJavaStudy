package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import java.math.BigDecimal;import java.nio.channels.NonWritableChannelException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransanctionData;

import junit.framework.Assert;

public class AccountTest
{
	static final String ABA = "102000012";
	static final String ACCOUNT_NUMBER = "194431518811";
	
	Account accountPrime;

	@Before
	public void setUp() throws Exception
	{
		accountPrime = new Account();
		accountPrime.setBankAba(ABA);
		accountPrime.setBankAccountNumber(ACCOUNT_NUMBER);
		accountPrime.setBankAccountType(Account.BankAccountType.CHECKING);
	}
	
	@Test
	public void testTransferFromBank()
	{
		
//		accountPrime.setAch(new com.jimbob.ach.JimBobAch());
//		accountPrime.setAch(new MockAch());
		accountPrime.setAch(createMockAch(AchStatus.SUCCESS));
		
		final BigDecimal amount = new BigDecimal("50.00");
		accountPrime.transferFromBank(amount);
		assertEquals(amount, accountPrime.getBalance());
	}
	
	private Ach createMockAch(AchStatus status)
	{
		return new MockAch()
		{			
			@Override
			public AchResponse issueDebit(AchCredentials credentials, AchTransanctionData data)
			{
				assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
				assertTrue(data.aba.equals(AccountTest.ABA));
				
				AchResponse response = new AchResponse();
				response.timestamp = new Date();
				response.traceCode = "1";
				//?内部类使用了外部变量，按理应该报错
				response.status = status;
				return response;
			}
		};
	}

	@Test
	public void testTransactions()
	{
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		assertEquals(new BigDecimal("11.10"), account.getBalance());
//		assertEquals(new BigDecimal("11.1"), account.getBalance());
		assertEquals(new BigDecimal("5.300"), new BigDecimal("5.000").add(new BigDecimal("0.3")));
	}
	
	@Test
	public void testTransanctionAverage()
	{
		Account account = new Account();
		account.credit(new BigDecimal("0.10"));
		account.credit(new BigDecimal("11.00"));
		account.credit(new BigDecimal("2.99"));
		assertEquals(new BigDecimal("4.70"), account.transanctionAverage());
	}

}

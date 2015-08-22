package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import java.math.BigDecimal;import java.nio.channels.NonWritableChannelException;

import org.junit.Before;
import org.junit.Test;

public class AccountTest
{
	static final String ABA = "102000012";
	static final String ACCOUNT_NUMBER = "1235489121610446481";
	
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
		accountPrime.setAch(new com.jimbob.ach.JimBobAch());
		
		final BigDecimal amount = new BigDecimal("50.00");
		accountPrime.transferFromBank(amount);
		assertEquals(amount, accountPrime.getBalance());
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

package cn.sxx.agilejava.studentinfo;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class PasswordGeneratorTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testGeneratePassword()
	{
		PasswordGenerator generator = new PasswordGenerator();
		generator.setRandom(new MockRandom('A'));
		assertEquals("ABCDEFGH", generator.generatePassword());
		generator.setRandom(new MockRandom('C'));
		assertEquals("CDEFGHIJ", generator.generatePassword());
	}
	
	class MockRandom extends Random
	{
		private int i;
		public MockRandom(char startChar)
		{
			i = startChar - PasswordGenerator.LOW_END_PASSWORD_CHAR;
		}
		@Override
		protected int next(int bits)
		{
			return i++;
		}
	}

}

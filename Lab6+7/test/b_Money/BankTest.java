package b_Money;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		Assert.assertEquals("TODO", "SweBank",  SweBank.getName());
	}

	@Test
	public void testGetCurrency() {
		Assert.assertEquals("TODO", "SEK" ,  SweBank.getCurrency().getName());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		DanskeBank.openAccount("marta");
		Assert.assertEquals("TODO", "marta" ,  DanskeBank.getAccountFromAccountlist("marta").getAccountName());


	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		Assert.assertEquals("TODO", new Integer(20000) ,  SweBank.getBalance("Ulrika"));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		SweBank.withdraw("Ulrika", new Money(10000, SEK));
		Assert.assertEquals("TODO", new Integer(0) ,  SweBank.getBalance("Ulrika"));
		SweBank.withdraw("Ulrika", new Money(20000, SEK));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		Assert.assertEquals("TODO", new Integer(0) ,  SweBank.getBalance("Ulrika"));
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {

		SweBank.deposit("Ulrika", new Money(10000, SEK));
		SweBank.transfer("Ulrika", "Bob", new Money(10000, SEK));    
		Assert.assertEquals("transfer fromAccount balance", new Integer(0) ,  SweBank.getBalance("Ulrika"));
		Assert.assertEquals("transfer toAccount balance", new Integer(10000) ,  SweBank.getBalance("Bob"));
		SweBank.transfer("Ulrika", "Bob", new Money(10000, SEK));
		Assert.assertEquals("transfer fromAccount balance", new Integer(0) ,  SweBank.getBalance("Ulrika"));
		Assert.assertEquals("transfer toAccount balance", new Integer(10000) ,  SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Ulrika", "1", new Integer(10), new Integer(5), new Money(100, SEK), SweBank, "Bob");
		Assert.assertEquals("TODO", true ,  SweBank.getAccountFromAccountlist("Ulrika").timedPaymentExists("1"));
		SweBank.removeTimedPayment("Ulrika", "1");
		Assert.assertEquals("TODO", false ,  SweBank.getAccountFromAccountlist("Ulrika").timedPaymentExists("1"));
		
		

		SweBank.deposit("Ulrika", new Money(1000, SEK));
		SweBank.addTimedPayment("Ulrika", "1", new Integer(0), new Integer(0), new Money(100, SEK), SweBank, "Bob");
		SweBank.tick();
		SweBank.tick();
		Assert.assertEquals("timed payment bank", new Integer(800), SweBank.getBalance("Ulrika"));
			}
}

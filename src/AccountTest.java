import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {

	Account n;

	@Before
	public void setUp() throws Exception {
		n = new Account(1122, 20000);
		n.setannualInterestRate(.045);
		System.out.println("Balance: " + n.getbalance() + "\nMonthly Interest Rate: " + n.getMonthlyInterestRate()
				+ "\nDate created: " + n.getdateCreated());

	}

	@After
	public void tearDown() throws Exception {
		n = null;
	}

	@Test
	public void testgetid() {
		assertTrue("The id is not equal to 1122", n.getid() == 1122);
	}

	@Test
	public void testgetbalance() {
		assertTrue("The balance is not equal to $20000", n.getbalance() == 20000);
	}

	@Test
	public void testannualInterestRate() {
		assertTrue("The Annual Interest Rate is not equal to 4.5%", n.getannualInterestRate() == .045);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testdeposit() {
		n.deposit(3000);
		assertTrue(n.getbalance() == 23000);
	}

	@Test
	public void testwithdraw() throws InsufficientFundsException {
		n.withdraw(15000);
		assertTrue(n.getbalance() == 5000);
	}

	@Test//(expected = InsufficientFundsException.class)
	public final void testwithdrawexception()  {
		try {
			n.deposit(5000);
			n.withdraw(90000);
			//assertEquals("-$4000 expected, actual is $5000", (long) n.getbalance(), (long) -4000);
		}
		catch (InsufficientFundsException x) {
			System.out.println("Insufficient Funds Exception");
			
		}
	}

	@Test
	public void testgetMonthlyInterestRate() {
		assertTrue(n.getMonthlyInterestRate() == .00375);
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Saving_S2021_SchmeelkBank_Test {
	
	Saving_S2021_SchmeelkBank s1;
	Saving_S2021_SchmeelkBank s2;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Saving_S2021_SchmeelkBank("1", "Savings 1", 3000);
		s2 = new Saving_S2021_SchmeelkBank("2", "Savings 2", 1000);
	}
	
	@Test
	public void depositSavings() {
		s1.depositSavings(1000);
		assertEquals(4000, s1.getsavingBalance());
	}
	
	@Test
	public void withdrawalSavings() {
		try {
			s1.withdrawlSavings(500);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(2500, s1.getsavingBalance()); //initial amount: 3000 - 500 = 2500
	}
	
	@Test
	public void withdrawalErrorSavings() {
		try {
			s1.withdrawlSavings(10000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(3000, s1.getsavingBalance()); //initial amount: 3000 - 10000 = ERROR
		Assert.assertNotEquals(13000, s1.getsavingBalance());
	}
	
	@Test
	public void chargeFeeSavings() {
		try {
			s1.fee();
		} catch (SavingFeeError e) {
			System.out.println(e);
		}
		assertEquals(3000, s1.getsavingBalance());
		
		try {
			s2.fee();
		} catch (SavingFeeError e) {
			System.out.println(e);
		}
		assertEquals(950, s2.getsavingBalance());
	}

}

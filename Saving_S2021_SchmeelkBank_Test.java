import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Saving_S2021_SchmeelkBank_Test {
	
	Saving_S2021_SchmeelkBank s1;
	Saving_S2021_SchmeelkBank s2;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Saving_S2021_SchmeelkBank(1, "Savings 1", 3000);
		s2 = new Saving_S2021_SchmeelkBank(2, "Savings 2", 1000);
	}
	
	@Test
	public void depositSavings() {
		s1.depositSavings(1000);
		assertEquals(4000, s1.getsavingBalance());
	}
	/*
	@Test
	public void withdrawalSavings() {
		s1.withdrawlSavings(500);
		assertEquals(2500, s1.getsavingBalance());
	}
	
	@Test
	public void withdrawalErrorSavings() {
		assertEquals(false, s1.withdrawlSavings(10000));
	}
	
	@Test
	public void chargeFeeSavings() {
		assertEquals(3000, s1.fee());
		assertEquals(950, s2.fee());
	}*/

}

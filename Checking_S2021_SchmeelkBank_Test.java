import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Checking_S2021_SchmeelkBank_Test {
	
	Checking_S2021_SchmeelkBank c1;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Checking_S2021_SchmeelkBank(1, "Checking 1", 1000);
	}
	
	@Test
	public void depositCheckings() {
		c1.depositChecking(50);
		assertEquals(1050, c1.getcheckingBalance());
	}
	
	@Test
	public void withdrawalCheckings() {
		try {
			c1.withdrawlChecking(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(950, c1.getcheckingBalance()); //initial amount 1000 - 50
	}
	
	@Test
	public void withdrawalErrorCheckings() {
		try {
			c1.withdrawlChecking(2000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		assertEquals(1000, c1.getcheckingBalance()); //initial amount 1000 - 1000 = ERROR
	}
	
}


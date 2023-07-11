package Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
	@Test
	public void assertPractice(){
		int a = 30;
		int b = 50;
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(a==b, "FAIL");
		Reporter.log("PASS");
		sa.assertAll();
	}
}

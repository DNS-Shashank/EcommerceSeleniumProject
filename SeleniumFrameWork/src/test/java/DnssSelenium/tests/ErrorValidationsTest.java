package DnssSelenium.tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import DnssSelenium.TestComponents.BaseTest;
import DnssSelenium.TestComponents.Retry;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups={"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void ErrorValidation() throws IOException

	{
		landingPage.loginApplication("dnss@gmail.com", "Passwword1!");
		Assert.assertEquals("Incorrect emffail or password.", landingPage.errorValidation());
	}

}

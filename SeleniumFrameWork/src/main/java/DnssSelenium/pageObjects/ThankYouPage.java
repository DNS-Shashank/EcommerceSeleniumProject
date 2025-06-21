package DnssSelenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DnssSelenium.AbstractComponents.AbstractComponents;
import java.util.List;

public class ThankYouPage extends AbstractComponents {

	WebDriver driver;

	// Constructor
	public ThankYouPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css=".hero-primary")
	WebElement thankYouText;
	
	public void finalValidation(String textInWebPage)
	{
		Assert.assertTrue(thankYouText.getText().equalsIgnoreCase(textInWebPage));
	}
}

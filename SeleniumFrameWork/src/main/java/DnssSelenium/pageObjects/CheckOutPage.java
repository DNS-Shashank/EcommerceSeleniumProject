package DnssSelenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DnssSelenium.AbstractComponents.AbstractComponents;
import java.util.List;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;

	// Constructor
	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="input[placeholder='Select Country']")
	WebElement autoDropDown;
	
	@FindBy(css=".ta-results button")
	List<WebElement> countriesList;
	
	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrderBtn;
	
	public void selectionOfCountry(String countryName)
	{
		autoDropDown.sendKeys(countryName);
		WebElement finalCountry = countriesList.stream().filter(country -> country.getText().equals(countryName))
				.findFirst().orElse(null);
		finalCountry.click();
		
	}
	
	public ThankYouPage placingOrder(String countryName)
	{
		selectionOfCountry(countryName);
		placeOrderBtn.click();
		ThankYouPage thankYou = new ThankYouPage(driver);
		return thankYou;
	}
	

}

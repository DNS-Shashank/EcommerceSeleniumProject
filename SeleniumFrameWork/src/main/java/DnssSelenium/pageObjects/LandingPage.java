package DnssSelenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DnssSelenium.AbstractComponents.AbstractComponents;

//Now in this class let's include all the locators in the landing page
public class LandingPage extends AbstractComponents {

	WebDriver driver;

	// Constructor
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Here, we're giving the knowledge of the driver so that it'll fetch
		// the details and "this" indicates that it belongs to the constructor method
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail")); -> This is the
	// generic method which we used till now

	// Page Factory -> This does the same function which the above line works. And
	// the knowledge about "driver" to this is given in the constructor

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement loginBtn;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorToast;

	public ProductCataloguePage loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginBtn.click();
		ProductCataloguePage ProductCatalogue = new ProductCataloguePage(driver);
		return ProductCatalogue;
	}

	public String errorValidation() {
		waitForWebElementToAppear(errorToast);
		return errorToast.getText();
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");

	}
}

package DnssSelenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DnssSelenium.AbstractComponents.AbstractComponents;
import java.util.List;

public class MyCartPage extends AbstractComponents {

	WebDriver driver;

	// Constructor
	public MyCartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css =".cartSection h3")
	List<WebElement> cartProducts;
	
	
	public Boolean productValidation(String productName)
	{
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}

package DnssSelenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DnssSelenium.AbstractComponents.AbstractComponents;
import java.util.List;

public class OrdersPage extends AbstractComponents {

	WebDriver driver;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> ordersList;

	// Constructor
	public OrdersPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean verifyOrderInList(String productName) {
		Boolean match = ordersList.stream().anyMatch(orders -> orders.getText().equalsIgnoreCase(productName));
		return match;
	}

}

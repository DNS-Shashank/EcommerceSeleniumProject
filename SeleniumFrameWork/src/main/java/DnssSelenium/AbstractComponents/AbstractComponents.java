package DnssSelenium.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DnssSelenium.pageObjects.CheckOutPage;
import DnssSelenium.pageObjects.MyCartPage;
import DnssSelenium.pageObjects.OrdersPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink*='dashboard/cart']")
	WebElement cartButton;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement placeOrderBtn;

	@FindBy(css = "li[class='totalRow'] button[type='button']")
	WebElement checkOut;

	@FindBy(css = "[routerlink*=\"myorders\"]")
	WebElement orderBtn;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToDissapear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public MyCartPage navigateToCart() {

		cartButton.click();
		MyCartPage MyCart = new MyCartPage(driver);
		return MyCart;
	}

	public CheckOutPage navigateToCheckout() {
		checkOut.click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
	}

	public OrdersPage navigateToOrders() {
		orderBtn.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;

	}

}
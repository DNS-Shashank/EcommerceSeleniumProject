package DnssSelenium.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DnssSelenium.tests.*;
public class standAloneTestInitial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// WebDriverManager.chromedriver().setup();

		String productName = "ZARA COAT 3";
		String countryName = "India";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");

		// Login
		driver.findElement(By.id("userEmail")).sendKeys("dnss@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Password1!");
		driver.findElement(By.id("login")).click();

		// Adding Items to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		// Stream is used to scan the products in the list, it basically does the job of
		// FOR loop in a simplified manner
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.tagName("h5")).getText().equals(productName)).findFirst()
				.orElse(null);

//		The below code does the same using the Generic FOR LOOP
//		for (WebElement product : products) {
//
//			String productName = product.findElement(By.tagName("h5")).getText();
//
//			if (productName.equals("ZARA COAT 3")) {
//				System.out.println("Yes");
//			}
//		}

		// Clicking on Add to Cart
		prod.findElement(By.cssSelector(".mb-3 button:last-of-type")).click();
		//Validation of TOAST MESSSAGE
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector(".ng-animating"))));

		
		//Checking the Cart and validating our added items
		driver.findElement(By.cssSelector("button[routerlink*='dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);
		System.out.println(match);

		driver.findElement(By.cssSelector(".totalRow button")).click();

		// CheckOut
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");

		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results button"));

		WebElement finalCountry = countries.stream().filter(country -> country.getText().equals(countryName))
				.findFirst().orElse(null);
		finalCountry.click();

		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

		// Final Validation
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}

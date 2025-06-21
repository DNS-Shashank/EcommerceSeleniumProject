package DnssSelenium.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DnssSelenium.TestComponents.BaseTest;
import DnssSelenium.pageObjects.CheckOutPage;
import DnssSelenium.pageObjects.LandingPage;
import DnssSelenium.pageObjects.MyCartPage;
import DnssSelenium.pageObjects.OrdersPage;
import DnssSelenium.pageObjects.ProductCataloguePage;
import DnssSelenium.pageObjects.ThankYouPage;
public class standAloneTest extends BaseTest {
	
	String countryName = "India";
	String textInWebPage = "Thankyou for the order.";

	@Test(dataProvider="getData",groups={"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException
	
	{
		// LandingPage
		ProductCataloguePage ProductCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		// ProdcutCatalogue
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(input.get("product"));
		MyCartPage MyCart = ProductCatalogue.navigateToCart();
		
		//MyCart
		Boolean match = MyCart.productValidation(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkOut = MyCart.navigateToCheckout();
		
		// CheckOut
		ThankYouPage thankYou = checkOut.placingOrder(countryName);
		
		// Final Validation
		thankYou.finalValidation(textInWebPage);

	}
	
	@Test(dataProvider = "getData",dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest(HashMap<String, String> input)
	{
		ProductCataloguePage ProductCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		OrdersPage orderPage = ProductCatalogue.navigateToOrders();
		Assert.assertTrue(orderPage.verifyOrderInList(input.get("product")));
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "dnss@gmail.com");
//		map.put("password", "Password1!");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("email", "anshika@gmail.com");
//		map2.put("password", "Iamking@000");
//		map2.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\DnssSelenium\\data\\PurchaseOrderData.json");		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}

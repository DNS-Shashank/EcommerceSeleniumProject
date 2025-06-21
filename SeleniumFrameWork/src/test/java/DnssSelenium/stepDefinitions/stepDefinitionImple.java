package DnssSelenium.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DnssSelenium.TestComponents.BaseTest;
import DnssSelenium.pageObjects.CheckOutPage;
import DnssSelenium.pageObjects.LandingPage;
import DnssSelenium.pageObjects.MyCartPage;
import DnssSelenium.pageObjects.ProductCataloguePage;
import DnssSelenium.pageObjects.ThankYouPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImple extends BaseTest {

	public LandingPage landingpage;
	public ProductCataloguePage ProductCatalogue;
	public MyCartPage MyCart;
	public ThankYouPage thankYou;

	@Given("I landed on Eccomerce Page")
	public void i_landed_on_ecommerce_page() throws IOException {
		landingpage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_name_password(String username, String password) {
		ProductCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) {
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_product_and_submit_order(String product) {
		MyCart = ProductCatalogue.navigateToCart();

		// MyCart
		Boolean match = MyCart.productValidation(product);
		Assert.assertTrue(match);
		CheckOutPage checkOut = MyCart.navigateToCheckout();

		// CheckOut
		thankYou = checkOut.placingOrder("India");

	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void messsage_displayed_confirmationPage(String string) {
		thankYou.finalValidation(string);
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void error_message_is_displayed(String string)
	{
		Assert.assertEquals(string, landingPage.errorValidation());
		driver.close();
	}

}

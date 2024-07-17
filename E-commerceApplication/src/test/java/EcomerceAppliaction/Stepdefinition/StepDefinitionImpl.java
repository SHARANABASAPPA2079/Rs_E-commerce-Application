package EcomerceAppliaction.Stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import EcommerceApplication.TestComponents.BaseTest;
import EcommerceApplication.pageObjects.CartPage;
import EcommerceApplication.pageObjects.CheckoutPage;
import EcommerceApplication.pageObjects.ConfirmationPage;
import EcommerceApplication.pageObjects.LandingPage;
import EcommerceApplication.pageObjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest

{
	public LandingPage landingPage;
	ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;

	 @Given("^I landed on Ecommerce Page$")
	    public void i_landed_on_ecommerce_page() throws IOException

	{
		landingPage = launchApplication();
	}

	 @Given("^Logged in with username (.+) and password (.+)$")
	    public void logged_in_with_username_and_password(String username, String password)

	{
		productCatalogue = landingPage.loginApplication(username, password);
	}

	 @When("^I add product (.+) to cart$")
	    public void i_add_product_to_cart(String productname)

	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productname);
	}

	@When("^Checkout (.+) and submit the order$")

	public void checkout_and_submit_the_order(String productName)

	{
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	
	
	@Then("^\"([^\"]*)\" Message is displayed on confirmation page$")
    public void something_message_is_displayed_on_confirmation_page(String strArg12)
	{
		String conMsg = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(conMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) 
	
	{
		Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		driver.close();
    }

}

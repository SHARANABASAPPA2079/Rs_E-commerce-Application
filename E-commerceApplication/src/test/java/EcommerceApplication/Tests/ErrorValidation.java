package EcommerceApplication.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import EcommerceApplication.TestComponents.BaseTest;
import EcommerceApplication.TestComponents.Retry;
import EcommerceApplication.pageObjects.CartPage;
import EcommerceApplication.pageObjects.ProductCatalogue;

public class ErrorValidation extends BaseTest

{
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException

	{

		landingPage.loginApplication("sharanpadashetty63@gmail.com", "Padashetty=2110");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void procucatErrorValidation() throws IOException

	{

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("sharanpadashetty637@outlook.com",
				"Sap@1234");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertTrue(match);

	}

}

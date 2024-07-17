package EcommerceApplication.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommerceApplication.TestComponents.BaseTest;
import EcommerceApplication.pageObjects.CartPage;
import EcommerceApplication.pageObjects.CheckoutPage;
import EcommerceApplication.pageObjects.ConfirmationPage;
import EcommerceApplication.pageObjects.OrderPage;
import EcommerceApplication.pageObjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest

{
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException

	{

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("produtName"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("produtName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String conMsg = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(conMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })

	public void OrderHistoryTest()

	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("sharanpadashetty637@gmail.com",
				"Padashetty=2110");
		OrderPage ordersPage = productCatalogue.goOrderPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}

	@DataProvider

	public Object[][] getData() throws IOException

	{
		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "sharanpadashetty637@gmail.com"); map.put("password", "Padashetty=2110");
		 * map.put("produtName", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "sharanpadashetty637@outlook.com"); map1.put("password",
		 * "Sap@1234"); map1.put("produtName", "ZARA COAT 3");
		 */

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\EcommerceApplication\\data\\PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	/*
	 * @DataProvider
	 * 
	 * public Object[][] getData()
	 * 
	 * {
	 * 
	 * return new Object[][] { { "sharanpadashetty637@gmail.com", "Padashetty=2110",
	 * "ZARA COAT 3" }, { "sharanpadashetty637@outlook.com", "Sap@1234",
	 * "ZARA COAT 3" } }; }
	 */

}

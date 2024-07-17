package EcommerceApplication.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents

{
	WebDriver driver;

	public CheckoutPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	private WebElement submit;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName)

	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selCountry.click();
	}
	
	public ConfirmationPage submitOrder()
	
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
}

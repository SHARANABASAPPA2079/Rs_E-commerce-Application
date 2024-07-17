package EcommerceApplication.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents 

{
	WebDriver driver;

	public LandingPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
	@FindBy(css = "#userEmail")
	WebElement userEmail;
	// WebElement userPassword = driver.findElement(By.cssSelector("#userPassword"))
	@FindBy(css = "#userPassword ")
	WebElement userPassword;
	// WebElement submit = driver.findElement(By.id("login"));
	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "[class*='ng-trigger-flyInOut']")
	WebElement errorMsg;

	public ProductCatalogue loginApplication(String email, String password)

	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public String getErrorMessage()

	{
		waitForwebElementToAppear(errorMsg);
		return errorMsg.getText();
		
	}
	 
	public void goTo()

	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

	
}

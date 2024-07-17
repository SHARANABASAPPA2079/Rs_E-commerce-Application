package EcommerceApplication.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents

{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
//	String conMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	
	{
		/*CheckoutPage cp =  new CheckoutPage(driver);
		cp.submit.click();//Directly calling fields*/
		return confirmationMessage.getText();
	}
}

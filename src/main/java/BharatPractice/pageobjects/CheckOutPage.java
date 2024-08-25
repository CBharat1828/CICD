package BharatPractice.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BharatPractice.AbstractComponents.AbstractComponent;

public class CheckOutPage  extends AbstractComponent{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="input[placeholder*='Select Country']")
WebElement  country;
	@FindBy(css=".ta-item:last-child")
	WebElement selectCountry;
	@FindBy(css=".action__submit")
	WebElement submit;
	By resultsby=By.cssSelector(".ta-results");
	@FindBy(css="button[routerlink*='/dashboard/cart']")
	WebElement ClickToCartPage;
	
	public void verifyCountryName(String countryName)
	{
	
	
	Actions a1= new Actions(driver);
	a1.sendKeys(country,countryName).build().perform();
	waitForTheElementToAppear(resultsby);
	selectCountry.click();
    
	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		ConfirmationPage confirmationPage= new ConfirmationPage(driver);
		return confirmationPage;
	}

}

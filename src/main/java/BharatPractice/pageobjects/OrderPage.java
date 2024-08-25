package BharatPractice.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BharatPractice.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//tr /td[2]")
	List<WebElement> productNames;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOut;
	
	
	public Boolean verifyOrderByName(String productName)
	{
	
	Boolean match=productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
	
	}
	
}

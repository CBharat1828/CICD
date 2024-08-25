package BharatPractice.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BharatPractice.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOut;
	
	
	public Boolean verifyProductByName(String productName)
	{
	
	Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
	
	}
	public CheckOutPage leadToCheckOut()
	{
		checkOut.click();
		CheckOutPage checkoutPage = new CheckOutPage(driver);
		return checkoutPage;
	}

}
;
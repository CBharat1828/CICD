package BharatPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BharatPractice.pageobjects.CartPage;
import BharatPractice.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="button[routerlink*='/dashboard/cart']")
	WebElement goToCart;
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement goToOrder;

	public void waitForTheElementToAppear(By findBy)
	{

WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForTheWebElementToAppear(WebElement findBy)
	{

WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
wait.until(ExpectedConditions.visibilityOf(findBy));
	
	
	}
	public CartPage proceedToCart()
	{
		goToCart.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
	}
	public OrderPage proceedToOrderPage()
	{
		goToOrder.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	
	public void  waitForTheElementToDisappear(WebElement ele) throws InterruptedException
	{
	Thread.sleep(1000);
	}

}

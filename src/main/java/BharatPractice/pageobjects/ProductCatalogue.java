package BharatPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import BharatPractice.AbstractComponents.AbstractComponent;

public class ProductCatalogue  extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		
		waitForTheElementToAppear(productsBy);
		return products;
			
	}
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(product
				->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;

	}
	public void addProductToCart(String productName) throws InterruptedException
	{ 
		WebElement prod=getProductByName( productName);
		prod.findElement(By.cssSelector(".card-body .btn:last-child")).click();
		waitForTheElementToAppear(toastMessage);
		waitForTheElementToDisappear(spinner);
	}
	
}

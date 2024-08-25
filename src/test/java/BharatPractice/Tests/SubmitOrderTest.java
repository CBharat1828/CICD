package BharatPractice.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Bharat.TestComponents.BaseTest;
import BharatPractice.pageobjects.CartPage;
import BharatPractice.pageobjects.CheckOutPage;
import BharatPractice.pageobjects.ConfirmationPage;
import BharatPractice.pageobjects.LandingPage;
import BharatPractice.pageobjects.OrderPage;
import BharatPractice.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName="ZARA COAT 3";
	@Test(dataProvider="getData",groups="Purchase")
	public void submitOrder(HashMap<String, String>input) throws IOException, InterruptedException {
		
 ProductCatalogue productCatalogue= landingPage.loginApplication(input.get("email"),input.get("password"));
 
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));

List<WebElement>products=productCatalogue.getProductList();

productCatalogue.addProductToCart(input.get("product"));
CartPage cartPage=productCatalogue.proceedToCart();
Boolean match=cartPage.verifyProductByName(input.get("product"));
Assert.assertTrue(match);
CheckOutPage checkOutPage=cartPage.leadToCheckOut();

checkOutPage.verifyCountryName("India");
 
ConfirmationPage confirmationPage=checkOutPage.submitOrder();

String confirmMessage=confirmationPage.getConfirmationMessage();
Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		 ProductCatalogue productCatalogue= landingPage.loginApplication("bharat1234@gmail.com", "Bharat@1234");
		 OrderPage orderPage=productCatalogue.proceedToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderByName(productName));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		 List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Bharat\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
	//HashMap<String,String> map = new HashMap<String,String>();
			//map.put("email","bharat1234@gmail.com" );
			//map.put("password","Bharat@1234");
			//map.put("product", "ZARA COAT 3");
			
			//HashMap<String,String> map1 = new HashMap<String,String>();
			//map1.put("email","saiharsha14@gmail.com" );
			//map1.put("password","Saiharsha@14");
			//map1.put("product", "ADIDAS ORIGINAL");
	



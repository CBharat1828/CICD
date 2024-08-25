package BharatPractice.Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Bharat.TestComponents.BaseTest;
import Bharat.TestComponents.Retry;
import BharatPractice.pageobjects.CartPage;
import BharatPractice.pageobjects.CheckOutPage;
import BharatPractice.pageobjects.ConfirmationPage;
import BharatPractice.pageobjects.LandingPage;
import BharatPractice.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorValidate"})
	public void loginErrorValidation() throws IOException {
		
		
		String productName="ZARA COAT 3";
		
		
 landingPage.loginApplication("bharat1234@gmail.com", "Bharat1234");
Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
 


	}
	

}

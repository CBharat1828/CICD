package Bharat.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Bharat.TestComponents.BaseTest;
import BharatPractice.pageobjects.CartPage;
import BharatPractice.pageobjects.CheckOutPage;
import BharatPractice.pageobjects.ConfirmationPage;
import BharatPractice.pageobjects.LandingPage;
import BharatPractice.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimpl extends BaseTest{
public LandingPage landingPage;
ProductCatalogue productCatalogue;
ConfirmationPage confirmationPage;

	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage=launchApplication();
	}
	
	
	 @Given ("^Logged in with username (.+) and password (.+)$")
	 public void Logged_in_with_username_and_password(String username, String password)
	 {
		  productCatalogue= landingPage.loginApplication(username, password);
	 }
	
	 @When ("^I added the product (.+) to cart$")
	 public void I_added_the_product_to_cart(String productName) throws InterruptedException
	 {
		 List<WebElement>products=productCatalogue.getProductList();

		 productCatalogue.addProductToCart(productName);
	 }
	    @When ("^CheckOut (.+) and submit the order$")
	    public void CheckOut_and_submit_the_order(String productName)
	    {
	    	CartPage cartPage=productCatalogue.proceedToCart();
	    	Boolean match=cartPage.verifyProductByName(productName);
	    	Assert.assertTrue(match);
	    	CheckOutPage checkOutPage=cartPage.leadToCheckOut();
	    	checkOutPage.verifyCountryName("India");
	    	confirmationPage= checkOutPage.submitOrder();
	    	 
	    }
	    @Then ("{string} message is displayed on ConfirmationPage")
	    public void message_is_displayed_on_ConfirmationPage(String string)
	    {
	    	String confirmMessage=confirmationPage.getConfirmationMessage();
	    	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	    	driver.close();
	    }
	    @Then("{string} message is displayed on the landingPage")
	    public void message_is_displayed_on_the_landingPage(String string)
	    {
	    	 landingPage.loginApplication("bharat1234@gmail.com", "Bharat1234");
	    	 Assert.assertEquals(string, landingPage.getErrorMessage());
	    	 driver.close();
	    	  


	    }
	
}

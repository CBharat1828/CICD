package BharatPractice.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BharatPractice.AbstractComponents.AbstractComponent;

public class ConfirmationPage  extends AbstractComponent{
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css=".hero-primary")
	WebElement confirmText;
	
	public String getConfirmationMessage()
	{
		return confirmText.getText();
	
	
	}

}

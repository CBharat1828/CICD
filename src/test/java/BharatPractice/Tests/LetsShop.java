package BharatPractice.Tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetsShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/client/");
driver.findElement(By.cssSelector("#userEmail")).sendKeys("bharat1234@gmail.com");
driver.findElement(By.cssSelector("#userPassword")).sendKeys("Bharat@1234");
driver.findElement(By.cssSelector("#login")).click();
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
WebElement prod=products.stream().filter(product
		->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
prod.findElement(By.cssSelector(".card-body .btn:last-child")).click();
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']")).click();
List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
Assert.assertTrue(match);
driver.findElement(By.xpath("//button[text()='Checkout']")).click();
Actions a1= new Actions(driver);
a1.sendKeys(driver.findElement(By.cssSelector("input[placeholder*='Select Country']")),"India").build().perform();
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
driver.findElement(By.cssSelector(".ta-item:last-child")).click();
driver.findElement(By.cssSelector(".action__submit")).click();
String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();


	}

}

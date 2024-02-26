package ayushjain.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ayushjain.pageobjects.LandingPage;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String productName = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage page = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("xyzabc1238@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dummy@123");
		driver.findElement(By.className("btn-block")).click();
		List<WebElement> products = driver.findElements(By.className("mb-3"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("h5")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body .btn[style='float: right;']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-tns-c31-4")));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));	
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow .btn")).click();
		
		WebElement wb = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		Actions a = new Actions(driver);
		a.sendKeys(wb, "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-results .ta-item:last-child")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		
		System.out.println("Hello World");
		System.out.println("Hello World1");
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		
		
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		System.out.println("Hello World2");
		
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");
		System.out.println("Ayush Jain");

		
		
	}

}

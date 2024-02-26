package ayushjain.AbstractComponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ayushjain.pageobjects.CartPage;
import ayushjain.pageobjects.OrderPage;

public class AbstarctComponent {
	
	WebDriver driver;
	
	public AbstarctComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)); 
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy)); 
	}
	
	
	
	public void waitForElementToDisappear(WebElement element) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(element));
		Thread.sleep(1000);
	}
	
	
	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css = "button[routerlink*='myorders']")
	WebElement orderHistory;
	
	public CartPage goToCart() {
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrder() {
		orderHistory.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
}

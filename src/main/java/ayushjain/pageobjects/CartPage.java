package ayushjain.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushjain.AbstractComponent.AbstarctComponent;


public class CartPage extends AbstarctComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow .btn")
	WebElement checkout;
	
//	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

	public boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));	
		return match;
	}

	public CheckoutPage goToCheckout() {
		checkout.click();
		return new CheckoutPage(driver);
	}
	

}

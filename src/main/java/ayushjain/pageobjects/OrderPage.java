package ayushjain.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushjain.AbstractComponent.AbstarctComponent;

public class OrderPage extends AbstarctComponent {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	public boolean verifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));	
		return match;
	}

}

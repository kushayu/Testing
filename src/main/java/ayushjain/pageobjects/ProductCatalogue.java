package ayushjain.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ayushjain.AbstractComponent.AbstarctComponent;


public class ProductCatalogue extends AbstarctComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(className = "mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-tns-c31-4")
	WebElement spinner;
	
	By productsBy = By.className("mb-3");
	By addTocart = By.cssSelector(".card-body .btn[style='float: right;']");
	By toastMessage = By.cssSelector("#toast-container");
	By spiralAnimation = By.cssSelector(".ng-tns-c31-4");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		return getProductList().stream().filter(product->
		product.findElement(By.cssSelector("h5")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
	    prod.findElement(addTocart).click();
	    waitForElementToAppear(toastMessage);
	    waitForElementToDisappear(spinner);
	}
	

}

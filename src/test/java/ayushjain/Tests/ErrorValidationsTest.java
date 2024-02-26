package ayushjain.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ayushjain.TestComponents.BaseTest;
import ayushjain.pageobjects.CartPage;
import ayushjain.pageobjects.CheckoutPage;
import ayushjain.pageobjects.ConfirmationPage;
import ayushjain.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@org.testng.annotations.Test(groups = {"ErrorHandling"})
	public void loginErrorValidation() throws IOException, InterruptedException{
		String productName = "ZARA COAT 3";
	
		ProductCatalogue cataloguePage = page.loginApplication("xyzabc1238@gmail.com", "Dummy@123");
		Assert.assertEquals(page.getErrorMessage(),"Login Successfully");

		
	}
	@org.testng.annotations.Test
	public void productErrorValidation() throws IOException, InterruptedException{
		String productName = "ZARA COAT 3";
	
		ProductCatalogue cataloguePage = page.loginApplication("pqrst@gmail.com", "Temp@123");

		List<WebElement> products = cataloguePage.getProductList();
		cataloguePage.addProductToCart(productName);
		CartPage cartPage = cataloguePage.goToCart();

		Assert.assertTrue(cartPage.verifyProductDisplay(productName));
		
		
		
	}

}

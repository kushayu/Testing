package ayushjain.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import ayushjain.TestComponents.BaseTest;
import ayushjain.pageobjects.CartPage;
import ayushjain.pageobjects.CheckoutPage;
import ayushjain.pageobjects.ConfirmationPage;
import ayushjain.pageobjects.OrderPage;
import ayushjain.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	@org.testng.annotations.Test(dataProvider = "getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> map) throws IOException, InterruptedException{
	
		ProductCatalogue cataloguePage = page.loginApplication(map.get("email"), map.get("password"));

		List<WebElement> products = cataloguePage.getProductList();
		cataloguePage.addProductToCart(map.get("productName"));
		CartPage cartPage = cataloguePage.goToCart();
		
		
		Assert.assertTrue(cartPage.verifyProductDisplay(map.get("productName")));
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
		String message = confirmationPage.getConfirmationMessage();
		
		Assert.assertEquals(message, "THANKYOU FOR THE ORDER.");
		
	}
	
	@org.testng.annotations.Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest(HashMap<String, String> map) {
		ProductCatalogue cataloguePage = page.loginApplication(map.get("email"), map.get("password"));
		OrderPage orderPage = cataloguePage.goToOrder();
		Assert.assertTrue(orderPage.verifyOrderDisplay(map.get("productName")));
	}
	
	@DataProvider
	public Object[][] getData(){
		HashMap<String, String> map = new HashMap<>();
		map.put("email","xyzabc1238@gmail.com");
		map.put("password","Dummy@123");
		map.put("productName","ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("email","pqrst@gmail.com");
		map1.put("password","Temp@123");
		map1.put("productName","IPHONE 13 PRO");
		
		return new Object[][] {{map},{map1}};
	}

}

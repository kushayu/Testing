package ayushjain.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ayushjain.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage page;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ayushjain\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		
		}
		else if (browserName.equalsIgnoreCase("firebox")) {
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();

		page = new LandingPage(driver);
		page.goTo();
		return page;

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	} 
}

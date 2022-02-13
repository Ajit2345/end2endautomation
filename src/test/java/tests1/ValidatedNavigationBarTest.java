package tests1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjectsPack.HomePage;
import utilities.Base;

public class ValidatedNavigationBarTest extends Base{
	public static Logger log=LogManager.getLogger(tests1.ValidatedNavigationBarTest.class.getName());
public WebDriver driver;
	@BeforeTest
	public void browserInitialized() throws IOException {
		driver = driverInit();
		driver.get(getURL());
		
	}
	
	@Test
	public void validatedNavigationBar() throws IOException {		
		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.getNavigationBar().isDisplayed());
		log.info("validatedNavigationBar method");
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

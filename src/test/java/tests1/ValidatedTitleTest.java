package tests1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectsPack.HomePage;
import utilities.Base;

public class ValidatedTitleTest extends Base{
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(ValidatedTitleTest.class);
		// TODO Auto-generated method stub

	
	
	@BeforeTest
	public void browserInitialized() throws IOException {
		driver = driverInit();
		driver.get(getURL());
		
	}
	
	@Test
	public void validatedHomePageTitle() throws IOException {		
		HomePage hp=new HomePage(driver);
		Assert.assertEquals(hp.getTitle().getText(), "FEATURED COURSES234");
		log.error("doesnt match error");
//		log.error("title error occered");
		
		
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

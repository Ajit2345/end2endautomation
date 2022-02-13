package tests1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectsPack.ForgetPasswordPage;
import pageObjectsPack.HomePage;
import pageObjectsPack.LoginPage;
import utilities.Base;

public class HomePageTest extends Base {

	WebDriver driver;
	public static Logger log = LogManager.getLogger(tests1.HomePageTest.class.getName());

	@BeforeTest
	public void browserInitialized() throws IOException {
		driver = driverInit();

	}

	@DataProvider(name = "data-provider1")
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		// row 1
		data[0][0] = "userName1";
		data[0][1] = "password1";
		data[0][2] = "resticted";
		// row 2
		data[1][0] = "userName2";
		data[1][1] = "password2";
		data[1][2] = "non-resticted";

		return data;
	}

	@Test(dataProvider = "data-provider1")
	public void basePageNavigation(String userName, String passWord, String userType) {
		driver.get(prop.getProperty("url"));

		HomePage hp = new HomePage(driver);
		log.info("home page object initiated");
		LoginPage lp = hp.getSignin();
		log.debug("login page object initiated");
		lp.getUserName().sendKeys(userName);
//		log.info("user name entered");
		lp.getPassword().sendKeys(passWord);

		lp.getGo().click();
//		log.info("click on go button");
//		String errorMsg=lp.loginErrorMsg();
//		log.info(userType);

		ForgetPasswordPage fp = lp.forgetPassword();
		fp.getEmailBox().sendKeys("abbas0304@gmail.com");
		fp.getSubmittButton().click();
//		
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(lp.loginErrorMsg().getText(), "Invalid email or password.");

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

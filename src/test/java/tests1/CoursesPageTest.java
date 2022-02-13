package tests1;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjectsPack.CoursesPage;
import pageObjectsPack.GoogleAddPage;
import pageObjectsPack.HomePage;
import pageObjectsPack.RahulshettyacademyHomePage;
import utilities.Base;

public class CoursesPageTest extends Base{
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(tests1.CoursesPageTest.class);
	
	@BeforeTest
	public void getBrowser() throws IOException {
		
		driver=driverInit();
		log.info("driver intiate");
	}
	
	@Test
	public void getCourse() throws InterruptedException  {
		//http://qaclickacademy.com/
		driver.get("http://qaclickacademy.com/");
		HomePage hp=new HomePage(driver);
		RahulshettyacademyHomePage rshp=hp.getCourses();
//		String courseName=rshp.getMyCourse().getText();
//		Thread.sleep(5000);
		CoursesPage cp=rshp.getAllCourse();
//		Thread.sleep(5000);
//		CoursesPage cp=gap.getCoursePage();
		String courseName1=cp.getCourse().getText();
		log.info("actual "+courseName1);
		log.info("expected "+"REST API Testing(Automation) from scratch-Rest Assured java");
		
		Assert.assertEquals(courseName1, "REST API Testing(Automation) from scratch-Rest Assured java");
		
	}
	
	@AfterTest
	public void browserClose() {
		driver.quit();
	}
	
	
	

}

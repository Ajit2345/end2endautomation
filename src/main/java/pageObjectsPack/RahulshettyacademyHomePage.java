package pageObjectsPack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RahulshettyacademyHomePage {
	WebDriver driver;
	private static Logger log=LogManager.getLogger(RahulshettyacademyHomePage.class.getName());
	public RahulshettyacademyHomePage(WebDriver driver) {
		this.driver=driver;		
	}
	private By allCourseButton=By.xpath("//ul[@class='navigation clearfix']/li[2]");
	private By myCourse=By.xpath("//a[contains(text(),'REST API Testing(Automation) from scratch-Rest Ass')]");
	private By alertButton=By.id("dismiss-button");
	//ul[@class='navigation clearfix']/li[2]
	
	//a[contains(text(),'REST API Testing(Automation) from scratch-Rest Ass')]
	
	
	public CoursesPage getAllCourse() throws InterruptedException {
//		Thread.sleep(5000);
		 driver.findElement(allCourseButton).click();
		 log.info(driver.getCurrentUrl());
//		 WebElement elt = driver.findElement(alertButton);
//		 if(elt.isDisplayed()) {
//		 driver.findElement(alertButton).click();
//		 }
//		 Alert alert=driver.switchTo().alert();
//		 alert.dismiss();
//		 log.info(driver.getCurrentUrl());
		 return new CoursesPage(driver);
	}
	
	public WebElement getMyCourse()  {
		 return driver.findElement(myCourse);
		 
	}
	
	
	
	
	
}

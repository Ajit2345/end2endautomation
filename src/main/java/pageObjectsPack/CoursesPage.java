package pageObjectsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPage {
	WebDriver driver;
	public CoursesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By myCourse=By.cssSelector("div[title='REST API Testing(Automation) from scratch-Rest Assured java']");
	
	public WebElement getCourse() {
		return driver.findElement(myCourse);
	}

}

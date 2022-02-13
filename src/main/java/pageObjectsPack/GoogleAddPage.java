package pageObjectsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleAddPage {
	WebDriver driver;
	private By addButtonCancel=By.id("dismiss-button");
	public GoogleAddPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public CoursesPage getCoursePage() {
		driver.findElement(addButtonCancel).click();
		return new CoursesPage(driver);
		
	}

}

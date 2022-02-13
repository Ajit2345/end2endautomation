package pageObjectsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPasswordPage {
	WebDriver driver;
	private By email=By.xpath("//input[@id='user_email']");
	private By submitt=By.cssSelector("input[value='Send Me Instruction']");
	public ForgetPasswordPage( WebDriver driver) {
		this.driver=driver;		
	}
	
	public WebElement getEmailBox() {
		return driver.findElement(email);
	}
	public WebElement getSubmittButton() {
		return driver.findElement(submitt);
	}
	

}

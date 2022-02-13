package pageObjectsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	private By userName=By.id("user_email");
	private By password=By.id("user_password");
	private By go=By.cssSelector("input[value='Log In']");
	private By errorMsg=By.cssSelector("div[role='alert']");
	private By forgetPassword=By.xpath("//a[@class='link-below-button']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getGo() {
		return driver.findElement(go);
	}
	public WebElement loginErrorMsg() {
		return driver.findElement(errorMsg);
	}
	public ForgetPasswordPage forgetPassword() {
		driver.findElement(forgetPassword).click();
		return new ForgetPasswordPage(driver);
	}
	

}

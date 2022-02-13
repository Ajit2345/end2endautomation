package pageObjectsPack;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	private By signin=By.xpath("//span[normalize-space()='Login']");
	private By title=By.cssSelector("div[class='text-center'] h2");
	private By navigationBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By courseLink=By.xpath("//a[text()='Courses']");
	//a[normalize-space()='Courses']
	//body > header:nth-child(2) > div:nth-child(2) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)
	
//	div[class='text-center'] h2
	//ul[@class='nav navbar-nav navbar-right']
	//span[normalize-space()='Login']
	//body > header:nth-child(2) > div:nth-child(2) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1) > span:nth-child(2)
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public LoginPage getSignin() {
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
	public RahulshettyacademyHomePage getCourses() {
		driver.findElement(courseLink).click();
		return new RahulshettyacademyHomePage(driver);
	}
	
	
    
	

}

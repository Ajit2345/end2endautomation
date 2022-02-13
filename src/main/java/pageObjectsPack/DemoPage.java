package pageObjectsPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoPage {
	public static WebDriver driver;
	static List<WebElement> list;
	

	public static void main(String[] args) {
		String path= System.getProperty("user.dir");
		System.out.println(path);
		String fullPath= path+"//drivers//chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", fullPath );
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    int listSizelist=driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
	    int count=2, total=0; 
	    
	    for(int i=1;i<listSizelist ;i++) {
	    	System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child("+count+") td:nth-child(3)")).getText());
	    	String str=driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child("+count+") td:nth-child(3)")).getText();
	    	total=total+Integer.parseInt(str);	    	
	    	count++;
	    }
	    System.out.println("total: "+total);
	    driver.quit();
	    
	    
	    

	}

}

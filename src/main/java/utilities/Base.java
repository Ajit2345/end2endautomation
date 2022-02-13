package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(utilities.Base.class.getName());

	public WebDriver driverInit() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(".//src//test//resources//data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log.info("driver intiate");
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", ".//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.chrome.driver", ".//drivers//msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		return driver;

	}

	public String takeScreenShot(String testName, WebDriver driver) throws Exception {
		String path = System.getProperty("user.dir") + "\\reports\\" + testName + ".png";
		System.out.println(path);
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
		return path;
	}

	public String getURL() {
		String str = prop.getProperty("url");
		return str;
	}

}

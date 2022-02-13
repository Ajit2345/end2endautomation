package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport1 {
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test result");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ajit Das");
		return extent;
		
	}

}

package utilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends Base implements ITestListener{
	
	ExtentReports extent=ExtentReport1.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> testReoprtThread= new ThreadLocal<ExtentTest>(); 

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		testReoprtThread.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		testReoprtThread.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {		
		// TODO Auto-generated method stub
		testReoprtThread.get().fail(result.getThrowable());
		WebDriver driver =null;
		String methodName=result.getMethod().getMethodName();
		
		
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			testReoprtThread.get().addScreenCaptureFromPath(takeScreenShot(methodName,driver), result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	
	

}

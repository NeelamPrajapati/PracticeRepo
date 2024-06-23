package TestUtils;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportsUtil;

public class Listeners  extends BaseTest implements ITestListener{
    ExtentTest test;
	ExtentReports extent = ExtentReportsUtil.getReportObject();
	WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed");
		String path= null;
		try
		{
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		path= takeScreenShot(result.getMethod().getMethodName(),driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

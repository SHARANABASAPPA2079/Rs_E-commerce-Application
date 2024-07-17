package EcommerceApplication.TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import EcommerceApplication.Resources.ExtentReporterNG;



public class Listeners extends BaseTest implements ITestListener

{

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
    
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result)

	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// It will assign one unique thread id->test
	}

	@Override
	public void onTestSuccess(ITestResult result)

	{
		// test.log(Status.PASS, "Test Passed");
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)

	{
		// test.log(Status.FAIL, "Test Failed");
		extentTest.get().log(Status.FAIL, "Test Failed");
		// test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());
		try

		{
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}

		catch (Exception e)

		{

			e.printStackTrace();
		}

		String filePath = null;
		try

		{
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		}

		catch (Exception e)

		{

			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result)

	{
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)

	{
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)

	{
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context)

	{
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context)

	{
		extent.flush();
		
/*		try
		
		{
			Desktop.getDesktop().browse(new File(ExtentReporterNG.getReportObject().).toURI());
		}
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
		}
*/		
	}

	@Override
	public int hashCode()

	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)

	{
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException

	{
		return super.clone();
	}

	@Override
	public String toString()

	{
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable

	{
		super.finalize();
	}

}

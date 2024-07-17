package EcommerceApplication.Resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG

{
	public static ExtentReports getReportObject()

	{
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		String timeInFormat = formater.format(Calendar.getInstance().getTime());

		// ExtentReports,ExtentsparkReporter
		//String path = System.getProperty("user.dir") + "\\reports\\+ timeInFormat + ".html";
		String reportLoc = System.getProperty("user.dir") + "\\Test-Output\\MyownReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportLoc);
		// ExtentSparkReporter class expect path where our report should be created
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sharan Padashetty");
		extent.setSystemInfo("Host Name", "Local-Host");
		return extent;

	}
	
	
}

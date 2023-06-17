package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTestClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String report;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp= new SimpleDateFormat("dd-M-yyyy hh-mm-ss").format(new Date());
		report="Test-Report -"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\ExtentReport\\"+report);
		sparkReporter.config().setDocumentTitle("opencart Automation Report");
		sparkReporter.config().setReportName("opencart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Environemnt", "QA");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"This test is passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"This test is failed");
		test.log(Status.FAIL,result.getThrowable());
		
		try {
			String screenshotPath = new BaseTestClass().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"This test is skipped");
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	
	
}

package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
		
	public void onStart(ITestContext context)
	{
		//SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		//Date dt = new Date();
		//String currentDttm =  df.format(dt); 
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReports.html");		
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);		
		
		extent =  new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Jayu Dhengle");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome, Firefox, Edge");
		
	}

	public void onTestSuccess(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is :" +result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is :" +result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is :" +result.getThrowable());
		
		//BaseTest cs = new BaseTest();
		//cs.captureScreenshots(result.getName());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is :" +result.getName());
	}
	
	public void onFinish(ITestContext result)
	{
		extent.flush();
	}	
}

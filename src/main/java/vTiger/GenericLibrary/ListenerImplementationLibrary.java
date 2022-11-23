package vTiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class will provide implementation to all the abstract methods in ITestListener
 * @author KRISHNA KANTH
 *
 */
public class ListenerImplementationLibrary implements ITestListener 
{
    
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)       //run for every test script
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log("Test execution started -> "+MethodName, true);
		
		 test = report.createTest(MethodName);  // test script execution is started in report
		 test.log(Status.INFO, "Test execution started");
		
	}

	public void onTestSuccess(ITestResult result)       // pass
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log("Test is SuccessFull->  "+MethodName, true);
		test.log(Status.PASS, MethodName+" -> pass");
		
	}

	public void onTestFailure(ITestResult result)       //fail
	{
		
		WebDriverLibrary wLib = new WebDriverLibrary();
		JavaLibrary jLib = new JavaLibrary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//Reporter.log("Test is Failed-> "+MethodName, true);
		test.log(Status.FAIL, "failed");
		
		try {
			wLib.takeScreenShot(BaseClass.sDriver, MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)       //skipped
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log("Test is skipped-> "+MethodName, true);
		test.log(Status.SKIP, MethodName+" -> skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
		Reporter.log("Execution of suite started", true);
		//Execution of suite starts here , hence configure the extent reports here.  Report-11-11-2022-10-50.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaLibrary().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution Reports for vTiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vTiger Execution Reports");
		
		//attach the report to extent reports
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser","Chrome");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter name", "Krishna Kanth");
		
	}

	public void onFinish(ITestContext context) 
	{
		Reporter.log("Execution of suite finished",true);	
		
		//Flush the report  - Here the execution is finished.
		report.flush();
		
	}
	
      
	
}

package utilities;

import java.awt.Desktop;
import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class Extendreports implements ITestListener
{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repname;
	
	public void onStart(ITestContext context)
	{
		
		//Creating Timestamp
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname= "Test-report" + timestamp + ".html";  // Format of report name
		//ExtentSparkReporter is used to configure the UI of report
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\" + repname);
		sparkReporter.config().setDocumentTitle("AutoReport");
		sparkReporter.config().setReportName("Functional");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		//ExtentReports is used to set the values and details inside the report
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);  
		extent.setSystemInfo("Project Name", "Test Project");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", System.getProperty("user.name"));
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String>groups = context.getCurrentXmlTest().getIncludedGroups();
		if(!groups.isEmpty())
		{
			extent.setSystemInfo("Groups", groups.toString());
		}
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
		test = extent.createTest(result.getTestClass().getName()); // result.getName() is used to get the METHOD name of the corresponding test
		test.assignCategory(result.getMethod().getGroups());  // From the result, Methods are taken and from Methods respective Groups are taken and displayed in report
		test.log(Status.PASS, result.getName()); // creates log for report. Test status and message with METHOD name will be incorporated in log
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test failed"+ result.getName());
		test.log(Status.INFO,result.getThrowable().getMessage()); // result.getThrowable() will return the reason for failed tests.
		
		//ScreenShots code only if a Test is falied
		try
		{
		String imgpath =new BaseClass().capturescreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test skipped"+ result.getName());
		test.log(Status.INFO,result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
		String pathofententreport = System.getProperty("user.dir")+"\\reports\\"+ repname;
		File extentreport=new File (pathofententreport);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

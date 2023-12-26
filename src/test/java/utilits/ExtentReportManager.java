package utilits;



//Extent report 5.x
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
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportManager implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public ExtentTest test;

    static {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        String repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\Reports\\" + repName);// specify the location of the report

        

        sparkReporter.config().setDocumentTitle("SwagbLabs Project"); // Title of the report
        sparkReporter.config().setReportName("Test Automation "); // Name of the report
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.viewConfigurer()
        .viewOrder()
        .as(new ViewName[] { 
        		   ViewName.DASHBOARD, 
        		   ViewName.TEST, 
        	//	   ViewName.TAG, 
        		   ViewName.AUTHOR, 
        		   ViewName.DEVICE, 
        		   ViewName.EXCEPTION, 
        		   ViewName.LOG 
        		})
        	  .apply();

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Swaglabs Clothes Store");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt", "Test Enviroment");
        extent.setSystemInfo("user", "Hussam Abd EL Fattah");
        extent.setSystemInfo("BrowserName", "FireFox");
        
    }


	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		test.assignAuthor("Lecster");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName()); 
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		test.assignAuthor("Lecster");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); 
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		test.assignAuthor("Lecster");
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}

package SeleniumFrameWork.MavenProject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest3 {
 
	 private WebDriver driver;
	
	ExtentSparkReporter htmlReport;
	ExtentReports extent;
	ExtentTest tests;
	
	@BeforeTest
	public void extentsetup() {

		System.out.println("BeforeTest");
		htmlReport =new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"AutomationPracticeResults.html");
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Automation Practice");
		htmlReport.config().setReportName("Automation Practice Test Reports");
		htmlReport.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Automation Tester Name", "Masood Ahmed");
	}
	
    @BeforeMethod
	public void SetupApp() {

    	
		System.out.println("Setup App");
	
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
//		WebDriver driver2=driver;
//		return driver2;s
		
	}
    
    public WebDriver getDriver() {
    	return driver;
    }
    
    
	
	@BeforeMethod
	public void setupTestResults(ITestResult result) {
		
		tests=extent.createTest(result.getMethod().getMethodName());
	}
	
	@AfterMethod
	public void quitAppResults(ITestResult result) {
		
		System.out.println("AfterMethod");
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case Name:"+methodName+" Passed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			tests.log(Status.PASS, m);
		}
		else
		{
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case Name:"+methodName+" Failed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			tests.log(Status.FAIL, m);
		}
		
		
		
	}

	public void quitApp(WebDriver driver)
	{
	
		
		driver.quit();
	}
	
	@AfterTest
	public void clearExtentReport() {
		
		System.out.println("AfterTest");
		
		extent.flush();
	}
}

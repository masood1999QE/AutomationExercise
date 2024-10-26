package SeleniumFrameWork.MavenProject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest2 {

	WebDriver driver;

	public WebDriver SetupApp() {

		System.out.println("Setup App");
		driver =new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
		return driver;
	}
	
	
	@AfterMethod
	public void quitApp() {
				
		driver.quit();
	}
	
}

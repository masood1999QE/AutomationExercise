package SeleniumFrameWork.MavenProject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseTest3 implements ITestListener{
	
	  WebDriver driver2;

	 
	  
	 public void onTestFailure(ITestResult result) {
		 
		 System.out.println("On Failure"); 
		 try {
			
			 driver2=getDriver();
			 
			 File screenshot = ((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
			 File destination=new File(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"screenshot.png");
			 FileHandler.copy(screenshot, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		 System.out.println("On Success");
		 
//	
//		 	try {
//			
//		 		driver2=getDriver();
//		 		System.out.println("try in :"+driver2);
//				 File screenshot = ((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
//				 File destination=new File(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"screenshot.png");
//				 FileHandler.copy(screenshot, destination);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		 
		  }
	
	 public void onStart(ITestContext context) {

		  }
}

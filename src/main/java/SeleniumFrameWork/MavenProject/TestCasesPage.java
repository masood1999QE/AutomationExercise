package SeleniumFrameWork.MavenProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWork.Utilities.Commons;

/**
 * Hello world!
 */
public class TestCasesPage extends Commons{
	WebDriver driver;
	public TestCasesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
    

    public  String verifyTestCasesPage() {
    	return driver.getTitle();
    }
    
    
}

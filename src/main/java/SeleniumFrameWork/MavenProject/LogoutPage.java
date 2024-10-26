package SeleniumFrameWork.MavenProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWork.Utilities.Commons;

/**
 * Hello world!
 */
public class LogoutPage extends Commons{
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
    public  String verifyLogoutPage() {
    	return driver.getTitle();
    }
    

    public void navigateToLoginPage()
    {
    	
    	driver.get("https://automationexercise.com/login");
    }

}

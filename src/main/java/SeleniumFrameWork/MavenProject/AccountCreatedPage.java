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
public class AccountCreatedPage extends Commons{
	WebDriver driver;
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//b[contains(text(),'Account Created')]")
	WebElement accntCreatedMessage;
    
	@FindBy(css="a[data-qa='continue-button']")
	WebElement continueBtn;
	
	public String verifyAccntCreatedMessag()
	{
		return accntCreatedMessage.getText();
	}
	
	public void clickContinue() {
		 ClickBtn(continueBtn);
	}
	
}

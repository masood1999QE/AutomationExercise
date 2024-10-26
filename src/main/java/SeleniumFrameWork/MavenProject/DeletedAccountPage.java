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
public class DeletedAccountPage extends Commons{
	WebDriver driver;
	public DeletedAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="h2[data-qa='account-deleted']")
	WebElement accntDeletedMsg;
    
	@FindBy(css="a[data-qa='continue-button']")
	WebElement continueBtn;
	
	public String verifyAccntDeletedMsg()
	{
		return accntDeletedMsg.getText();
	}
	
	public void clickContinue() {
		 ClickBtn(continueBtn);
	}
	
}

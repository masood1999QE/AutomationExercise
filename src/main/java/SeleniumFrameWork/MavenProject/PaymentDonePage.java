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
public class PaymentDonePage extends Commons{
	WebDriver driver;
	public PaymentDonePage(WebDriver driver) {
		super(driver);
		synchronizedMethod(driver); 
		
	}
	
	public synchronized void synchronizedMethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Landing Driver Initialized");
	}
	
    
    @FindBy(xpath="//a[text()='Continue']")
    WebElement continueBtn;
    
    @FindBy(css="p[style*='garamond']")
    WebElement orderConfirmationMessageSuccess;
    
  public void clickContinueBtn() {
	  
	  ClickBtn(continueBtn);
  }
  
  public String verifyOrderConfirmationMessage() {
		 
		 return orderConfirmationMessageSuccess.getText();
	 }
}

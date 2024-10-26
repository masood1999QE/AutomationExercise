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
public class ContactUsPage extends Commons{
	WebDriver driver;
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(css="input[data-qa='name']")
    WebElement inputName;
    
    @FindBy(css="input[data-qa='email']")
    WebElement inputEmail;
    
    @FindBy(css="input[data-qa='subject']")
    WebElement inputSubject;
    
    @FindBy(id="message")
    WebElement inputMessage;
    
    @FindBy(css="input[name='upload_file']")
    WebElement uploadFile;
    
    @FindBy(css="input[data-qa='submit-button']")
    WebElement submitBtn;
    
    @FindBy(css="div[class='contact-form'] h2[class*='text-center']")
    WebElement contactPageText;
    
    @FindBy(css="div[class*='status alert alert-success']")
    WebElement successMessage;
    
    @FindBy(css="a[href='/'][class*='btn-success']")
    WebElement homeBtn;
    
    public void typeInputName(String inputName)
    {
    	this.inputName.sendKeys(inputName);
    }
    
    public void typeInputEmail(String inputEmail)
    {
    	this.inputEmail.sendKeys(inputEmail);
    }
    
    public void typeInputMessage(String inputMessage)
    {
    	this.inputMessage.sendKeys(inputMessage);
    }
    
    public void typeInputSubject(String inputSubject)
    {
    	this.inputSubject.sendKeys(inputSubject);
    }
    
    public void uploadFile(String uploadFilePath)
    {
    	this.uploadFile.sendKeys(uploadFilePath);
    } 
    
    public void handleAlert(String command) {
    	if(command.equals("Ok"))
    		this.driver.switchTo().alert().accept();
    	else
    		this.driver.switchTo().alert().dismiss();
    }
    
    public String verifyContactPageText() {
    	return contactPageText.getText();
    }
    
    
    public void clickSubmitsBtn() {
    	ClickBtn(submitBtn);
    }
    
    public String verifySuccessMessage() {
    	return successMessage.getText();
    }
    
    public void clickHomeBtn() {
    	ClickBtn(homeBtn);
    }
}

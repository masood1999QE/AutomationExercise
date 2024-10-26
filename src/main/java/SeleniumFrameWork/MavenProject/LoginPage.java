package SeleniumFrameWork.MavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWork.Utilities.Commons;

public class LoginPage extends Commons{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//h2[contains(text(),'New')]")
	WebElement SignUpText;
	
	@FindBy(xpath="//h2[contains(text(),'Login to your account')]")
	WebElement loginText;
	
	@FindBy(css="input[data-qa='login-email']")
	WebElement loginEmailId;
	
	@FindBy(css="input[data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy(css="button[data-qa='login-button']")
	WebElement loginBtn;
	
	
	@FindBy(css="input[data-qa='signup-name']")
	WebElement signUpName;
	
	@FindBy(css="input[data-qa='signup-email']")
	WebElement signUpEmailId;
	
	@FindBy(css="button[data-qa='signup-button']")
	WebElement signUpBtn;

	@FindBy(css="p[style*='red']")
	WebElement FailedMessage;
	
	public String verifyFailedText() {
		return FailedMessage.getText();
	}
	
	public String verifyLoginText() {
		return loginText.getText();
	}
	
	public void enterLoginEmailId(String emailId) {
		enterInputInTextBox(loginEmailId,emailId);
	}
	
	public void enterLoginPassword(String password) {
		enterInputInTextBox(loginPassword,password);
	}
	
	public void clickLoginBtn() {
		ClickBtn(loginBtn);
	}
	
	public String verifySignUpText() {
		return SignUpText.getText();
	}
	
	public void enterSignUpName(String name) {
		enterInputInTextBox(signUpName,name);
	}
	
	public void enterSignUpEmailId(String emailId) {
		enterInputInTextBox(signUpEmailId,emailId);
	}
	
	public void clickSignUpBtn() {
		ClickBtn(signUpBtn);
	}
}

package SeleniumFrameWork.MavenProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameWork.Utilities.Commons;

/**
 * Hello world!
 */
public class PaymentPage extends Commons{
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		synchronizedMethod(driver);
		
	}
	
	public synchronized void synchronizedMethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Landing Driver Initialized");
	}
	
    
    @FindBy(css="input[name='card_number']")
    WebElement cardNumberInput;
    
    @FindBy(css="input[name='name_on_card']")
    WebElement nameOnCardInput;
    
    @FindBy(css="input[name='cvc']")
    WebElement cardCVCInput;
    
    @FindBy(css="input[name='expiry_month']")
    WebElement cardExpiryMonthInput;
    
    @FindBy(css="input[name='expiry_year']")
    WebElement cardExpiryYearInput;
    
    @FindBy(xpath="//button[text()='Pay and Confirm Order']")
    WebElement 	PayConfirmOrderBtn;
  
    @FindBy(xpath="//div[@class='alert-success alert']")
    WebElement odderSuccessMessage;
    
  public void typeCardNumber(String cardNumber) {
	  
	  
	  enterInputInTextBox(cardNumberInput,cardNumber);
	  
  }
  
  public void typeCardHolderName(String cardName) {
	  
	  
	  enterInputInTextBox(nameOnCardInput,cardName);
	  
  }
  
 public void typeCardCVC(String cardCVC) {
	  
	  enterInputInTextBox(cardCVCInput,cardCVC);
	  
  }
  
 public void typeCardExpiryMonth(String cardExpiryMonth) {
	  
	  enterInputInTextBox(cardExpiryMonthInput,cardExpiryMonth);
	  
 }
 
 public void typeCardExpiryYear(String CardExpiryYear) {
	  
	  enterInputInTextBox(cardExpiryYearInput,CardExpiryYear);
	  Actions act=new Actions(driver);
	  act.scrollByAmount(0, 150)
	  .build().perform();
	 
	  
}
 
 public String clickPayAndConfirmOrderMessage() {
	 
	 //I wrote the below script after spending more than 5 hours, so please don't give up and keep on learning!
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 String return_value=(String) js.executeScript("arguments[0].click();return document.getElementById('success_message').innerText", PayConfirmOrderBtn);
	 System.out.println("return value:"+return_value);

	 return return_value;
 }
  

}

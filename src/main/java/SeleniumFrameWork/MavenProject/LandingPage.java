package SeleniumFrameWork.MavenProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameWork.Utilities.Commons;

/**
 * Hello world!
 */
public class LandingPage extends  Commons{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		synchronizedMethod(driver);
		
		
	}
	
	public synchronized void synchronizedMethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Landing Driver Initialized");
	}
	
    @FindBy(id="j_idt88:name")
    WebElement input;
    
    @FindBy(css="ul[class*='navbar-nav'] a[href*='login']")
    WebElement SignUpOrLoginBtn;
    
    @FindBy(css="a[href*='contact']")
    WebElement contactBtn;
    
    @FindBy(css="a[href='/test_cases']")
    WebElement testCasesBtn;
    
    @FindBy(css="a[href='/products']")
    WebElement productsBtn;
    
    @FindBy(css="footer h2")
    WebElement subscriptionText;
    
    @FindBy(id="susbscribe_email")
    WebElement subscribedEmailId;
    
    @FindBy(id="subscribe")
    WebElement subscribeBtn;
    
    @FindBy(css="div[class*='alert-success']")
    WebElement subscribeSuccessAlertMessage;
    
    @FindBy(css="li a[href*='/view_cart']")
    WebElement cartIcon;
    
    @FindBy(css="li a[href*='/products']")
    WebElement productsIcon;
    
    @FindBy(css="a[href='/product_details/1']")
	WebElement firstProductBtn;
    
	@FindBy(css="div[class='features_items'] div[class*='col'] div[class*='text-center'] p")
	List<WebElement> productsList;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement continueShoppingbtnModal;
	
	@FindBy(css="a[href*='top']")
	WebElement scrollUpBtn;
	
	@FindBy(xpath="//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
	WebElement landingPageMainCarouselText;
    
    public void typeInput(String inputs)
    {
    	input.sendKeys(inputs);
    }
    
    public synchronized  String verifyHomePage() {
    	return driver.getTitle();
    }
    
    public synchronized  String verifySubscriptionText() {
    	return subscriptionText.getText();
    }
    
  
    public synchronized  void clickSignUpOrLoginBtn() {
    	System.out.println("Thread ID:"+ Thread.currentThread().getId());
    	ClickBtn(SignUpOrLoginBtn);
    }
    
    public synchronized  void clickContactBtn() {
    	ClickBtn(contactBtn);
    }
    
    public synchronized  void clickTestCasesBtn() {
    	
    	ClickBtn(testCasesBtn);
    }
    
    public synchronized  void clickProductsBtn() {
    	
    	ClickBtn(productsBtn);
    }
    
    public synchronized  void typeSubscriberEmailId(String emailId) {
    	
    	 enterInputInTextBox(subscribedEmailId,emailId);
    }
    
    public synchronized  void clickSubscribeBtn() {
    	ClickBtn(subscribeBtn);
    }
    
    public synchronized  String verifySuccessMessage() {
    	 return subscribeSuccessAlertMessage.getText();
    }
    
    public void clickCartButton() {
    	ClickBtn(cartIcon);
    }
    
    public void clickProductsIconButton() {
    	ClickBtn(productsIcon);
    }
    
    public void viewFirstProduct() {
    	ClickBtn( firstProductBtn);
    }
    
    public void addToCartProduct(String productName) {
 	   
 	   for(WebElement ele:productsList)
 	   {
 		   if(ele.getText().equals(productName))
 		   {
 			   System.out.println("Product Found");
 			   
 			   System.out.println("Ele tag"+ ele.getTagName());
 			   
 		    	WebElement AddCartElement= ele.findElement(By.xpath(".//parent::div/following-sibling::div //a"));
 		    	System.out.println(AddCartElement.getTagName()); 
 		    	System.out.println("Attribute:"+AddCartElement.getAttribute("class"));
 		    	
 		    	Actions act=new Actions(driver);
// 		    	act.scrollByAmount(0, 800);
 		    	act.moveToElement(ele).scrollByAmount(0, 50)
 		    	.build().perform();
 		    		
 		    	waitForElementToBeClickable(AddCartElement);
 		    	AddCartElement.click();
 		    	break;
 		   }
 	   }
    }
    
    public void clickContinueShopping() {
    	waitForElementToBeClickable(continueShoppingbtnModal);
    	ClickBtn(continueShoppingbtnModal);
    	
    	
    }
    
    public void scrollToSubscriptionText() {
    	
    	Actions act=new Actions(driver);
    	act.scrollToElement(subscriptionText).build().perform();
    }
    
    public void scrollToMiddleCarouselText() {
    	Actions act=new Actions(driver);
    	act.scrollToElement(landingPageMainCarouselText).build().perform();
    	
    }
    
    public void  clickOnScrollUpBtn() {
    	ClickBtn(scrollUpBtn);
    }
    
    public String verifyMiddleCarouselText() {
    	
    	return  landingPageMainCarouselText.getText();
    }
    
}

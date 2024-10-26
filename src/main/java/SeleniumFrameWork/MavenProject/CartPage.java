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
public class CartPage extends Commons{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		synchronizedMethod(driver);
		
	}
	
	public synchronized void synchronizedMethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Landing Driver Initialized");
	}
	
    
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
    
    @FindBy(xpath="//table/tbody/tr")
	List<WebElement> getAddedProductsCount;
	
	@FindBy(xpath="//table/tbody/tr/td")
	List<WebElement> getAddedProductsDetailsList;
	
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	WebElement checkOutIcon;
	
	@FindBy(xpath="//u[contains(text(),'Register / Login')]")
	WebElement registerOrLoginBtn;
    
    public synchronized  String verifyHomePage() {
    	return driver.getTitle();
    }
    
    public synchronized  String verifySubscriptionText() {
    	return subscriptionText.getText();
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
    
    public int getAddedProductCount() {
    	
   	 return getAddedProductsCount.size();
   }
   
   public void getAddedProductDetails() {
   	
	   for (WebElement ele:getAddedProductsDetailsList)
	   {
	   	
		   	if(ele.getAttribute("class").contains("cart_description"))
		   	{
		   		System.out.println(ele.getText());
		   	}
		   	else if(ele.getAttribute("class").contains("cart_price"))
		   	{
		   		System.out.println(ele.getText());
		   	}
		   	else if(ele.getAttribute("class").contains("cart_quantity"))
		   	{
		   		System.out.println(ele.getText());
		   	}
		   	else if(ele.getAttribute("class").contains("cart_total"))
		   	{
		   		System.out.println(ele.getText());
		   	}
	   	
	   	}
	  	
  }
   
   public boolean checkProductDetails(String productName) {
	   	
	   String productDetails=""; 
	   boolean checkProduct=false;
	   System.out.println("Before checkProduct:"+ checkProduct);
	   boolean waitCheck= waitForElementToDisappear(getAddedProductsDetailsList.get(0));
	   for (WebElement ele:getAddedProductsDetailsList)
	   {		 
		   if(!waitCheck)
		   {
			   System.out.println("Element is displayed");
			   
			   if(ele.getAttribute("class").contains("cart_description"))
			   	{
			   		System.out.println(ele.getText());
			   		productDetails=ele.getText();
			   	}
			   	
			   	if((!productDetails.isEmpty()) && (productDetails.contains(productName)))
			   	{
			   		System.out.println("element Found");
			   		checkProduct=true;
			   	}
		   }	
	   	
	   	}
	   
	   System.out.println("After checkProduct:"+ checkProduct);
	
	  	return checkProduct;
  }
   
   public void deleteAddedProductDetails(String productName) {
	   String productDetails=""; 
	   for (WebElement ele:getAddedProductsDetailsList)
	   {
		   	if(ele.getAttribute("class").contains("cart_description"))
		   	{
		   		System.out.println(ele.getText());
		   		productDetails=ele.getText();
		   	}
		   	
		   	if((productDetails.contains(productName)) && ele.getAttribute("class").contains("cart_delete"))
		   	{
		   		System.out.println("element got clicked");
		   		ele.findElement(By.xpath(".//a")).click();
		   		//ele.click();
		   	}
	   	
	   	}
	   
   }
   public String getFirstProductQuantity() 
   {
	   String quantity="";
	   for (WebElement ele:getAddedProductsDetailsList)
	   {
		   if(ele.getAttribute("class").contains("cart_quantity"))
		   	{
		   		System.out.println(ele.getText());
		   		quantity=ele.getText();
		   	}
	   }
	   
	   return quantity;
   }
    
   public void clickProceedToCheckout() {
	   
	   ClickBtn(checkOutIcon);
	   
   }
    
  public void clickRegisterOrLoginBtn() {
	  
	  ClickBtn(registerOrLoginBtn);
  }
}

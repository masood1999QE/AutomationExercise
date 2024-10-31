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
public class CheckoutPage extends Commons{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		synchronizedMethod(driver);
		
	}
	
	public synchronized void synchronizedMethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Landing Driver Initialized");
	}
	
    
    @FindBy(xpath="//a[text()='Place Order']")
    WebElement placeOrderBtn;
    
    @FindBy(css="textarea[name='message']")
    WebElement commentBoxTextArea;
    
    @FindBy(css="ul[id='address_delivery'] li")
    List<WebElement> deliveryAddressDetailsList;
    
    @FindBy(css="ul[id='address_invoice'] li")
    List<WebElement> invoiceAddressDetailsList;
    
  public void clickplaceOrderBtn() {
	   
	  ClickBtn(placeOrderBtn);
  }
  
  public void typeComment(String description) {
	  
	  enterInputInTextBox(commentBoxTextArea,description);
	  
  }
  
  public void verifyAddressAndReviewOrderAreSame() {
	  
	  List<String> deliveryAddressDetails=new ArrayList<String>();
	  List<String> invoiceAddressDetails=new ArrayList<String>();
	  
	  for(WebElement ele:deliveryAddressDetailsList)
	  {
		  if(!ele.getAttribute("class").contains("address_title"))
		  {
			  System.out.println(ele.getText());
			  deliveryAddressDetails.add(ele.getText());
		  }
	  }
	  
	  for(WebElement ele:invoiceAddressDetailsList)
	  {
		  if(!ele.getAttribute("class").contains("address_title"))
		  {
			  System.out.println(ele.getText());
			  invoiceAddressDetails.add(ele.getText());
		  }
	  }
	  
	 System.out.println("Compare:"+deliveryAddressDetails.equals(invoiceAddressDetails));
	  
  }
  
  	public List getDeliveryAddress() {
  	
  		 List<String> deliveryAddressDetails=new ArrayList<String>();
  		 for(WebElement ele:deliveryAddressDetailsList)
  		 {
  			 if(!ele.getAttribute("class").contains("address_title"))
  			 {
  				 System.out.println(ele.getText());
  				 deliveryAddressDetails.add(ele.getText());
  			 }
  		 }
  		
  		 return deliveryAddressDetails;
  }
  	
  	public List getBillingAddress() {
  	  	
  		List<String> invoiceAddressDetails=new ArrayList<String>();
  		for(WebElement ele:invoiceAddressDetailsList)
  		{
		  if(!ele.getAttribute("class").contains("address_title"))
		  {
			  System.out.println(ele.getText());
			  invoiceAddressDetails.add(ele.getText());
		  }
  		}
	  
 		 return invoiceAddressDetails;
 }
  
}

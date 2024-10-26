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
public class HomePage extends Commons{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	 
	@FindBy(xpath="//i[contains(@class,'fa-user')]/parent::a")
	WebElement loggedInUserName;
    
	@FindBy(css="a[href*='delete']")
	WebElement deleteBtn;
	
	@FindBy(css="a[href*='logout']")
	WebElement logoutBtn;
	
	@FindBy(css="div[class='features_items'] div[class*='col'] div[class*='text-center'] p")
	List<WebElement> productsList;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement continueShoppingbtnModal;
	
	@FindBy(css="li a[href*='/view_cart']")
	WebElement cartIcon;
	
	@FindBy(xpath="//h2[text()='Category']")
	WebElement CategoryElement;
	
	@FindBy(xpath="//div[@class='panel-heading']//a")
	List<WebElement> CategorySubElements;		
	
	public void logout() {
    	ClickBtn(logoutBtn);
    }
	
	public String verifyUserIdName()
	{
		return loggedInUserName.getText();
	}
	
	public void deleteAccnt() {
		 ClickBtn(deleteBtn);
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
//	 		    	act.scrollByAmount(0, 800);
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
	    
	    public void clickCartButton() {
	    	ClickBtn(cartIcon);
	    }
	    
	    public String verifyCategoryIsVisible() {
	    	return CategoryElement.getText();
	    }
	    
	    public void clickOnCategoryClothes(String categoryName,String clothesName)
	    {
	    	for(WebElement ele:CategorySubElements)
	    	{
	    		System.out.println("Element:"+ele.getAttribute("innerText"));
	    		if(ele.getAttribute("innerText").trim().equalsIgnoreCase(categoryName))
	    		{
	    			System.out.println("Element Found:"+ele.getAttribute("innerText"));
	    			ele.click();
	    			WebElement element= ele.findElement(By.xpath(".//../../following-sibling::div//li/a[contains(text(),'"+clothesName+"')]"));
	    			waitForElementToBeClickable(element);
	    			element.click();
	    			break;
	    		}
	    	}
	    }
	    
	
}

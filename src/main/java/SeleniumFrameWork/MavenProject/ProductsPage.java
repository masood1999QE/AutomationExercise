package SeleniumFrameWork.MavenProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameWork.Utilities.Commons;
import dev.failsafe.internal.util.Assert;

/**
 * Hello world!
 */
public class ProductsPage extends Commons{
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
    
	@FindBy(xpath="//h2[contains(text(),'ALL')]")
	WebElement productsPageText;
	
	@FindBy(css="a[href='/product_details/1']")
	WebElement firstProductBtn;
	
	
	
	
	@FindBy(id="search_product")
	WebElement  productSearchInput;
	
	@FindBy(css="h2[class*='text-center']")
	WebElement productSearchText;
	
	@FindBy(css="div[class*='productinfo'] p")
	List<WebElement> searchProductLists;
	
	@FindBy(id="submit_search")
	WebElement seacrhBtn;
	
	@FindBy(css="img[src='/get_product_picture/1']")
	WebElement firstProductimg;
	
	@FindBy(css="img[src='/get_product_picture/2']")
	WebElement secondProductimg;
	
	@FindBy(css="div[class='overlay-content'] a[data-product-id='1'] i")
	WebElement firstProduct;
	
	@FindBy(css="div[class='overlay-content'] a[data-product-id='2'] i")
	WebElement secondProduct;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	WebElement continueShoppingbtnModal;
	
	@FindBy(xpath="//u[text()='View Cart']")
	WebElement ViewCartBtnModal;
	
	@FindBy(css="div[class='features_items'] div[class*='col'] div[class*='text-center'] p")
	List<WebElement> productsList;
	
	@FindBy(xpath="//h2[contains(text(),'Brands')]")
	WebElement BrandElement;
	
	@FindBy(xpath="//a[text()[contains(.,'Allen Solly Junior')]]/../..")
	List<WebElement> BrandsNameList;
	

	
    public String verifyProductsPage() {
    	return driver.getTitle();
    }
    
    public String getProductPageText() {
    	return productsPageText.getText();
    }
    
    public String getProductSearchText() {
    	return productSearchText.getText();
    }
    
    public void viewFirstProduct() {
    	ClickBtn( firstProductBtn);
    }
    
    public void typeSearchProductName(String productName)
    {
    	enterInputInTextBox(productSearchInput,productName);
    }
    
    public void clickSearchProduct() {
    	ClickBtn( seacrhBtn);
    }
    
    public List<String> getTheSearchedProducstInfo(String productName) {
    	List<String> addSearchProductList=new ArrayList<>();
    	for(WebElement productInfo:searchProductLists) {
    		
    		System.out.println(productInfo.getText());
    		addSearchProductList.add(productInfo.getText());
    	}
    	
    	return addSearchProductList;
    	
    }
    
    public void addFirstProductToCart() {
    
    	Actions act=new Actions(driver);
    	act.scrollByAmount(0, 500);
    	act.moveToElement(firstProductimg).moveToElement(firstProduct).click(firstProduct)
    	.build().perform();
    	
    	firstProduct.click();
    }
    
    public void  addSecondProductToCart()
    {
    	Actions act=new Actions(driver);
    	act.scrollByAmount(0, 500);
    	act.moveToElement(secondProductimg).moveToElement(secondProduct).click(secondProduct)
    	.build().perform();
    	
    	secondProduct.click();
    }
    
    public void clickContinueShopping() {
    	waitForElementToBeClickable(continueShoppingbtnModal);
    	ClickBtn(continueShoppingbtnModal);
    	
    }
    
    public void clickViewCart() {
    	waitForElementToBeClickable(ViewCartBtnModal);
    	ClickBtn(ViewCartBtnModal);
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
		    	act.scrollByAmount(0, 800);
		    	act.moveToElement(ele)
		    	.build().perform();
		    		
		    	waitForElementToBeClickable(AddCartElement);
		    	AddCartElement.click();
		    	break;
		   }
	   }
   }
  
   public String verifyBrandTextIsVisible()
   {
	   return BrandElement.getText();
   }
   
   public void clickOnBrandName(String BrandName)
   {
	   
	   for(WebElement ele:BrandsNameList)
	   {
		   WebElement element=ele.findElement(By.xpath(".//a[text()[contains(.,'"+BrandName+"')]]"));
		   System.out.println("Element Brand:"+element.getText());
		   if(element.getText().trim().contains(BrandName.toUpperCase())) {
			   element.click();
		   }
	   }
   }
   
   
   public void addToCartSearchProducts(String searchProductName) {
	   
	   System.out.println("searchProductName:"+searchProductName);
	   for(WebElement ele:productsList)
	   {
		   System.out.println("Before searchProductName FIND:"+ele.getText());
		   if(ele.getText().toLowerCase().contains(searchProductName.toLowerCase()))
		   {
			   System.out.println("searchProductName  Found:"+ele.getText());
			   
			   System.out.println("Ele tag"+ ele.getTagName());
			   
		    	WebElement AddCartElement= ele.findElement(By.xpath(".//parent::div/following-sibling::div //a"));
		    	System.out.println(AddCartElement.getTagName()); 
		    	System.out.println("Attribute:"+AddCartElement.getAttribute("class"));
		    	
		    	Actions act=new Actions(driver);
		    	//act.scrollByAmount(0, 800);
		    	act.moveToElement(ele).moveToElement(AddCartElement).scrollToElement(AddCartElement)
		    	.build().perform();
		    		
		    	waitForElementToBeClickable(AddCartElement);
		    	AddCartElement.click();
		    	clickContinueShopping();
		    	
		   }
	   }
   }
   
   public void clickOnViewProduct(String productName)
   {
	   for(WebElement ele:productsList)
	   {
		   System.out.println("productName:"+productName+" Found Element is :"+ele.getText());
		   System.out.println("Check:"+ele.getText().trim().toLowerCase().equalsIgnoreCase(productName.toLowerCase().trim()));
		   boolean flag=ele.getText().trim().toLowerCase().equalsIgnoreCase(productName.toLowerCase().trim());
		   if(flag)
		   {
			   System.out.println("Element is Found :"+ele.getText());
			   WebElement element= ele.findElement(By.xpath(".//../../following-sibling::div//*[text()='View Product']"));
			   element.click();
			   break;
		   }		 
	   }
   }

  
}

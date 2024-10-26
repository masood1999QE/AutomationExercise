package SeleniumFrameWork.Utilities;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons {
	WebDriver driver;
	public Commons(WebDriver driver) {
		this.driver=driver;
	}

	public synchronized  void ClickBtn(WebElement btnElement) {
		
		btnElement.click();
		
	}
	
	public void enterInputInTextBox(WebElement inputElement,String value) {
		
		inputElement.sendKeys(value);
		
	}
	
	public  void clickRadioBtn(WebElement radioBtn)
	{
		radioBtn.click();
		
	}
	
	public void selectValueDropDown(WebElement element,String value) {
		Select selectValue=new Select(element);
		selectValue.selectByVisibleText(value);

	}
	
	public void waitForElementToBeClickable(WebElement ele)
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public Boolean waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		boolean flag=false;
		try {
			wait.until(ExpectedConditions.invisibilityOf(ele));
			flag=true;
		}
		catch(Exception e)
		{
			System.out.println("Element is found and not dispappearing!!!");
		}
		return flag;
	}
	
	public void waitForUrl(String url) 
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains(url));
	}
}

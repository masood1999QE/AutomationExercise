package SeleniumFrameWork.MavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SeleniumFrameWork.Utilities.Commons;

public class SignUpPage extends Commons{

	WebDriver driver;
	public SignUpPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[contains(text(),'Enter')]")
	WebElement SignUpInfoText;
	
	@FindBy(css="label[for='id_gender1']")
	WebElement maleGenderTitle;
	
	@FindBy(css="label[for='id_gender2']")
	WebElement femaleGenderTitle;
	
	@FindBy(id="name")
	WebElement userName;
	
	@FindBy(id="email")
	WebElement userEmailId;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="newsletter")
	WebElement newsLetter;
	
	@FindBy(id="optin")
	WebElement specialOffers;
	
	@FindBy(id="first_name")
	WebElement fName;

	@FindBy(id="last_name")
	WebElement lName;
	
	@FindBy(id="company")
	WebElement companyId;

	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;

	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
	
	@FindBy(id="mobile_number")
	WebElement mobileNumber;
	
	
	@FindBy(css="button[data-qa='create-account']")
	WebElement creatAccBtn;
	
	public String verifySignUpText() {
		return SignUpInfoText.getText();
	}
	
	public void clickTitle(String gender) {
		
		if(gender.contains("Mrs"))
		{
			clickRadioBtn(femaleGenderTitle);
		}
		else
		{
			clickRadioBtn(maleGenderTitle);
		}
	}
	
	public String getUserName() {
		System.out.println("String: "+userName.getText());
		System.out.println("Value: "+userName.getAttribute("value"));
		
		return userName.getAttribute("value");
	}
	
	public String getUserEmailId() {
		return userEmailId.getAttribute("value");
	}
	
	public void enterPassword(String pswd) {
		 enterInputInTextBox(userPassword,pswd);
	}
	
	public void selectDOB(String dob) {
		String day=dob.split("-")[0];
		String month=dob.split("-")[1];
		String year=dob.split("-")[2];
	
		selectValueDropDown(days,day);
		selectValueDropDown(months,month);
		selectValueDropDown(years,year);

	}
	
	public void clickSignupLetters() {
//		System.out.println("NewsLetter Value:"+newsLetter.getAttribute("value"));
//		System.out.println("NewsLetter Tag:"+newsLetter.getTagName());
		waitForElementToBeClickable(newsLetter);
		ClickBtn(newsLetter);
	}
	
	public void clickSpecialOffers() {
		waitForElementToBeClickable(specialOffers);
		ClickBtn(specialOffers);
	}
	
	public void enterFName(String fnameValue)
	{
		enterInputInTextBox(fName,fnameValue);
	}
	
	public void enterLName(String lnameValue)
	{
		enterInputInTextBox(lName,lnameValue);
	}
	
	public void enterCompanyName(String companyNameValue)
	{
		enterInputInTextBox(companyId,companyNameValue);
	}
	
	public void enterAddress1(String address1NameValue)
	{
		enterInputInTextBox(address1,address1NameValue);
	}
	public void enterAddress2(String address2NameValue)
	{
		enterInputInTextBox(address2,address2NameValue);
	}
	
	public void selectCountry(String countryName)
	{
		selectValueDropDown(country,countryName);
	}
	
	public void enterState(String stateName)
	{
		enterInputInTextBox(state,stateName);
	}
	
	public void enterCity(String cityName)
	{
		enterInputInTextBox(city,cityName);
	}
	
	public void enterZipCode(String zipCodeName)
	{
		enterInputInTextBox(zipcode,zipCodeName);
	}
	public void enterMobileNumber(String mobileNumberValue)
	{
		enterInputInTextBox(mobileNumber,mobileNumberValue);
	}
	
	public void createAccount()
	{
		 ClickBtn(creatAccBtn);
	}
	
}


package SeleniumFrameWork.MavenProject;



import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest3{

	
	
	
	public void LaunchApp() {
		WebDriver driver=getDriver();
		System.out.println("Launch App");
		driver.get("http://automationexercise.com");
		System.out.println("URL"+ driver.getCurrentUrl());
	}
	
	
    @Test(enabled=false)
    public void testCases_01() {
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickSignUpOrLoginBtn();
    	
    	LoginPage loginP=new LoginPage(driver);
    	String signUpText=loginP.verifySignUpText();
    	Assert.assertEquals(signUpText, "New User Signup!");
    	//User Information
    	String signUpName="Masood";
    	String signUpEmail="Masood1@gmail.com";
    	String gender="Mr";
    	String password="masood";
    	String dob="15-November-1999";
    	String fName="Masood";
    	String lName="Ahmed";
    	String company="Masood Automation Tester";
    	String address1="XYZ";
    	String address2="USA";
    	String country="United States";
    	String state="California";
    	String city="Sans Francisco";
    	String zipCode="8984";
    	String mobileNo="+1-790-888-588";
    	
    	loginP.enterSignUpName(signUpName);
    	loginP.enterSignUpEmailId(signUpEmail);
    	loginP.clickSignUpBtn();
    	
    	SignUpPage signUpP=new SignUpPage(driver);
    	String signUpInfoText=signUpP.verifySignUpText();
    	Assert.assertEquals(signUpInfoText, "ENTER ACCOUNT INFORMATION");
    	signUpP.clickTitle(gender);
    	Assert.assertEquals(signUpP.getUserName(),signUpName);
    	Assert.assertEquals(signUpP.getUserEmailId(),signUpEmail);
    	signUpP.enterPassword(password);
    	signUpP.selectDOB(dob);
    	signUpP.clickSignupLetters();
    	signUpP.clickSpecialOffers();
    	
    	//Address Information
    	signUpP.enterFName(fName);
    	signUpP.enterLName(lName);
    	signUpP.enterCompanyName(company);
    	signUpP.enterAddress1(address1);
    	signUpP.enterAddress2(address2);
    	signUpP.selectCountry(country);
    	signUpP.enterState(state);
    	signUpP.enterCity(city);
    	signUpP.enterZipCode(zipCode);
    	signUpP.enterMobileNumber(mobileNo);
    	signUpP.createAccount();
    	
    	//Account Created Page
    	AccountCreatedPage accntPage=new AccountCreatedPage(driver);
     	Assert.assertEquals(accntPage.verifyAccntCreatedMessag(),"ACCOUNT CREATED!");
     	accntPage.clickContinue();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+signUpName); 
    	homeP.deleteAccnt();
    	
    	//Account Deleted
    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
    	deletedPage.clickContinue();
    	
    }
    
    @Test(enabled=false)
    public void testCases_02() {
    	WebDriver driver=getDriver();
    	String loginEmail="masood1@gmail.com";
    	String password="masood";
    	String loginName="Masood Ahmed";
    	LandingPage lp=new LandingPage(driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickSignUpOrLoginBtn();
    	
    	LoginPage loginP=new LoginPage(driver);
    	Assert.assertEquals(loginP.verifyLoginText(), "Login to your account");
    	loginP.enterLoginEmailId(loginEmail);
    	loginP.enterLoginPassword(password);
    	loginP.clickLoginBtn();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+loginName); 
    	homeP.deleteAccnt();
    	
    	//Account Deleted
    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
    	deletedPage.clickContinue();
    }
    
    @Test
    public void testCases_03() {
    	
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-03 "+ Thread.currentThread().getId());
    	String loginEmail="masood1@gmail.com";
    	String password="masood233";
    	
    	LandingPage lp=new LandingPage(driver);
    	String homePageTitle=lp.verifyHomePage();
    	System.out.println("Test Cases-03 Get Url "+ driver.getCurrentUrl()+", Thread ID:"+Thread.currentThread().getId());
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	
    	lp.clickSignUpOrLoginBtn();
    	
    	LoginPage loginP=new LoginPage(driver);
    	Assert.assertEquals(loginP.verifyLoginText(), "Login to your account");
    	loginP.enterLoginEmailId(loginEmail);
    	loginP.enterLoginPassword(password);
    	loginP.clickLoginBtn();
    	
    	
    	//validate login failed message
    	Assert.assertEquals(loginP.verifyFailedText(), "Your email or password is incorrect!");
    	System.out.println("End Test");
    	
    	quitApp(driver);
    }
    
    @Test
    public void testCases_04() {
    
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-04 "+ Thread.currentThread().getId());
    	
    	String loginEmail="masood1@gmail.com";
    	String password="masood";
    	String loginName="Masood Ahmed";
    	
    	LandingPage lp=new LandingPage(driver);
    	System.out.println("Test Cases-04 Get Url "+ driver.getCurrentUrl()+", Thread ID:"+Thread.currentThread().getId());
    	String homePageTitle=lp.verifyHomePage();
    	
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	
    	lp.clickSignUpOrLoginBtn();
    	
    	LoginPage loginP=new LoginPage(driver);
    	Assert.assertEquals(loginP.verifyLoginText(), "Login to your account");
    	loginP.enterLoginEmailId(loginEmail);
    	loginP.enterLoginPassword(password);
    	loginP.clickLoginBtn();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+loginName);
    	homeP.logout();
    	
    	//Logout Page
    	LogoutPage  logoutP=new LogoutPage(driver);
    	String logoutTitle=logoutP.verifyLogoutPage(); 
    	System.out.println("url:"+logoutTitle);
    	SoftAssert softAssert=new SoftAssert();
    	softAssert.assertTrue(logoutTitle.contains("Signup / Login"));
    	Assert.assertTrue(logoutTitle.contains("Login"));
    	logoutP.navigateToLoginPage();
    	quitApp(driver);
    }
  
   
    @Test
    public void testCases_05() {
    
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-05"+ Thread.currentThread().getId());
    	
    	LandingPage lp=new LandingPage(driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickSignUpOrLoginBtn();
    	
    	LoginPage loginP=new LoginPage(driver);
    	String signUpText=loginP.verifySignUpText();
    	Assert.assertEquals(signUpText, "New User Signup!");
    	
    	String signUpEmail="masood1@gmail.com";
    	String signUpName="Masood";
    	
    	loginP.enterSignUpName(signUpName);
    	loginP.enterSignUpEmailId(signUpEmail);
    	loginP.clickSignUpBtn();
    	
    	//validate login failed message
    	Assert.assertEquals(loginP.verifyFailedText(), "Email Address already exist!");
    	quitApp(driver);
    }
    
    @Test
    public void testCases_06() {
    	
    	WebDriver driver=getDriver();
    	
    	System.out.println("Test Cases-06"+ Thread.currentThread().getId());
    
    	LandingPage lp=new LandingPage (driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickContactBtn();
    	
    	ContactUsPage cp=new ContactUsPage(driver);
    	String contactPageText=cp.verifyContactPageText();
    	Assert.assertEquals(contactPageText, "GET IN TOUCH");
    	
    	String name="Masood";
    	String email="masood1@gmail.com";
    	String subject="Appreciation Mail";
    	String message="Hi, I Hope you are doing well! I just wanted to thanks to the Automation team which developed"
    			+ " this application to help qa tester";
    	
    	String alertCommand="Ok";
    	String uploadFilePath="C:\\Users\\New\\Desktop\\TimeAway.txt";
    	System.out.println("File Path:"+uploadFilePath);
    	
    	cp.typeInputName(name);
    	cp.typeInputEmail(email);
    	cp.typeInputSubject(subject);
    	cp.typeInputMessage(message);
    	cp.uploadFile(uploadFilePath);
    	cp.clickSubmitsBtn();
    	cp.handleAlert(alertCommand);
    	
    	Assert.assertEquals(cp.verifySuccessMessage(), "Success! Your details have been submitted successfully.");
    	cp.clickHomeBtn();
    	
    	Assert.assertEquals(lp.verifyHomePage(), "Automation Exercise");
    	quitApp(driver);
    }
    
    @Test
    public void testCases_07() {
    	
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-07"+ Thread.currentThread().getId());
    	
    	LandingPage lp=new LandingPage (driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickTestCasesBtn();
    	
    	TestCasesPage tp=new TestCasesPage(driver);
    	String url=tp.verifyTestCasesPage();
    	Assert.assertTrue(url.contains("Test Cases"));
    	quitApp(driver);
    }
    
    @Test
    public void testCases_08() {
    	
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-08"+ Thread.currentThread().getId());
    	
    	LandingPage lp=new LandingPage (driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickProductsBtn();
    	
    	ProductsPage  pp=new ProductsPage(driver);
    	Assert.assertTrue(pp.verifyProductsPage().contains("Products"));
    	
    	pp.viewFirstProduct();
    	
    	
    	
    	ProductsDetailsPage pd=new ProductsDetailsPage(driver);
    	Assert.assertTrue(pd.verifyProductsDetailsPage().contains("Details"));
    	
    	System.out.println(pd.getTheProductsDetails());
    	quitApp(driver);
    	
    }
    
    @Test
    public void testCases_09() {
    	
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-09"+ Thread.currentThread().getId());
    	
    	LandingPage lp=new LandingPage (driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	lp.clickProductsBtn();
    	
    	ProductsPage  pp=new ProductsPage(driver);
    	Assert.assertTrue(pp.verifyProductsPage().contains("Products"));
    	
    	pp.typeSearchProductName("Dress");
    	pp.clickSearchProduct();
    	System.out.println(pp.getProductSearchText());
    	Assert.assertTrue(pp.getProductSearchText().contains("SEARCHED"));
    	
    	
    	
    	pp.getTheSearchedProducstInfo("Dress");
    	
    	quitApp(driver);
    	
    }
    
    @Test
    public void testCases_10() {
    	
    	WebDriver driver=getDriver();
    	System.out.println("Test Cases-10"+ Thread.currentThread().getId());
    	
    	LandingPage lp=new LandingPage (driver);
    	String homePageTitle=lp.verifyHomePage();
    	Assert.assertEquals(homePageTitle, "Automation Exercise");
    	
    	System.out.println(lp.verifySubscriptionText());
    	
    	Assert.assertTrue(lp.verifySubscriptionText().contains("SUBSCRIPTION"));
    	lp.typeSubscriberEmailId("masood@gmail.com");
    	lp.clickSubscribeBtn();
    	
    	System.out.println(lp.verifySuccessMessage());
    	
    	Assert.assertTrue(lp.verifySuccessMessage().contains("You have been successfully subscribed!"));
    	
    	quitApp(driver);
    }
    
    @Test
    public void testCases_11() {
    	
    	WebDriver driver=getDriver();
    	
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	lp.clickCartButton();
    	
    	CartPage cp=new CartPage(driver);
    	String subscriptionText=cp.verifySubscriptionText();
    	
    	Assert.assertTrue(subscriptionText.contains("SUBSCRIPTION"));
    	cp.typeSubscriberEmailId("masood@gmail.com");
    	cp.clickSubscribeBtn();
    	
    	System.out.println(cp.verifySuccessMessage());
    	
    	Assert.assertTrue(lp.verifySuccessMessage().contains("You have been successfully subscribed!"));
    	
    	quitApp(driver);
    }
  
    @Test
    public void testCases_12() {
    	WebDriver driver=getDriver();
    	
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	lp.clickProductsIconButton();
    	
    	ProductsPage pp=new ProductsPage(driver);
    	pp.addFirstProductToCart();
    	pp.clickContinueShopping();
    	pp.addSecondProductToCart();
    	pp.clickViewCart();
    	
    	CartPage cp=new CartPage(driver);
    	
    	int productsCount=cp.getAddedProductCount();
    	System.out.println("Count:"+productsCount);
    	
    	cp.getAddedProductDetails();
    	
    	quitApp(driver);
    	
    }
    
    @Test
    public void testCases_13() {
    	WebDriver driver=getDriver();
    	
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	lp.viewFirstProduct();
    	
    	ProductsDetailsPage pd=new ProductsDetailsPage(driver);
    	String pageTitle= pd.verifyProductsDetailsPage();
    	Assert.assertTrue(pageTitle.contains("Details"));
    	int addQuantity=10;
    	pd.addProductQuantity(addQuantity);
    	pd.clickAddCart();
    	pd.clickViewCart();
    	
    	CartPage cp=new CartPage(driver);
    	String strQuantity=cp.getFirstProductQuantity();
    	System.out.println("strQuantity:"+strQuantity);
    	int cartQuantity=Integer.parseInt(strQuantity);
    	System.out.println("cartQuantity:"+cartQuantity);
    	Assert.assertEquals(cartQuantity,addQuantity);

    	quitApp(driver);
    	
    }
    
    
    @Test
    public void testCases_14() {
    
    	WebDriver driver=getDriver();
    	
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	String productName="Beautiful Peacock Blue Cotton Linen Saree";
    	lp.addToCartProduct(productName);
    	lp.clickContinueShopping();
    	lp.clickCartButton();
    	
    	CartPage cp=new CartPage(driver);
    	String cartPageTitle= cp.verifyHomePage();
    	Assert.assertTrue(cartPageTitle.contains("Checkout"));
    	
    	cp.clickProceedToCheckout();
    	cp.clickRegisterOrLoginBtn();
    	
    	LoginPage loginP=new LoginPage(driver);
    	String signUpText=loginP.verifySignUpText();
    	Assert.assertEquals(signUpText, "New User Signup!");
    	//User Information
    	String signUpName="Masood";
    	String signUpEmail="Masood9@gmail.com";
    	String gender="Mr";
    	String password="masood";
    	String dob="15-November-1999";
    	String fName="Masood";
    	String lName="Ahmed";
    	String company="Masood Automation Tester";
    	String address1="XYZ";
    	String address2="USA";
    	String country="United States";
    	String state="California";
    	String city="Sans Francisco";
    	String zipCode="8984";
    	String mobileNo="+1-790-888-588";
    	
    	loginP.enterSignUpName(signUpName);
    	loginP.enterSignUpEmailId(signUpEmail);
    	loginP.clickSignUpBtn();
    	
    	SignUpPage signUpP=new SignUpPage(driver);
    	String signUpInfoText=signUpP.verifySignUpText();
    	Assert.assertEquals(signUpInfoText, "ENTER ACCOUNT INFORMATION");
    	signUpP.clickTitle(gender);
    	Assert.assertEquals(signUpP.getUserName(),signUpName);
    	Assert.assertEquals(signUpP.getUserEmailId(),signUpEmail);
    	signUpP.enterPassword(password);
    	signUpP.selectDOB(dob);
    	signUpP.clickSignupLetters();
    	signUpP.clickSpecialOffers();
    	
    	//Address Information
    	signUpP.enterFName(fName);
    	signUpP.enterLName(lName);
    	signUpP.enterCompanyName(company);
    	signUpP.enterAddress1(address1);
    	signUpP.enterAddress2(address2);
    	signUpP.selectCountry(country);
    	signUpP.enterState(state);
    	signUpP.enterCity(city);
    	signUpP.enterZipCode(zipCode);
    	signUpP.enterMobileNumber(mobileNo);
    	signUpP.createAccount();
    	
    	//Account Created Page
    	AccountCreatedPage accntPage=new AccountCreatedPage(driver);
     	Assert.assertEquals(accntPage.verifyAccntCreatedMessag(),"ACCOUNT CREATED!");
     	accntPage.clickContinue();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+signUpName); 
    	
    	lp.clickCartButton();
    	cp.clickProceedToCheckout();
    	
    	String Comment="Try to Deiver the order by monday";
    	
    	CheckoutPage cop=new CheckoutPage(driver);
    	cop.verifyAddressAndReviewOrderAreSame();
    	cop.typeComment(Comment);
    	cop.clickplaceOrderBtn();
    	
    	PaymentPage pp=new PaymentPage(driver);
    	String cardHolderName="Masood";
    	String cardNumber="8787 8977 7863";
    	String cardCVC="555";
    	String cardExpiryMonth="10";
    	String cardExpiryYear="2026";
    	
    	pp.typeCardHolderName(cardHolderName);
    	pp.typeCardNumber(cardNumber);
    	pp.typeCardCVC(cardCVC);
    	pp.typeCardExpiryMonth(cardExpiryMonth);
    	pp.typeCardExpiryYear(cardExpiryYear);

    	String orderSuccessMessage=pp.clickPayAndConfirmOrderMessage();
    	Assert.assertTrue(orderSuccessMessage.contains("successfully!"));

    	
    	PaymentDonePage pdp=new PaymentDonePage(driver);
    	String orderConfimationMessage=pdp.verifyOrderConfirmationMessage();
    	Assert.assertEquals(orderConfimationMessage, "Congratulations! Your order has been confirmed!");
    	pdp.clickContinueBtn();
    	
    	HomePage hp=new HomePage(driver); 
    	hp.deleteAccnt();
    	
    	//Account Deleted
    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
    	deletedPage.clickContinue();

    	quitApp(driver);
    	
    }
    
    @Test
    public void testCases_15() {
    
    	WebDriver driver=getDriver();
    	
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	lp.clickSignUpOrLoginBtn();

    	LoginPage loginP=new LoginPage(driver);
    	String signUpText=loginP.verifySignUpText();
    	Assert.assertEquals(signUpText, "New User Signup!");
    	//User Information
    	String signUpName="Masood";
    	String signUpEmail="Masood9@gmail.com";
    	String gender="Mr";
    	String password="masood";
    	String dob="15-November-1999";
    	String fName="Masood";
    	String lName="Ahmed";
    	String company="Masood Automation Tester";
    	String address1="XYZ";
    	String address2="USA";
    	String country="United States";
    	String state="California";
    	String city="Sans Francisco";
    	String zipCode="8984";
    	String mobileNo="+1-790-888-588";
    	
    	loginP.enterSignUpName(signUpName);
    	loginP.enterSignUpEmailId(signUpEmail);
    	loginP.clickSignUpBtn();
    	
    	
    	SignUpPage signUpP=new SignUpPage(driver);
    	String signUpInfoText=signUpP.verifySignUpText();
    	Assert.assertEquals(signUpInfoText, "ENTER ACCOUNT INFORMATION");
    	signUpP.clickTitle(gender);
    	Assert.assertEquals(signUpP.getUserName(),signUpName);
    	Assert.assertEquals(signUpP.getUserEmailId(),signUpEmail);
    	signUpP.enterPassword(password);
    	signUpP.selectDOB(dob);
    	signUpP.clickSignupLetters();
    	signUpP.clickSpecialOffers();
    	
    	//Address Information
    	signUpP.enterFName(fName);
    	signUpP.enterLName(lName);
    	signUpP.enterCompanyName(company);
    	signUpP.enterAddress1(address1);
    	signUpP.enterAddress2(address2);
    	signUpP.selectCountry(country);
    	signUpP.enterState(state);
    	signUpP.enterCity(city);
    	signUpP.enterZipCode(zipCode);
    	signUpP.enterMobileNumber(mobileNo);
    	signUpP.createAccount();
    	
    	//Account Created Page
    	AccountCreatedPage accntPage=new AccountCreatedPage(driver);
     	Assert.assertEquals(accntPage.verifyAccntCreatedMessag(),"ACCOUNT CREATED!");
     	accntPage.clickContinue();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+signUpName); 
    	
    	String productName="Beautiful Peacock Blue Cotton Linen Saree";
    	homeP.addToCartProduct(productName);
    	homeP.clickContinueShopping();
    	homeP.clickCartButton();	
    	
    	CartPage cp=new CartPage(driver);
    	String cartPageTitle= cp.verifyHomePage();
    	Assert.assertTrue(cartPageTitle.contains("Checkout"));
    	
    	cp.clickProceedToCheckout();
    	

    	String Comment="Try to Deiver the order by monday";
    	
    	CheckoutPage cop=new CheckoutPage(driver);
    	cop.verifyAddressAndReviewOrderAreSame();
    	cop.typeComment(Comment);
   
    	cop.clickplaceOrderBtn();
    	
    	PaymentPage pp=new PaymentPage(driver);
    	String cardHolderName="Masood";
    	String cardNumber="8787 8977 7863";
    	String cardCVC="555";
    	String cardExpiryMonth="10";
    	String cardExpiryYear="2026";
    	
    	pp.typeCardHolderName(cardHolderName);
    	pp.typeCardNumber(cardNumber);
    	pp.typeCardCVC(cardCVC);
    	pp.typeCardExpiryMonth(cardExpiryMonth);
    	pp.typeCardExpiryYear(cardExpiryYear);

    	String orderSuccessMessage=pp.clickPayAndConfirmOrderMessage();
    	Assert.assertTrue(orderSuccessMessage.contains("successfully!"));

    	
    	PaymentDonePage pdp=new PaymentDonePage(driver);
    	String orderConfimationMessage=pdp.verifyOrderConfirmationMessage();
    	Assert.assertEquals(orderConfimationMessage, "Congratulations! Your order has been confirmed!");
    	pdp.clickContinueBtn();
    	
    	HomePage hp=new HomePage(driver); 
    	hp.deleteAccnt();
    	
    	//Account Deleted
    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
    	deletedPage.clickContinue();
    	
    	quitApp(driver);
    	
    
    }

    
    //This test case helps to demonstrate the generic way of adding the products
    @Test
    public void testCases_Demo() {
    
    	WebDriver driver=getDriver();

    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	lp.clickProductsIconButton();
    	
    	ProductsPage pp=new ProductsPage(driver);
    	
    	String productName="Pure Cotton V-Neck T-Shirt";
    	pp.addToCartProduct(productName);
    	
    	
    	
    	
    }
}

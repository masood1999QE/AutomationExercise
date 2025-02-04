package SeleniumFrameWork.MavenProject;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	
    @Test
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
//    	homeP.deleteAccnt();
//    	
//    	//Account Deleted
//    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
//    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
//    	deletedPage.clickContinue();
//    	
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
    
    @Test
    public void testCases_16() {
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	lp.clickSignUpOrLoginBtn();
    	String loginName="Masood";
    	String loginEmail="Masood1@gmail.com";
    	String password="masood";
    	LoginPage loginP=new LoginPage(driver);
    	
    	Assert.assertEquals(loginP.verifyLoginText(), "Login to your account");
    	loginP.enterLoginEmailId(loginEmail);
    	loginP.enterLoginPassword(password);
    	loginP.clickLoginBtn();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+loginName); 
    
    	
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
    
    @Test
    public void testCases_17() {
    	
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	//Add products to the cart
    	String productName="Pure Cotton V-Neck T-Shirt";
    	lp.addToCartProduct(productName);
    	lp.clickContinueShopping();
    	
      	lp.clickCartButton();
    	
    	//Cart Page
    	CartPage cp=new CartPage(driver);
    	String cartPageTitle= cp.verifyHomePage();
    	Assert.assertTrue(cartPageTitle.contains("Checkout"));
    	
    	cp.deleteAddedProductDetails(productName);

     	boolean isProductAvailable=cp.checkProductDetails(productName);
     	System.out.println("isProductAvailable:"+isProductAvailable);
    	Assert.assertEquals(isProductAvailable, false);
    	
    	quitApp(driver);
    }
    
    @Test
    public void testCases_18() {
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	HomePage hp=new HomePage(driver);
    	Assert.assertEquals(hp.verifyCategoryIsVisible(),"CATEGORY");
    	String categoryName="WOMEN";
    	String clothesName="Dress";
    	hp.clickOnCategoryClothes(categoryName,clothesName);
    	
    	
    	
    	CategoryProductsPage  cpp=new CategoryProductsPage (driver);
    	String selectedCategoryTitle=cpp.verifySelectedCategoryClothesName();
    	System.out.println("selectedCategoryTitle:"+selectedCategoryTitle);
    	System.out.println("category name is displayed:"+selectedCategoryTitle.contains(categoryName));
    	System.out.println("clothes name is displayed:"+selectedCategoryTitle.contains(clothesName));
    	Assert.assertTrue(selectedCategoryTitle.contains(categoryName) && selectedCategoryTitle.contains(clothesName.toUpperCase()));
    	
    	String categoryName1="MEN";
    	String clothesName1="Jeans";
    	hp.clickOnCategoryClothes(categoryName1,clothesName1);
    	selectedCategoryTitle=cpp.verifySelectedCategoryClothesName();
    	System.out.println("selectedCategoryTitle:"+selectedCategoryTitle);
    	System.out.println("clothes name is displayed:"+selectedCategoryTitle.contains(clothesName));
    	Assert.assertTrue(selectedCategoryTitle.contains(categoryName1) && selectedCategoryTitle.contains(clothesName1.toUpperCase()));
    	
    	quitApp(driver);
    }
    
    @Test
    public void testCases_19() {

    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	lp.clickProductsBtn();
    	
    	ProductsPage pp=new ProductsPage(driver);
    	Assert.assertEquals(pp.verifyBrandTextIsVisible(),"BRANDS");
    	
    	String BrandName="Allen Solly Junior";
    	pp.clickOnBrandName(BrandName);
    	BrandProductsPage bpp=new BrandProductsPage (driver);
    	String selectedBrandTitle=bpp.verifySelectedBrandClothesNameIsVisible();
    	System.out.println("selectedBrandTitle:"+selectedBrandTitle);
    	System.out.println("Brand name is displayed:"+selectedBrandTitle.contains(BrandName));
    	Assert.assertTrue(selectedBrandTitle.contains("BRAND") && selectedBrandTitle.contains(BrandName.toUpperCase()));
    	
    	quitApp(driver);
    }
    
    @Test
    public void testCases_20() {
    
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	lp.clickProductsBtn();
     
    	ProductsPage pp=new ProductsPage(driver);
    	title=pp.verifyProductsPage();
    	Assert.assertTrue(title.contains("Products"));
    	
    	String searchProductName="jeans";
    	pp.typeSearchProductName(searchProductName);
    	pp.clickSearchProduct();
    	System.out.println(pp.getProductSearchText());
    	Assert.assertTrue(pp.getProductSearchText().contains("SEARCHED PRODUCTS"));
    	List<String> getSearchProductList=new ArrayList<>();
    	getSearchProductList=pp.getTheSearchedProducstInfo(searchProductName);
    	//check the product list has search product name
    	for(String productName:getSearchProductList)
    	{
    		System.out.println("Product list added is:"+productName);
    		Assert.assertTrue(productName.toLowerCase().contains(searchProductName.toLowerCase()));
    	}
    	
    	pp.addToCartSearchProducts(searchProductName);
    	
    	HomePage hp =new HomePage(driver);
    	hp.clickCartButton();
    	
    	CartPage cp=new CartPage(driver);
    	getSearchProductList=cp.getAddedProductDetails();
  
    	System.out.println("Before Login search Product added in the cart:"+cp.getAddedProductCount());
    	
    	for(String productName:getSearchProductList)
    	{
    		Assert.assertTrue(productName.toLowerCase().contains(searchProductName.toLowerCase()));
    	}
    	
    	lp.clickSignUpOrLoginBtn();
    	String loginName="Masood";
    	String loginEmail="Masood1@gmail.com";
    	String password="masood";
    	LoginPage loginP=new LoginPage(driver);
    	
    	Assert.assertEquals(loginP.verifyLoginText(), "Login to your account");
    	loginP.enterLoginEmailId(loginEmail);
    	loginP.enterLoginPassword(password);
    	loginP.clickLoginBtn();
    	
    	//Home Page
    	HomePage homeP=new HomePage(driver);
    	Assert.assertEquals(homeP.verifyUserIdName(), "Logged in as "+loginName); 
    	
    	hp.clickCartButton();
    	
    	getSearchProductList=cp.getAddedProductDetails();
    	  
    	for(String productName:getSearchProductList)
    	{
    		Assert.assertTrue(productName.toLowerCase().contains(searchProductName.toLowerCase()));
    	}
  
    	System.out.println("After Login search Product added in the cart:"+cp.getAddedProductCount());
    	
    	quitApp(driver);
    }
    
    @Test
    public void testCases_21() {
    	
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	lp.clickProductsBtn();
    	
    	ProductsPage pp=new ProductsPage(driver);
    	title=pp.verifyProductsPage();
    	Assert.assertTrue(title.contains("Products"));
    	String productName="Pure Cotton V-Neck T-Shirt";
    	pp.clickOnViewProduct(productName);
    	
    	ProductsDetailsPage pdp=new ProductsDetailsPage(driver);
    	Assert.assertEquals(pdp.verifyWriteYourReviewText(), "WRITE YOUR REVIEW"); 
    	
    	String inputName="Masood";
    	String inputEmailAddress="masood1@gmail.com";
    	String inputReview="Product Name";
    	
    	pdp.typeInputName(inputName);
    	pdp.typeEmailAddress(inputEmailAddress);
    	pdp.typeReview(inputReview);
    	pdp.clickReviewSubmitBtn();
    	
    	Assert.assertTrue(pdp.verifySuccessMessage().contains("Thank you for your review"));
    	quitApp(driver);
    	
    }
    
    @Test
    public void testCases_22() {
    	
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	HomePage hp=new HomePage(driver);
    	hp.moveToRecommendedItemsSection();
    	
    	Assert.assertEquals(hp.verifyRecommendedItemsText().toLowerCase(),"recommended items");
    	
    	
    	hp.getRecommendedProductListUpdate();
    	
    	hp.clickCartButton();
    	
    	List<String> getSearchProductList=new ArrayList<>();
    	CartPage cp=new CartPage(driver);
    	
    	getSearchProductList=cp.getAddedProductDetails();
    	  
    	System.out.println("Recommneded Product added in the cart:"+cp.getAddedProductCount());
    	
    	for(String productName:getSearchProductList)
    	{
    		System.out.println(productName);
    	}
    	
    	
    }
    
    @Test
    public void testCases_23() {
    	
    	//TestCases_23 is same as test case 15

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
    	
    	List<String> deliverAddresses=cop.getDeliveryAddress();
    	List<String> invoiceBillingAddresses=cop.getBillingAddress();
    	
    	 System.out.println("Verify the Delivery Address");
    	 for(String deliverAddress:deliverAddresses)
    	 {
    		 if (deliverAddress.contains(address1))
    		 {
    			 System.out.println(deliverAddress+" addess1 is found");
    		 }
    		 else if(deliverAddress.contains(address2))
    		 {
    			 System.out.println(deliverAddress+ " addess2 is found");
    		 }
    		 else if(deliverAddress.contains(country))
    		 {
    			 System.out.println(deliverAddress+" country is found");
    		 }
    		 else if(deliverAddress.contains(state) && deliverAddress.contains(city) && deliverAddress.contains(zipCode))
    		 {
    			 System.out.println(deliverAddress+" State,City & Zipcode are found");
    		 }
    		 else
    		 {
    			 System.out.println("Not Found" +deliverAddress);
    		 }
    	 }
    	
    	 
    	 System.out.println("Verify the Invoice Billing Address");
    	 for(String invoiceBillingAddress:invoiceBillingAddresses)
    	 {
    		 if (invoiceBillingAddress.contains(address1))
    		 {
    			 System.out.println(invoiceBillingAddress+" addess1 is found");
    		 }
    		 else if(invoiceBillingAddress.contains(address2))
    		 {
    			 System.out.println(invoiceBillingAddress+ " addess2 is found");
    		 }
    		 else if(invoiceBillingAddress.contains(country))
    		 {
    			 System.out.println(invoiceBillingAddress+" country is found");
    		 }
    		 else if(invoiceBillingAddress.contains(state) && invoiceBillingAddress.contains(city) && invoiceBillingAddress.contains(zipCode))
    		 {
    			 System.out.println(invoiceBillingAddress+" State,City & Zipcode are found");
    		 }
    		 else
    		 {
    			 System.out.println("Not Found" +invoiceBillingAddress);
    		 }
    	 }

    	HomePage hp=new HomePage(driver); 
//    	hp.deleteAccnt();
//    	
//    	//Account Deleted
//    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
//    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
//    	deletedPage.clickContinue();
//    	
//    	quitApp(driver);
//    	

    }
    
    @Test
    public void testCases_24() throws IOException {
    	

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
    	pdp.clickDownloadInvoice();
    	pdp.clickContinueBtn();
    	
    	//check downloaded file exists or not
    	File file=new File("C:/Users/New//Downloads/invoice.txt");
    	FileInputStream fs =new FileInputStream(file);
    	if(file.exists())
    	{
    		System.out.println("Invoice File downloaded successfully");
    		System.out.println("Read File Data");
    		int i ;
    		StringBuffer sb=new StringBuffer();
    		while((i=fs.read())!=-1)
    		{
    			sb.append((char)i);
    		}
    		System.out.println("Final Append String is :"+sb);
    		
    		Assert.assertTrue(sb.toString().contains("Hi Masood Ahmed, Your total purchase amount is"));
    		Assert.assertTrue(sb.toString().contains("Thank you"));
    		fs.close();
    	}
    	else
    	{
    		System.out.println("Invoice File is not found");
    	}
    	
    	HomePage hp=new HomePage(driver); 
    	hp.deleteAccnt();
    	
    	//Account Deleted
    	DeletedAccountPage deletedPage=new DeletedAccountPage(driver);
    	Assert.assertEquals(deletedPage.verifyAccntDeletedMsg(),"ACCOUNT DELETED!");
    	deletedPage.clickContinue();

    	quitApp(driver);

    }
    
    @Test
    public void testCases_25() {
    	
    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	lp.scrollToSubscriptionText();
    	lp.clickOnScrollUpBtn();
    	
    	Assert.assertEquals(lp.verifyMiddleCarouselText(),"Full-Fledged practice website for Automation Engineers");
    	
    }
    
    @Test
    public void testCases_26() {
    	

    	WebDriver driver=getDriver();
    	LandingPage lp=new LandingPage(driver);
    	String title=lp.verifyHomePage();
    	Assert.assertTrue(title.contains("Automation Exercise"));
    	
    	lp.scrollToSubscriptionText();
    	Assert.assertEquals(lp.verifySubscriptionText(),"SUBSCRIPTION");
    	// scroll up without using button
    	lp.scrollToMiddleCarouselText();
    	
    	Assert.assertEquals(lp.verifyMiddleCarouselText(),"Full-Fledged practice website for Automation Engineers");
    	
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
    	pp.clickContinueShopping();
    	
    	String productName1="Beautiful Peacock Blue Cotton Linen Saree";
    	pp.addToCartProduct(productName1);
    	pp.clickContinueShopping();
    	
    	
    	
    	
    }
}

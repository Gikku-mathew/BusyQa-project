package com.webappsecurity.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.webappsecurity.pages.HomePage;
import com.webappsecurity.pages.LoginPage;
import com.webappsecurity.pages.PayBillsPage;

public class PayBillsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	PayBillsPage payBillsPage;
	
	@Test
	public void validatePayBillsPayeetextTest() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		String actualText= payBillsPage.validatePayeeText("sprint");
		System.out.println(actualText);
		Assert.assertEquals("For 12119415161214 Sprint account",actualText );
		System.out.println("test passed");
	}
	@Test
	public void verifyEnterAmountFields() {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		if(payBillsPage.verifyAmountTextField()==true) {
			payBillsPage.verifyEnterAmountFields("1000");
		}
		logger.info("entered 1000 into amount box");
	}
	
	@Test
	public void verifyEnterDescriptionFields() {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		if(payBillsPage.verifyDescriptionTextField()==true) {
			payBillsPage.verifyEnterDescriptionField("hellooo");
		}
		logger.info("entered message into descripton box");
	}
	@Test
	public void verifyEnterDate() {
		homepage = new HomePage(driver);
		homepage.clickSigninButton();
		loginpage=new LoginPage(driver);
		loginpage.enterCredentials("username", "password");
		payBillsPage=new PayBillsPage(driver);
		payBillsPage.validateClickOnPayBills();
		payBillsPage.validateCalender("2020-09-12");
		logger.info("checked calender field");
	}
	
}


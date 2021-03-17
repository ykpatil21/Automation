package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.ContactsPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contact;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void Setup(){
		initialization();	
		testutil=new TestUtil();
		 loginPage=new LoginPage();	
		 contact=new ContactsPage();
		 homepage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTest(){
		String Homepagetitle=homepage.VerifyHomePagetitle();
		Assert.assertEquals(Homepagetitle, "Cogmento CRM","Home Page title not matched");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homepage.verifyCorrectusername());
	}
	
	@Test(priority=3)
	public void verifyContactlinktest(){
		contact=homepage.ClickonContact();
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

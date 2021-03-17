package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.ContactsPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contact;
	String Sheetname="Contact";
	
	public ContactPageTest(){
		super();
	}

	@BeforeMethod
	public void Setup(){
		initialization();	
		testutil=new TestUtil();
		 loginPage=new LoginPage();	
		 contact=new ContactsPage();
		 homepage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		 contact=homepage.ClickonContact();
	}
	
	@Test(priority=1)
	public void verifyContactlable(){
		Assert.assertTrue(contact.verifycontactlable(), "Contact lable is missing");	
	}
	
	@Test(priority=2)
	public void SelectContactTest(){
		contact.selectContact();	
	}
	
	@DataProvider
	public Object[][] getCRMtestData(){
		Object data[][]=TestUtil.getTestData(Sheetname);
		return data;
		
	}
	
	
//	@Test(priority=3,dataProvider="getCRMtestData")
//	public void ValidateCreatenewcontact(String fname,String lname,String mname){
//		homepage.clickonnewcontactlink();
//		contact.CreateNewContact(fname,lname,mname);
//	}
	
	
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	
	
	
}

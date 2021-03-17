package com.app.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	
	public  LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void Setup(){
		initialization();	
		 loginPage=new LoginPage();	
	}
	
	
	@Test
	public void LoginPageTitleTest(){
	  String Title=loginPage.validateLoginPageTitle();
	  Assert.assertEquals(Title, "#1 Free CRM customer relationship management software cloud");
	  System.out.println(driver.getTitle());
	}
	
	@Test
	public void logintest(){
		homepage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}

package com.app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page factort-Object repository
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement Loginbutton;
	
	@FindBy(name="email") 
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	//Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	public HomePage login(String user,String pwd){
		Loginbutton.click();
		Username.sendKeys(user);
		Password.sendKeys(pwd);
		LoginButton.click();
		System.out.println(driver.getTitle());
		
		return new HomePage();
		
	}
	
	
}

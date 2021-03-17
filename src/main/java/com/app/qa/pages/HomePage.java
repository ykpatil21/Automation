package com.app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//*[@id='top-header-menu']/div[2]/span[1]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement Contact;
	
	@FindBy(xpath="//*[@id='main-nav']/div[3]/button/i")
	WebElement NewContact;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Deals;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Tasks;
	
	//Initializing the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePagetitle(){
		return driver.getTitle();	
	}
	
	public boolean verifyCorrectusername(){
		return usernamelabel.isDisplayed();
		
	}
	
	
	public ContactsPage ClickonContact(){
		Contact.click();
		return new ContactsPage();
	}
	
	public DealsPage Dealslink(){
		Deals.click();
		return new DealsPage();
	}
	
	public TaskPage Taskpagelink(){
		Tasks.click();
		return new TaskPage();
	}
	
	
	public void clickonnewcontactlink(){
		Actions action=new Actions(driver);
		action.moveToElement(Contact).build().perform();
		NewContact.click();
	
	}

}

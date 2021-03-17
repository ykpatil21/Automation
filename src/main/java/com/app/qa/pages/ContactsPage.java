package com.app.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[1]")
	WebElement contactlable;
	
	@FindBy(xpath="//a[text()='Sharad Patil']//parent::td[@class]//preceding-sibling::td[@class]//input[@name='id']")
	WebElement contactchecbox;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middlename;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement Savebtn;
	
	
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactlable(){
		return contactlable.isDisplayed();	
	}

	public void selectContact() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contactchecbox.click();
		//driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class]//preceding-sibling::td[@class]//input[@name='id']")).click();
		
	}
	
	
	public void CreateNewContact(String fname,String lname,String mname){
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		middlename.sendKeys(mname);
		Savebtn.click();
	
	}
	
}

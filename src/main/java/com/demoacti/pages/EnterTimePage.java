package com.demoacti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoacti.base.DriverScript;

/**
 * 
 * @Name : EnterTimePage
 * @author : Gayathri Reviewed by : Gayathri Created Date : 06/30/2022 Updated
 *         Date : Description :This Class is reponsible for the driver related
 *         activities
 *
 * 
 */






public class EnterTimePage extends DriverScript {

//***************************Page Elements***********************
	@FindBy(id= "logoutLink") WebElement linkLogout; 
	@FindBy(xpath = "//a[@class='content tasks']") WebElement menuTask;
	
	
//	*********************************************Page Initialization***********************************************
	// The purpose of page factory class is to initialize the page elements during the run time of the program
	//This is also called as lazy initialization ---> as long as this not called, this will not be used.
	public EnterTimePage() {
		PageFactory.initElements(driver, this);
	}	
	
//***************************************Page Actions***********************************************
	
	public void clickLogout() {
		linkLogout.click();
	}
	
	public String getEnterTimePageTitle() {
		return driver.getTitle();
	}
	
	public void clickTaskMenu()
	{
		menuTask.click();
	}
	
	
}

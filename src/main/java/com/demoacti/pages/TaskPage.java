package com.demoacti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoacti.base.DriverScript;
import com.demoacti.utils.Helper;

public class TaskPage extends DriverScript {
	//***************************Page Elements***********************
		@FindBy(xpath="//div[@class='title ellipsis']") WebElement buttonAddNew;
		@FindBy(xpath="//div[@class='item createNewCustomer' ]") WebElement buttonitemNewCustomer;
		@FindBy(xpath ="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") WebElement textboxCustomerName;
		@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']") WebElement textareaDescription;
		@FindBy(xpath="//div[contains(text(),'Create Customer')]") WebElement buttonCreateCustomer;
		@FindBy(xpath="//span[@class='innerHtml']") WebElement textSuccessMessage;
		@FindBy(xpath="(//input[@placeholder='Start typing name ...'])[1]") WebElement textboxStartTyping;
		//@FindBy(xpath="//div[@class='filteredcontainer']//div[@class='title']") WebElement searchedCustomer;
		@FindBy(xpath="//span[@class='highlightToken']") WebElement searchedCustomer;
		@FindBy(xpath= "//div[@class='titleEditButtonContainer']//div[@class='editButton']") WebElement buttonEdit;
		@FindBy(xpath="//div[@class='editCustomerPanelHeader']//div[@class='action'][normalize-space()='ACTIONS']") 
		WebElement buttonAction;
		@FindBy(xpath="//div[@class='taskManagement_customerPanel']//div[@class='title'][normalize-space()='Delete']")
		WebElement buttonDelete;
		@FindBy(xpath="//span[normalize-space()='Delete permanently']") WebElement buttonDeletePermanently;
		
		
		
//		*********************************************Page Initialization***********************************************
		// The purpose of page factory class is to initialize the page elements during the run time of the program
		//This is also called as lazy initialization ---> as long as this not called, this will not be used.
		public TaskPage() {
			PageFactory.initElements(driver, this);
		}	

	public void clickAddnew() {
		buttonAddNew.click();
	
	}
	
	public void clickNewCustomer() {
		buttonitemNewCustomer.click();
	
	}
	
	public void enterCustomerName(String customername) {
		textboxCustomerName.sendKeys(customername);
	}
	
	public void enterCustomerDescription(String custdescription) {
		textareaDescription.sendKeys(custdescription);
	}
	
	public void clickCreateCustomer() {
		buttonCreateCustomer.click();
	}
	
	public String getSuccessMessage() {
		return textSuccessMessage.getText();
	}
	
	public String getTaskPageTitle() {
		return driver.getTitle();
	}
	
	public void enterCustomerType(String customername) {
		textboxStartTyping.sendKeys(customername);
	}
	
	public void clickSearchedCustomer()
	{
		searchedCustomer.click();
	}
	
	public void clickEditButton() {
		buttonEdit.click();
		Helper.sleep();
	}
	
	public void clickAction() {
		buttonAction.click();
		Helper.sleep();
	}
	
	public void clickDelete() {
		buttonDelete.click();
	}
	
	public void clickDeletePermanently() {
		buttonDeletePermanently.click();
		
	}
	
	
}

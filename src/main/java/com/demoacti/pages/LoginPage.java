package com.demoacti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoacti.base.DriverScript;

public class LoginPage extends DriverScript {
//***************************************Page Elements***********************************************
	@FindBy(id = "username") WebElement textboxUsername;
	@FindBy(name = "pwd") WebElement textboxPassword;
	@FindBy(id = "loginButton") WebElement buttonLogin; 
	@FindBy(id = "toPasswordRecoveryPageLink") WebElement linkForgotPassword;
	@FindBy(xpath = "//div[@class='atLogoImg']") WebElement imgActilogo;
	@FindBy(id = "keepLoggedInCheckBox") WebElement radiobuttonKeepMeLoggedIn; 
	@FindBy(xpath = "//span[text()='Username or Password is invalid. Please try again.'] ") WebElement errMessage;
	
//	*********************************************Page Initialization***********************************************
	// The purpose of page factory class is to initialize the page elements during the run time of the program
	//This is also called as lazy initialization ---> as long as this not called, this will not be used.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//***************************************Page Actions***********************************************
	
public void enterUsername(String username)	
{
	textboxUsername.sendKeys(username);
}
	
public void enterPassword(String password) {
	textboxPassword.sendKeys(password);
}

public void clickLogin()
{
	buttonLogin.click();
	
}

public boolean isForgotPasswordLinkDisplayed() {
	return linkForgotPassword.isDisplayed();
}

public boolean isActiLogoDisplayed() {
	return imgActilogo.isDisplayed();
}

public void clickKeepMeLoggedIn() {
	radiobuttonKeepMeLoggedIn.click();
}

public String getLoginPageTitle() {
	return driver.getTitle();
}

public String isErrorMessageDisplayed() {
	return errMessage.getText();
}

}

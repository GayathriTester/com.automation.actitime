package com.demoacti.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest{
	
	
	
	@Test
	public void testLoginPageTitle() {
		
		String actual = "actiTIME - Login";
		String expected = loginpage.getLoginPageTitle();
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void testForgotPasswordlinkDisplayed() {
		
		boolean flag = loginpage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
	}
	@Test
	public void testLogoDisplayed() {
		
	boolean	flag = loginpage.isActiLogoDisplayed();
	Assert.assertTrue(flag);
	}
	
	@Test
	public void testLogin() {
		
		loginpage.enterUsername("admin");
		loginpage.enterPassword("manager");
		loginpage.clickKeepMeLoggedIn();
		loginpage.clickLogin();
	}
	
}

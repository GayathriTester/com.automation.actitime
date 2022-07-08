package com.demoacti.tests;

import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

	
	@Test(dataProvider = "actidata")
	public void testLogin(String username,String password) {
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickKeepMeLoggedIn();
		loginpage.clickLogin();
	}
}

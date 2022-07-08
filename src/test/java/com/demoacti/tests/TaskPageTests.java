package com.demoacti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {

	@Test(priority = 1)
	public void testCreateCustomer() {
		loginpage.enterUsername("admin");
		loginpage.enterPassword("manager");
		loginpage.clickLogin();
		entertimepage.clickTaskMenu();
		taskpage.clickAddnew();
		taskpage.clickNewCustomer();
		taskpage.enterCustomerName("TestUser1");
		taskpage.enterCustomerDescription("For Testing1");
		taskpage.clickCreateCustomer();
		taskpage.getSuccessMessage();
		String successmessage = taskpage.getSuccessMessage();
		System.out.println(successmessage);
		Assert.assertTrue(successmessage.contains("has been created"));
		entertimepage.clickLogout();
	}

	@Test(priority = 2)
	public void testDeleteCustomer() {
		loginpage.enterUsername("admin");
		loginpage.enterPassword("manager");
		loginpage.clickLogin();
		entertimepage.clickTaskMenu();
		taskpage.enterCustomerType("TestUser1");
		taskpage.clickSearchedCustomer();
		taskpage.clickEditButton();
		taskpage.clickAction();
		taskpage.clickDelete();
		taskpage.clickDeletePermanently();
		String successmessage = taskpage.getSuccessMessage();
		System.out.println(successmessage);
		Assert.assertTrue(successmessage.contains("has been deleted"));
		entertimepage.clickLogout();

	}

}

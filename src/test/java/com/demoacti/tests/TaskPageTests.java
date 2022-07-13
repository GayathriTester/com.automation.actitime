package com.demoacti.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {

	@Test(priority = 1)
	public void testCreateCustomer() {
		
		Logger = report.createTest("Test Creating New Customer");
		loginpage.enterUsername("admin");
		Logger.pass("entered username");
		loginpage.enterPassword("manager");
		Logger.pass("entered password");
		loginpage.clickLogin();
		Logger.pass("Clicked Login");
		entertimepage.clickTaskMenu();
		Logger.pass("Clicked TaskNew");
		taskpage.clickAddnew();
		Logger.pass("Clicked  AddNewButton");
		taskpage.clickNewCustomer();
		Logger.pass("Clicked AddNewCustomer");
		taskpage.enterCustomerName("TestUser1");
		Logger.pass("entered CustomerName");
		taskpage.enterCustomerDescription("For Testing1");
		Logger.pass("entered customerdescription");
		taskpage.clickCreateCustomer();
		Logger.pass("clicked create customer");
		taskpage.getSuccessMessage();
		String successmessage = taskpage.getSuccessMessage();
		System.out.println(successmessage);
		Assert.assertTrue(successmessage.contains("has been created"));
		Logger.pass("Created Customer Successfully");
		entertimepage.clickLogout();
		Logger.pass("Clicked Logout");
	}

	@Test(priority = 2)
	public void testDeleteCustomer() {
		loginpage.enterUsername("admin");
		Logger.pass("entered username");
		loginpage.enterPassword("manager");
		Logger.pass("entered password");
		loginpage.clickLogin();
		Logger.pass("Clicked Login");
		entertimepage.clickTaskMenu();
		Logger.pass("Clicked TaskMenu");
		taskpage.enterCustomerType("TestUser1");
		Logger.pass("entered CustomerType");
		taskpage.clickSearchedCustomer();
		Logger.pass("clicked Search Customer");
		taskpage.clickEditButton();
		Logger.pass("Clicked EditButton");
		taskpage.clickAction();
		Logger.pass("Clicked Action Button");
		taskpage.clickDelete();
		Logger.pass("Clicked Delete Button");
		taskpage.clickDeletePermanently();
		Logger.pass("Clicked Delete Permanently");
		String successmessage = taskpage.getSuccessMessage();
		System.out.println(successmessage);
		Assert.assertTrue(successmessage.contains("has been deleted"));
		Logger.pass("has been deleted");
		entertimepage.clickLogout();
		Logger.pass("Clicked Logout");

	}

}

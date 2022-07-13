package com.demoacti.tests;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demoacti.base.DriverScript;
import com.demoacti.pages.EnterTimePage;
import com.demoacti.pages.LoginPage;
import com.demoacti.pages.TaskPage;
import com.demoacti.utils.ExcelUtils;
import com.demoacti.utils.Helper;



public class BaseTest extends DriverScript {
	protected static ExtentReports report;
	protected static ExtentTest Logger;
	LoginPage loginpage ;
	EnterTimePage entertimepage;
	TaskPage taskpage;
	
	@BeforeSuite
	public void setReport() {
		ExtentHtmlReporter extent= new ExtentHtmlReporter("./acreports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	
	
	@BeforeMethod
	public void setup() {
		initApplication();
		loginpage = new LoginPage();
	 entertimepage = new EnterTimePage();
	taskpage = new TaskPage();
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE)
		{
			try {
				Logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		report.flush();
		Helper.sleep();
		
		quitDriver();
	}
	
	
	@DataProvider(name = "actidata")
	public Object[][] testData() {

		ExcelUtils x1 = new ExcelUtils("./actestdata/actidata.xlsx");
		int rows = x1.getLastRowCount(0); // active row numbers
		Object[][] data = new Object[rows][2]; //

		for (int i = 0; i < rows; i++) {
			data[i][0] = x1.getCellData(0, i, 0);
			data[i][1] = x1.getCellData(0, i, 1);
		}

		return data;
	}

}

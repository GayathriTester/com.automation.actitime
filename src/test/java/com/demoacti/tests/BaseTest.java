package com.demoacti.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.demoacti.base.DriverScript;
import com.demoacti.pages.EnterTimePage;
import com.demoacti.pages.LoginPage;
import com.demoacti.pages.TaskPage;
import com.demoacti.utils.ExcelUtils;



public class BaseTest extends DriverScript {
	LoginPage loginpage ;
	EnterTimePage entertimepage;
	TaskPage taskpage;
	
	
	@BeforeMethod
	public void setup() {
		initApplication();
		loginpage = new LoginPage();
	 entertimepage = new EnterTimePage();
	taskpage = new TaskPage();
		
	}
	
	@AfterMethod
	public void teardown() {
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

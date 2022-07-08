package com.demoacti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @Name : DriverScript
 * @author : Gayathri Reviewed by : Gayathri Created Date : 06/30/2022 Updated
 *         Date : Description :This Class is reponsible for the driver related
 *         activities
 *
 * 
 */

public class DriverScript {

	public static WebDriver driver;
	Properties prop;

	public DriverScript() { // configuration properties
		try {

			File file = new File("./acconfig/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}

		catch (Exception e) {
			System.out.println("Unable to load the properties file : + e.getMessage()");
		}
	}

	public void initApplication() {
		String browser = prop.getProperty("browser"); // Always ensure to remove the @TEST and its import file after
														// unit testing
		if (browser.trim().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./acbrowser/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.trim().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./acbrowser/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.trim().equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./acbrowser/msedgedriver.exe");
			driver = new EdgeDriver();

		}

		else {
			System.err.println("Browser name is not provied. please check the config file");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getURL();
	}

	public void getURL() {
		String url = prop.getProperty("url");
		driver.get(url);
	}

	public void quitDriver() {
		driver.close();
	}

}

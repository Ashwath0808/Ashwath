package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Unf_016POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderDelete {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Unf_016POM orderDelete;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		orderDelete=new Unf_016POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
	 
	@Test(priority=2)
	public void VaildOrderDelete() throws Exception {
		orderDelete.clickCart();
		orderDelete.clickOrder();
		Thread.sleep(5000);
		orderDelete.selectOrdernum();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		orderDelete.clickDeleteorder();
		
	}
	
	

}

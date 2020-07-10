package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UNF_047POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrder {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private UNF_047POM filterorder;
	
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		filterorder=new UNF_047POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
	@Test(priority=2)
	public void filterOrderTest() throws Exception {
		filterorder.clickCart();//click on cart
		filterorder.clickOrder();//click on order
		filterorder.enterOrder("473");//Filter by Entering OrderID
		Thread.sleep(3000);
		filterorder.orderStatus();//Filter Order status as Pending
		filterorder.dateAdded("2020-07-06");//Filter by "Date Added"
		filterorder.customerName("Payal Uttamani");//Filter by CustomerName
		filterorder.TotalAmount("525");//Filter by Total Amount
		filterorder.DateModified("2020-07-03");//Filter by "Date modified"
	}
}
